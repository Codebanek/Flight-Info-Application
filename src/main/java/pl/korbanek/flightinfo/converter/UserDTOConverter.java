package pl.korbanek.flightinfo.converter;

import org.springframework.stereotype.Component;
import pl.korbanek.flightinfo.dto.UserCreateDTO;
import pl.korbanek.flightinfo.entity.User;

@Component
public class UserDTOConverter {

    public User convert(UserCreateDTO in){
        User out = new User();
        out.setUsername(in.getUsername());
        out.setEmail(in.getEmail());
        out.setPassword(in.getPassword());
        out.setFirstName(in.getFirstName());
        out.setLastName(in.getLastName());
        out.setEnabled(in.getEnabled());
        out.setRoles(in.getRoles());

        return out;

    }
}
