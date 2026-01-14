package com.abc.demo;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(DemoApplication.class, args);

        String apiKey = "API_KEY";

        String requestBody = new ObjectMapper().writeValueAsString(Map.of(
                "origins", List.of(
                        Map.of("waypoint",
                                Map.of("address", "桃園市桃園區大同路100號"))),
                "destinations", List.of(
                        Map.of("waypoint",
                                Map.of("address", "台北市內湖區瑞光路515號"))),
                "travelMode", "DRIVE"));

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://routes.googleapis.com/distanceMatrix/v2:computeRouteMatrix"))
                .header("Content-Type", "application/json")
                .header("X-Goog-Api-Key", apiKey)
                .header("X-Goog-FieldMask", String.join(",",
                        "status",
                        "condition",
                        "distanceMeters",
                        "duration",
                        "originIndex",
                        "destinationIndex"
                ))
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response;

        response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody = response.body();
        System.out.println("Response Body: " + responseBody);

    }

}
