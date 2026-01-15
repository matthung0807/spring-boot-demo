package com.abc.demo;

import java.io.InputStream;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(DemoApplication.class, args);

        String apiKey = "API_KEY";

        String origin = "桃園市桃園區大同路100號";
        String destination = "台北市內湖區瑞光路515號";

        String encodedPolyline = getRouteEncodedPolyline(origin, destination, apiKey);

        String url = buildMapUri(origin, destination, encodedPolyline, apiKey);
        System.out.println("url: " + url);

        saveStaticMapImage(url);

    }

    private static String getRouteEncodedPolyline(String origin, String destination, String apiKey) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String requestBody = mapper.writeValueAsString(Map.of(
                "origin", Map.of("address", origin),
                "destination", Map.of("address", destination),
                "travelMode", "DRIVE"));

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://routes.googleapis.com/directions/v2:computeRoutes"))
                .header("Content-Type", "application/json")
                .header("X-Goog-Api-Key", apiKey)
                .header("X-Goog-FieldMask", String.join(",", "routes.polyline"))
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        JsonNode root = mapper.readTree(response.body());
        String encodedPolyline = root.path("routes")
                .path(0)
                .path("polyline")
                .path("encodedPolyline")
                .asText("");
        return encodedPolyline;
    }

    private static String buildMapUri(String origin, String destination, String encodedPolyline, String apiKey)
            throws Exception {
        String markerA = URLEncoder.encode(
                "color:red|label:A|" + origin,
                StandardCharsets.UTF_8);

        String markerB = URLEncoder.encode(
                "color:blue|label:B|" + destination,
                StandardCharsets.UTF_8);

        String path = URLEncoder.encode(
                "enc:" + encodedPolyline,
                StandardCharsets.UTF_8);

        String url = "https://maps.googleapis.com/maps/api/staticmap?"
                + "size=640x640"
                + "&markers=" + markerA
                + "&markers=" + markerB
                + "&path=" + path
                + "&key=" + apiKey;

        return url;
    }

    private static void saveStaticMapImage(String staticMapUrl) throws Exception {
        HttpRequest imgReq = HttpRequest.newBuilder()
                .uri(URI.create(staticMapUrl))
                .GET()
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<InputStream> imgRes = client.send(imgReq, HttpResponse.BodyHandlers.ofInputStream());

        try (InputStream is = imgRes.body()) {
            Files.copy(
                    is,
                    Path.of("map.png"),
                    StandardCopyOption.REPLACE_EXISTING);
        }
    }

}
