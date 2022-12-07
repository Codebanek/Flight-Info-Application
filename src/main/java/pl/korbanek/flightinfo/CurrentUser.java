package pl.korbanek.flightinfo;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
public class CurrentUser extends User {
    private final pl.korbanek.flightinfo.entity.User user;
    public CurrentUser(String username, String password,
                       Collection<? extends GrantedAuthority> authorities,
                       pl.korbanek.flightinfo.entity.User user) {
        super(username, password, authorities);
        this.user = user;
    }
    public pl.korbanek.flightinfo.entity.User getUser() {return user;}
}
