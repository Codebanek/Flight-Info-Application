package pl.korbanek.flightinfo.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = Airport.TABLE_NAME)
@Data
public class Airport {
    public static final String TABLE_NAME = "airports";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String icaoCode;
    private double lattitude;
    private double longitude;

    public Airport(long id, String icaoCode, double lattitude, double longitude) {
        this.id = id;
        this.icaoCode = icaoCode;
        this.lattitude = lattitude;
        this.longitude = longitude;
    }

    public Airport() {
    }
}
