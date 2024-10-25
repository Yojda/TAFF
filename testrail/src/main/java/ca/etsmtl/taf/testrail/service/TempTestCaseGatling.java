package ca.etsmtl.taf.testrail.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TempTestCaseGatling {
    private String baseUrl;
    private String scenario;
    private Map<String, Integer> usersInjection = new HashMap<>();
    public static void main(String[] args) {
        String SimulationPath = "backend/src/main/resources/testrail/SimpleSimulation.java";

        try (BufferedReader reader = new BufferedReader(new FileReader(SimulationPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(" ");
                if (words.length > 0) {
                    if (words[0].equals("HttpProtocolBuilder")) {
                        while (!line[-1].equals(";")) {
                            HttpProcotolBuilder.parse(line);
                        }
                    }
                    if (words[0].equals("Scenario")) {
                        System.out.println("scenario: " + words[1]);
                    }
                    if (words[0].equals("rampUsers")) {
                        System.out.println("usersInjection: " + words[1]);
                    }
                }
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}