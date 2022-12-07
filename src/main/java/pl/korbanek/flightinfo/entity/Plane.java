package pl.korbanek.flightinfo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = Plane.TABLE_NAME)
@Data
public class Plane {
    public static final String TABLE_NAME = "planes";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String type;

    public Plane(long id, String type) {
        this.id = id;
        this.type = type;
    }

    public Plane() {
    }
}
