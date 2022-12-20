package pl.korbanek.flightinfo.validator;


import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import pl.korbanek.flightinfo.dto.UserCreateDTO;
import pl.korbanek.flightinfo.entity.User;
import pl.korbanek.flightinfo.repository.UniqueEmail;
import pl.korbanek.flightinfo.serviceImpl.UserServiceImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
@Component
@RequiredArgsConstructor
@Setter
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, UserCreateDTO> {

    private final UserServiceImpl userServiceImpl;

    @Override
    public void initialize(UniqueEmail constraintAnnotation) {

    }
    @Override
    public boolean isValid(UserCreateDTO user, ConstraintValidatorContext constraintValidatorContext){
        User userWithSameEmail = userServiceImpl.findByEmail(user.getEmail());
        if(userWithSameEmail != null){
            constraintValidatorContext
                    .buildConstraintViolationWithTemplate("{invalid.email.email-unique}")
                    .addPropertyNode("email").addConstraintViolation();
            return false;
        }  return true;
    }

}
