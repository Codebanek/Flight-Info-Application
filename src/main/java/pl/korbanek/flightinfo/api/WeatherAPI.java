package pl.korbanek.flightinfo.api;

import lombok.RequiredArgsConstructor;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import pl.korbanek.flightinfo.entity.Airport;
import pl.korbanek.flightinfo.service.AirportService;
import pl.korbanek.flightinfo.service.FlightDetailsService;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
public class WeatherAPI {

    private final AirportService airportService;


    public List<String> checkWeather(String icao_code) throws IOException, InterruptedException {

        Airport airport = airportService.findAirportByIcaoCode(icao_code);
        String airport_lat = String.valueOf(airport.getLattitude());
        String airport_lng = String.valueOf(airport.getLongitude());

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.open-meteo.com/v1/forecast?latitude="+airport_lat+"&longitude="+airport_lng+"&current_weather=true"))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(response.body());
        JsonNode rawResource = node.get("current_weather");
        List<String> weather = new ArrayList<>();
        weather.add(String.valueOf(rawResource.get("temperature")));
        weather.add(String.valueOf(rawResource.get("windspeed")));
        weather.add(String.valueOf(rawResource.get("winddirection")));
        return weather;
    }
}
