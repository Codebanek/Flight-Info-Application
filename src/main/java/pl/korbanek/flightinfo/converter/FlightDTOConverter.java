package pl.korbanek.flightinfo.converter;

import org.springframework.stereotype.Component;
import pl.korbanek.flightinfo.dto.FlightCreateDTO;
import pl.korbanek.flightinfo.entity.FlightDetails;

@Component
public class FlightDTOConverter {
    public FlightDetails convert(FlightCreateDTO in){
        FlightDetails out = new FlightDetails();
        out.setType(in.getType());
        out.setSpeed(Integer.parseInt(in.getSpeed()));
        out.setDeparture_code(in.getDeparture_code());
        out.setArrival_code(in.getArrival_code());
        return out;
    }
}
