package pl.korbanek.flightinfo.service;


import pl.korbanek.flightinfo.entity.User;

public interface UserService {
    User findByUserName(String name);
    void saveUser(User user);

}
