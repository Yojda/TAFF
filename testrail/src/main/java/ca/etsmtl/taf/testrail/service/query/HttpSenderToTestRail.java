package ca.etsmtl.taf.testrail.service.query;

import org.springframework.stereotype.Component;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;


public class HttpSenderToTestRail {
    /*
     * This class is used to send HTTP requests to TestRail.
     * The static variables assignment need recoded to work with application properties.
     * The logs methods needs to be re-implemented with stronger logging.
     * Class build assisted by IA (copilot & chatGPT & intellij)
     * Tests : TODO
     */

    private static final String baseUrl = "https://leofornoff.testrail.io/index.php?/api/v2/";
    private static final String username = "leo.fornoff.1@ens.etsmtl.ca";
    private static final String password = "Valid8-Outpost2-Caravan0-Unlovable9-Easter7";

    public HttpSenderToTestRail() {
        // TODO : baseUrl, username and password will depend on the user
    }

    private Optional<String> send(HttpRequest request) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, java.net.http.HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                return Optional.of(response.body());
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            e.printStackTrace(); // TODO : improve logging
            return Optional.empty();
        }
    }

    public Optional<String> postSender(String route, String body) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(java.net.URI.create(baseUrl + route))
                .header("Authorization", "Basic " + java.util.Base64.getEncoder().encodeToString((username + ":" + password).getBytes()))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        return send(request);
    }

    public Optional<String> getSender(String route) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(java.net.URI.create(baseUrl + route))
                .header("Authorization", "Basic " + java.util.Base64.getEncoder().encodeToString((username + ":" + password).getBytes()))
                .GET()
                .build();

        return send(request);
    }
}
