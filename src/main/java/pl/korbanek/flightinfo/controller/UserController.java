package pl.korbanek.flightinfo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.korbanek.flightinfo.api.WeatherAPI;
import pl.korbanek.flightinfo.functionality.CurrentUser;
import pl.korbanek.flightinfo.functionality.DistanceCalculator;
import pl.korbanek.flightinfo.converter.FlightDTOConverter;
import pl.korbanek.flightinfo.dto.FlightCreateDTO;
import pl.korbanek.flightinfo.dto.FlightListDTO;
import pl.korbanek.flightinfo.dto.UserDetailsDTO;
import pl.korbanek.flightinfo.entity.Airport;
import pl.korbanek.flightinfo.entity.FlightDetails;
import pl.korbanek.flightinfo.entity.Plane;
import pl.korbanek.flightinfo.entity.User;
import pl.korbanek.flightinfo.repository.FlightDetailsRepository;
import pl.korbanek.flightinfo.service.AirportService;
import pl.korbanek.flightinfo.service.FlightDetailsService;
import pl.korbanek.flightinfo.service.PlaneService;
import pl.korbanek.flightinfo.serviceImpl.UserServiceImpl;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final AirportService airportService;
    private final PlaneService planeService;
    private final FlightDetailsService flightDetailsService;
    private final UserServiceImpl userServiceImpl;

    @GetMapping("/flightplan")
    public String flightPlanMainPage(Model model){
        List<Airport> airportsList = airportService.findAll();
        List<Plane> planesList = planeService.findAll();
        model.addAttribute("airports", airportsList);
        model.addAttribute("planes", planesList);
        model.addAttribute("flightDetailsDTO", new FlightCreateDTO());
        return "/flightPlan";
    }

    @PostMapping("/flightplan")
    public String flightPlanResults(@ModelAttribute("flightDetailsDTO")
                                        @Valid FlightCreateDTO flightCreateDTO,
                                    BindingResult bindingResult,
                                    @AuthenticationPrincipal CurrentUser currentUser,
                                    Model model){
        if(bindingResult.hasErrors()){
            List<Airport> airportsList = airportService.findAll();
            List<Plane> planesList = planeService.findAll();
            model.addAttribute("airports", airportsList);
            model.addAttribute("planes", planesList);
            model.addAttribute("bindingResult", bindingResult);
            return "flightPlan";
        } else {
            FlightDTOConverter flightDTOConverter = new FlightDTOConverter();
            FlightDetails flightDetails = flightDTOConverter.convert(flightCreateDTO);

            DistanceCalculator distanceCalculator = new DistanceCalculator(airportService);
            double distance = distanceCalculator.distance(flightDetails);

            flightDetails.setDistance(Math.round(distance / 1000)); //saving distance in km
            flightDetails.setFlight_time(Math.round((60 * distance / 1000) / (flightDetails.getSpeed() * 1.852)));

            User loggedUser = currentUser.getUser();
            flightDetails.setUser(loggedUser);

            flightDetailsService.save(flightDetails);

            return "redirect:/user/flightdetails/" + flightDetails.getId();
        }
    }
    @GetMapping("/flightdetails/{id}")
    public String flightDetails(@PathVariable("id") long id, @AuthenticationPrincipal CurrentUser currentUser, Model model) throws IOException, InterruptedException {
        //Getting single flights details using FlightListDto method nr.2 (compare by id)
        FlightListDTO flightListDTO = new FlightListDTO(flightDetailsService);
        FlightListDTO singleFlight = flightListDTO.singleFlightDetails(currentUser, id);
        WeatherAPI weatherAPI = new WeatherAPI(airportService);
        String departure_code = singleFlight.getDeparture_code();
        String arrival_code = singleFlight.getArrival_code();
        List<String> departure = weatherAPI.checkWeather(departure_code);
        List<String> arrival = weatherAPI.checkWeather(arrival_code);

        model.addAttribute("flightDetails", singleFlight);
        model.addAttribute("departure", departure);
        model.addAttribute("arrival", arrival);

        return "flightDetails";
    }


    @GetMapping("/plans")
    public String userSavedFlightPlans(@AuthenticationPrincipal CurrentUser currentUser,
                                       Model model){
        FlightListDTO flightListDTO = new FlightListDTO(flightDetailsService);
        List<FlightListDTO> flights = flightListDTO.getFlightList(currentUser);
        model.addAttribute("flights", flights);
        return "userPlans";
    }

    @GetMapping("accountdetails")
    public String userAccountDetails(Model model, @AuthenticationPrincipal CurrentUser currentUser){
        UserDetailsDTO userDetailsDTO = new UserDetailsDTO(userServiceImpl);
        UserDetailsDTO userDetails = userDetailsDTO.getUserDetails(currentUser);
        List<FlightDetails> flightDetailsById = flightDetailsService.findFlightDetailsOfUser(currentUser.getUser());

        model.addAttribute("userDetails", userDetails);
        model.addAttribute("numberOfPlans", flightDetailsById.size());
        return "userDetails";
    }

    @GetMapping("/author")
    public String author(){
        return "authorText";
    }

    @GetMapping("/removeflight/{id}")
    public String removeFlight(@PathVariable("id") long id){
        flightDetailsService.removeFlightWithId(id);
        return "redirect:/user/plans";
    }
}
