package pl.korbanek.flightinfo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.korbanek.flightinfo.entity.FlightDetails;
import pl.korbanek.flightinfo.entity.User;
import pl.korbanek.flightinfo.repository.FlightDetailsRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightDetailsService {
    private final FlightDetailsRepository flightDetailsRepository;

    public void save(FlightDetails flightDetails){
        flightDetailsRepository.save(flightDetails);
    }

    public List<FlightDetails> findFlightDetailsById(long id){
        return flightDetailsRepository.findFlightDetailsById(id);
    }
    public void removeFlightWithId(long id){
        flightDetailsRepository.removeFlightDetailsById(id);
    }

    public List<FlightDetails> allFlights(){return flightDetailsRepository.findAll();};
    public List<FlightDetails> findFlightDetailsOfUser(User user){return flightDetailsRepository.findFlightDetailsByUser(user);}

}
