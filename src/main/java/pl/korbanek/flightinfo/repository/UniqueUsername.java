package pl.korbanek.flightinfo.repository;

import pl.korbanek.flightinfo.validator.UniqueUsernameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueUsernameValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)

public @interface UniqueUsername {
    String message() default "{invalid.username.username-unique}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
