package pl.korbanek.flightinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.korbanek.flightinfo.entity.FlightDetails;

@Repository
public interface FlightDetailsRepository extends JpaRepository<FlightDetails, Long> {
}
