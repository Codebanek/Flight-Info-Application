package pl.korbanek.flightinfo.validator;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import pl.korbanek.flightinfo.dto.UserCreateDTO;
import pl.korbanek.flightinfo.entity.User;
import pl.korbanek.flightinfo.repository.UniqueUsername;
import pl.korbanek.flightinfo.serviceImpl.UserServiceImpl;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Setter
@RequiredArgsConstructor
@Component
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, UserCreateDTO> {

    private final UserServiceImpl userServiceImpl;

    @Override
    public void initialize(UniqueUsername constraintAnnotation) {

    }
    @Override
    public boolean isValid(UserCreateDTO user, ConstraintValidatorContext constraintValidatorContext){
        User userWithSameUsername = userServiceImpl.findByUsername(user.getUsername());
        if(userWithSameUsername != null){
            constraintValidatorContext
                    .buildConstraintViolationWithTemplate("{invalid.username.username-unique}")
                    .addPropertyNode("username").addConstraintViolation();
            return false;
        }  return true;
    }

}
