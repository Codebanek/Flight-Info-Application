package pl.korbanek.flightinfo.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = Role.TABLE_NAME)
@Data
public class Role {
    public static final String TABLE_NAME = "roles";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;


}
