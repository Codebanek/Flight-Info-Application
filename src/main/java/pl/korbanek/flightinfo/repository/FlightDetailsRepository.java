package pl.korbanek.flightinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.korbanek.flightinfo.entity.FlightDetails;
import pl.korbanek.flightinfo.entity.User;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface FlightDetailsRepository extends JpaRepository<FlightDetails, Long> {
    List<FlightDetails> findFlightDetailsByUser(User user);
    @Query("select d.id, d.arrival_code, d.departure_code, d.distance, d.flight_time, d.speed, d.type from FlightDetails d where " +
            "d.id = ?1")
    List<FlightDetails> findFlightDetailsById(long id);

    @Modifying
    @Transactional
    void removeFlightDetailsById(long id);

    @Modifying
    @Transactional
    void removeAllByUser(User user);


}
