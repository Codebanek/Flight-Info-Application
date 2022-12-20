package pl.korbanek.flightinfo.service;


import pl.korbanek.flightinfo.dto.UserCreateDTO;
import pl.korbanek.flightinfo.entity.User;

public interface UserService {
    User findByUsername(String name);
    void saveUser(UserCreateDTO userCreateDTO);
    User findByEmail(String email);






}
