package pl.korbanek.flightinfo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import pl.korbanek.flightinfo.serviceImpl.UserServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http

                .authorizeRequests()
                .antMatchers("/welcome", "/createAccount","/author").permitAll()
                .antMatchers("/user/**").hasRole("USER")
                .antMatchers("/admin/**").hasRole("ADMIN")

                .and()
                .formLogin().loginPage("/welcome")
                //.loginProcessingUrl("/perform_login")
                .defaultSuccessUrl("/user/flightplan")
                .failureUrl("/welcome?error=true")
                .and()
                .logout().logoutSuccessUrl("/welcome")
                .deleteCookies("JSESSIONID");
        return http.build();

    }



}
