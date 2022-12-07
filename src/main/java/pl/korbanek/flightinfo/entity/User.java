package pl.korbanek.flightinfo.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = User.TABLE_NAME)
@Data
public class User {
    public static final String TABLE_NAME = "users";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;
    private String lastName;
    private String email;

    @Column(nullable = false, unique = true, length = 60)
    private String username;
    private String password;
    private int enabled;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;








}
