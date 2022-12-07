package pl.korbanek.flightinfo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = FlightDetails.TABLE_NAME)
@Data
public class FlightDetails {
    public static final String TABLE_NAME = "flight_details";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String type;
    private double speed;
    private String departure_code;
    private String arrival_code;
    private double distance;
    private double flight_time;


    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;


}
