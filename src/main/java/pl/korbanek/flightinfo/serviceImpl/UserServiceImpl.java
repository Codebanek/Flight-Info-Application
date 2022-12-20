package pl.korbanek.flightinfo.serviceImpl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.korbanek.flightinfo.converter.UserDTOConverter;
import pl.korbanek.flightinfo.dto.UserCreateDTO;
import pl.korbanek.flightinfo.entity.Role;
import pl.korbanek.flightinfo.entity.User;
import pl.korbanek.flightinfo.repository.FlightDetailsRepository;
import pl.korbanek.flightinfo.repository.RoleRepository;
import pl.korbanek.flightinfo.repository.UserRepository;
import pl.korbanek.flightinfo.service.UserService;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final FlightDetailsRepository flightDetailsRepository;
    private final UserDTOConverter userDTOConverter;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository,
                           BCryptPasswordEncoder passwordEncoder, FlightDetailsRepository flightDetailsRepository, UserDTOConverter userDTOConverter) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.flightDetailsRepository = flightDetailsRepository;
        this.userDTOConverter = userDTOConverter;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void saveUser(UserCreateDTO userCreateDTO) {
        User user = userDTOConverter.convert(userCreateDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(1);
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(userRole);

        userRepository.save(user);
    }

    @Override
    public User findByEmail(String email){return userRepository.findByEmail(email);};

    public List<User> findAll(){return userRepository.findAll();}



    public void removeUserWithId(long id){
        User user = userRepository.findById(id);
        flightDetailsRepository.removeAllByUser(user);
        userRepository.removeUserById(id);}
}
