package pl.korbanek.flightinfo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.korbanek.flightinfo.CurrentUser;
import pl.korbanek.flightinfo.DistanceCalculator;
import pl.korbanek.flightinfo.entity.Airport;
import pl.korbanek.flightinfo.entity.FlightDetails;
import pl.korbanek.flightinfo.entity.Plane;
import pl.korbanek.flightinfo.entity.User;
import pl.korbanek.flightinfo.repository.AirportRepository;
import pl.korbanek.flightinfo.repository.FlightDetailsRepository;
import pl.korbanek.flightinfo.repository.PlaneRepository;
import pl.korbanek.flightinfo.service.AirportService;
import pl.korbanek.flightinfo.service.PlaneService;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final AirportRepository airportService;
    private final FlightDetailsRepository flightDetailsRepository;
    private final PlaneService planeService;

    @GetMapping("/flightplan")
    public String flightPlanMainPage(Model model){

        //default airports list
        List<Airport> defaults = new ArrayList<>();
        defaults.add(new Airport(1, "EPPI", 53.1, 16.42));
        defaults.add(new Airport(2, "EPDE", 51.33, 21.53));
        defaults.add(new Airport(3, "EPPO", 52.25, 16.49));
        defaults.add(new Airport(4, "EPWA", 52.09, 20.58));
        airportService.saveAll(defaults);

        //default planes list
        List<Plane> planes = new ArrayList<>();
        planes.add(new Plane(1,"Cessna 152"));
        planes.add(new Plane(2,"Diamond DA20"));
        planes.add(new Plane(3,"Piper PA28"));
        planes.add(new Plane(4,"Tecnam P2008"));
        planeService.saveAll(planes);

        List<Airport> airportsList = airportService.findAll();
        List<Plane> planesList = planeService.findAll();
        model.addAttribute("airports", airportsList);
        model.addAttribute("planes", planesList);
        model.addAttribute("flightDetails", new FlightDetails());
        return "/flightPlan";
    }

    @PostMapping("/flightplan")
    public String flightPlanResults(FlightDetails flightDetails,
                                    @AuthenticationPrincipal CurrentUser currentUser){
        double departureLattitude =
                airportService.findAirportByIcaoCode(flightDetails.getDeparture_code()).getLattitude();
        double departureLongitude =
                airportService.findAirportByIcaoCode(flightDetails.getDeparture_code()).getLongitude();
        double arrivalLattitude =
                airportService.findAirportByIcaoCode(flightDetails.getArrival_code()).getLattitude();
        double arrivalLongitude =
                airportService.findAirportByIcaoCode(flightDetails.getArrival_code()).getLongitude();

        DistanceCalculator distanceCalculator = new DistanceCalculator();
        double distance = distanceCalculator.distance(departureLattitude, arrivalLattitude, departureLongitude, arrivalLongitude, 90, 90);

        flightDetails.setDistance(distance/1000); //saving distance in km
        flightDetails.setFlight_time((distance/1000)/(flightDetails.getSpeed()*1.852));

        User loggedUser = currentUser.getUser();
        flightDetails.setUser(loggedUser);
        flightDetailsRepository.save(flightDetails);

        return "/flightDetails";
    }

    @GetMapping("plans")
    public String userSavedFlightPlans(Model model){

        return "userPlans";
    }

    @GetMapping("accountdetails")
    public String userAccountDetails(Model model){
        return "userDetails";
    }

}
