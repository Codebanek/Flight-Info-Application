package pl.korbanek.flightinfo.entity;

import lombok.Data;


import javax.persistence.*;

@Entity
@Table(name = User.TABLE_NAME)
@Data

public class User {
    public static final String TABLE_NAME = "users";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 51)
    private String firstName;

    @Column(nullable = false, length = 51)
    private String lastName;

    @Column(nullable = false, unique = true, length = 60)
    private String email;

    @Column(nullable = false, length = 51)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private int enabled;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Role roles;


}
