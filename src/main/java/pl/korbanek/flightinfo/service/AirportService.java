package pl.korbanek.flightinfo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.korbanek.flightinfo.entity.Airport;
import pl.korbanek.flightinfo.repository.AirportRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AirportService {
    private final AirportRepository airportRepository;
    public void saveAll(List<Airport> airportList){airportRepository.saveAll(airportList);};
    public Airport findAirportByIcaoCode(String code){ return airportRepository.findAirportByIcaoCode(code);};
    public List<Airport> findAll(){
        return airportRepository.findAll();
    }
}
