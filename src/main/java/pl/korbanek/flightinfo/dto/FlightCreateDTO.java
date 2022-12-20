package pl.korbanek.flightinfo.dto;

import lombok.Data;
import javax.validation.constraints.*;

@Data
public class FlightCreateDTO {

    @Size(min = 3, message = "{invalid.type.not-empty}")
    private String type;

    @Min(20)
    @Max(999)
    @NotEmpty(message = "{invalid.speed.not-empty}")
    private String speed;

    @Size(min = 3, max = 4, message = "{invalid.airport.not-empty}")
    private String departure_code;

    @Size(min = 3, max = 4, message = "{invalid.airport.not-empty}")
    private String arrival_code;

}
