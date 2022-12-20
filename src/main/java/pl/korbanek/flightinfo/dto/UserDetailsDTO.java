package pl.korbanek.flightinfo.dto;

import lombok.Data;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import pl.korbanek.flightinfo.functionality.CurrentUser;
import pl.korbanek.flightinfo.entity.User;
import pl.korbanek.flightinfo.serviceImpl.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserDetailsDTO {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String roles;

    private final UserServiceImpl userServiceImpl;

    public UserDetailsDTO(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }



    public UserDetailsDTO getUserDetails(@AuthenticationPrincipal CurrentUser currentUser){
        User loadedUser = userServiceImpl.findByUsername(currentUser.getUsername());
        UserDetailsDTO userDetailsDTO = new UserDetailsDTO(userServiceImpl);
        userDetailsDTO.setFirstName(loadedUser.getFirstName());
        userDetailsDTO.setLastName(loadedUser.getLastName());
        userDetailsDTO.setEmail(loadedUser.getEmail());
        userDetailsDTO.setUsername(loadedUser.getUsername());
        return userDetailsDTO;
    }

    public List<UserDetailsDTO> getAllUsers(){
        List<User> allUsers = userServiceImpl.findAll();
        List<UserDetailsDTO> allUsersDto = new ArrayList<>();
        for (User u:allUsers
             ) {
            UserDetailsDTO userDetailsDTO = new UserDetailsDTO(userServiceImpl);
            userDetailsDTO.setId(u.getId());
            userDetailsDTO.setUsername(u.getUsername());
            userDetailsDTO.setFirstName(u.getFirstName());
            userDetailsDTO.setLastName(u.getLastName());
            userDetailsDTO.setEmail(u.getEmail());
            userDetailsDTO.setRoles(u.getRoles().getName());
            allUsersDto.add(userDetailsDTO);

        }
        return allUsersDto;
    }

}
