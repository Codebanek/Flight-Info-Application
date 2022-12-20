package pl.korbanek.flightinfo.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.korbanek.flightinfo.api.AirportAPI;
import pl.korbanek.flightinfo.functionality.CurrentUser;
import pl.korbanek.flightinfo.dto.UserDetailsDTO;
import pl.korbanek.flightinfo.entity.FlightDetails;
import pl.korbanek.flightinfo.service.AirportService;
import pl.korbanek.flightinfo.service.FlightDetailsService;
import pl.korbanek.flightinfo.serviceImpl.UserServiceImpl;
import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UserServiceImpl userServiceImpl;
    private final FlightDetailsService flightDetailsService;

    private final AirportService airportService;

    @GetMapping("")
    public String basicRedirect(){
        return "admin/adminConsole";
    }

    @GetMapping("/allusers")
    public String allUsers(Model model, @AuthenticationPrincipal CurrentUser currentUser){
        UserDetailsDTO userDetailsDTO = new UserDetailsDTO(userServiceImpl);
        List<UserDetailsDTO> allUsers = userDetailsDTO.getAllUsers();
        model.addAttribute("users", allUsers);
        model.addAttribute("adminId", currentUser.getUser().getId());
        return "allUsers";
    }
    @GetMapping("/allplans")
    public String allPlans(Model model){
        List<FlightDetails> allFlights = flightDetailsService.allFlights();
        model.addAttribute("flights", allFlights);
        return "allFlights";
    }

    @GetMapping("/removeuser/{id}")
    public String removeUser(@PathVariable("id") long id, @AuthenticationPrincipal CurrentUser currentUser){
        if(id == currentUser.getUser().getId()){
            return "/allUsers";
        } else{
            userServiceImpl.removeUserWithId(id);
            return "redirect:/admin/allusers";
        }
    }

    @GetMapping("/removeflight/{id}")
    public String removePlan(@PathVariable("id") long id){
        flightDetailsService.removeFlightWithId(id);
        return "redirect:/admin/allplans";
    }

    @GetMapping("/airports")
    public String updateAirports(Model model) throws IOException, InterruptedException {
        AirportAPI airportAPI = new AirportAPI(airportService);
        airportAPI.updateAirports();
        model.addAttribute("updateSuccess", "List was succesfully updated");
        return "admin/adminConsole";

    }

}
