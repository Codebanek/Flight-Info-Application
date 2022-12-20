package pl.korbanek.flightinfo.dto;

import lombok.Data;
import pl.korbanek.flightinfo.entity.Role;
import pl.korbanek.flightinfo.repository.UniqueEmail;
import pl.korbanek.flightinfo.repository.UniqueUsername;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@UniqueEmail
@UniqueUsername
public class UserCreateDTO {
    @NotEmpty(message = "{invalid.email.not-empty}")
    @Email(message = "{invalid.email.email}")
    private String email;

    @Size(min = 3, max = 20, message = "{invalid.username.size}")
    private String username;

    @Size(min = 3, max = 20, message = "{invalid.firstname.size}")
    private String firstName;

    @Size(min = 3, max = 20, message = "{invalid.lastname.size}")
    private String lastName;

    @Size(min = 3, max = 20, message = "{invalid.password.size}")
    private String password;

    private int enabled;

    private Role roles;

}
