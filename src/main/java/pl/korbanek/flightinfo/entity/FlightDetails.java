package pl.korbanek.flightinfo.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = FlightDetails.TABLE_NAME)
@Data
public class FlightDetails {
    public static final String TABLE_NAME = "flight_details";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 51)
    private String type;

    private int speed;

    @Column(nullable = false, length = 51)
    private String departure_code;

    @Column(nullable = false, length = 51)
    private String arrival_code;

    private double distance;

    private double flight_time;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
