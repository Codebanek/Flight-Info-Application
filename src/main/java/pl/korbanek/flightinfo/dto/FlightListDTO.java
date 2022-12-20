package pl.korbanek.flightinfo.dto;

import lombok.Data;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import pl.korbanek.flightinfo.functionality.CurrentUser;
import pl.korbanek.flightinfo.entity.FlightDetails;
import pl.korbanek.flightinfo.repository.FlightDetailsRepository;
import pl.korbanek.flightinfo.service.FlightDetailsService;

import java.util.ArrayList;
import java.util.List;

@Data
public class FlightListDTO {


    private long id;
    private double speed;
    private String type;
    private String departure_code;
    private String arrival_code;
    private double distance;
    private double flight_time;

    public FlightListDTO(FlightDetailsService flightDetailsService) {
        this.flightDetailsService = flightDetailsService;
    };
    private final FlightDetailsService flightDetailsService;

    //Getting a list of all flights that user ever created
    public List<FlightListDTO> getFlightList (@AuthenticationPrincipal CurrentUser currentUser){

        List<FlightDetails> allFlightsList = flightDetailsService.findFlightDetailsOfUser(currentUser.getUser());
        List<FlightListDTO> flightList = new ArrayList<>();

        for (FlightDetails f : allFlightsList
             ) {
            FlightListDTO flightListDTO = new FlightListDTO(flightDetailsService);
            flightListDTO.setId(f.getId());
            flightListDTO.setType(f.getType());
            flightListDTO.setSpeed(f.getSpeed());
            flightListDTO.setDeparture_code(f.getDeparture_code());
            flightListDTO.setArrival_code(f.getArrival_code());
            flightListDTO.setDistance(f.getDistance());
            flightListDTO.setFlight_time(f.getFlight_time());
            flightList.add(flightListDTO);
        }

        return flightList;
        }


    public FlightListDTO singleFlightDetails (@AuthenticationPrincipal CurrentUser currentUser, long id){
        List<FlightDetails> allFlightsList = flightDetailsService.findFlightDetailsOfUser(currentUser.getUser());

        for (FlightDetails f : allFlightsList
        ) {
            if(f.getId() == id){
                FlightListDTO singleFlight = new FlightListDTO(flightDetailsService);
                singleFlight.setId(f.getId());
                singleFlight.setType(f.getType());
                singleFlight.setSpeed(f.getSpeed());
                singleFlight.setDeparture_code(f.getDeparture_code());
                singleFlight.setArrival_code(f.getArrival_code());
                singleFlight.setDistance(f.getDistance());
                singleFlight.setFlight_time(f.getFlight_time());
                return singleFlight;
            }

        }
        return null;
    }

}
