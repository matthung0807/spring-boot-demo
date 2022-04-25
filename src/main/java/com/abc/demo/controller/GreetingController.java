package com.abc.demo.controller;

import com.abc.demo.dto.WebhooksRegisterDto;
import com.abc.demo.service.WebhooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.time.Duration;

@RestController
public class GreetingController {

    @Autowired
    private WebhooksService webhooksService;

    @GetMapping("/greeting")
    public void greeting() throws Exception {
        System.out.println("Good day");
        sendEvent();
    }

    private void sendEvent() throws Exception {
        var registeredDtoList = webhooksService.getRegisteredDtoList();
        if (registeredDtoList.isEmpty()) {
            System.out.println("webhooks has no registered urls");
            return;
        }

        var httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .connectTimeout(Duration.ofSeconds(3))
                .sslContext(disabledSSLContext())
                .build();

        for (WebhooksRegisterDto dto : registeredDtoList) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(dto.getUrl()))
                    .POST(HttpRequest.BodyPublishers.ofString("{\"name\": \"" + dto.getName() + "\"}"))
                    .header("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                    .build();

            var response = httpClient.send(
                    request, HttpResponse.BodyHandlers.ofString());
            if ("success".equals(response.body())) {
                System.out.println("send event success");
            }
        }
    }

    private static SSLContext disabledSSLContext() throws KeyManagementException, NoSuchAlgorithmException {
        SSLContext sslContext = SSLContext.getInstance("TLS"); // https://docs.oracle.com/en/java/javase/11/docs/specs/security/standard-names.html#sslcontext-algorithms
        sslContext.init(
                null,
                new TrustManager[]{
                        new X509TrustManager() {
                            public X509Certificate[] getAcceptedIssuers() {
                                return null;
                            }

                            public void checkClientTrusted(X509Certificate[] certs, String authType) {
                            }

                            public void checkServerTrusted(X509Certificate[] certs, String authType) {
                            }
                        }
                },
                new SecureRandom()
        );
        return sslContext;
    }
}
