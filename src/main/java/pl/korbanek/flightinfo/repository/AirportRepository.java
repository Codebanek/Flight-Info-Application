package pl.korbanek.flightinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.korbanek.flightinfo.entity.Airport;

import java.util.Optional;


@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
    Airport findAirportByIcaoCode(String code);
}
