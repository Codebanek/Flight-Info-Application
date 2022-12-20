package pl.korbanek.flightinfo.functionality;

import lombok.RequiredArgsConstructor;
import pl.korbanek.flightinfo.entity.FlightDetails;
import pl.korbanek.flightinfo.service.AirportService;

@RequiredArgsConstructor
public class DistanceCalculator {

    private final AirportService airportService;

    public double distance(FlightDetails flightDetails) {

        double lat1 =
                airportService
                        .findAirportByIcaoCode(flightDetails.getDeparture_code()).getLattitude();

        double lat2 =
                airportService
                        .findAirportByIcaoCode(flightDetails.getArrival_code()).getLattitude();

        double lon1 =
                airportService
                        .findAirportByIcaoCode(flightDetails.getDeparture_code()).getLongitude();
        double lon2 =
                airportService
                        .findAirportByIcaoCode(flightDetails.getArrival_code()).getLongitude();

        final double el1 = 90;
        final double el2 = 90;
        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters

        double height = el1 - el2;

        distance = Math.pow(distance, 2) + Math.pow(height, 2);

        return Math.sqrt(distance);
    }
}
