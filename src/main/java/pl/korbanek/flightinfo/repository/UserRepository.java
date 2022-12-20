package pl.korbanek.flightinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.korbanek.flightinfo.entity.User;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);

    @Modifying //zachodza zmiany w bazie
    @Transactional //spr czy wykona sie wszystko
    public void removeUserById(long id);

    User findById(long id);



}
