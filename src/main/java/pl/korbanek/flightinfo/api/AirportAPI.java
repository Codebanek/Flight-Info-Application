package pl.korbanek.flightinfo.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import pl.korbanek.flightinfo.entity.Airport;
import pl.korbanek.flightinfo.service.AirportService;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class AirportAPI {

    private final AirportService airportService;

    public void updateAirports() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://airlabs.co/api/v9/airports?country_code=PL&api_key=bee3bd74-8c1c-4092-b226-03adf0e5914e"))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();


        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(response.body());
        List<String> x = new ArrayList<>();
        JsonNode rawResource = node.get("response");
        List<Airport> airportsFromAPI = new ArrayList<>();
        System.out.println(rawResource.size());
        for (int i = 0; i < rawResource.size(); i++) {
            String icao = rawResource.get(i).get("icao_code").asText();
            String lat = rawResource.get(i).get("lat").asText();
            String lng = rawResource.get(i).get("lng").asText();
            DecimalFormat df = new DecimalFormat("#.##");

            if (airportService.findAirportByIcaoCode(icao) != null) {
                Airport existingAirport = airportService.findAirportByIcaoCode(icao);
                existingAirport.setLattitude(Double.parseDouble(lat));
                existingAirport.setLongitude(Double.parseDouble(lng));
            } else {
                Airport airport = new Airport();
                airport.setIcaoCode(icao);
                airport.setLattitude(Double.parseDouble(lat));
                airport.setLongitude(Double.parseDouble(lng));
                airportsFromAPI.add(airport);
            }
        }
        airportService.saveAll(airportsFromAPI);
    }
}

