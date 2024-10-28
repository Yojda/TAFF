package ca.etsmtl.taf.testrail.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TempTestCaseGatling {
    private static final Logger logger = Logger.getLogger(TempTestCaseGatling.class.getName());
    private String baseUrl;
    private String scenario;
    private Map<String, Integer> usersInjection = new HashMap<>();
    public static void main(String[] args) {
        String SimulationPath = "backend/src/main/resources/testrail/SimpleSimulation.java";
        String gatlingScript = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(SimulationPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                gatlingScript += line + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Regex patterns to match the different elements
        Pattern baseUrlPattern = Pattern.compile("baseUrl\\(\"([^\"]+)\"\\)");
        Pattern scenarioTitlePattern = Pattern.compile("scenario\\(\"([^\"]+)\"\\)");
        Pattern requestPattern = Pattern.compile("exec\\(http\\(\"([^\"]+)\"\\)\\s*\\.get\\(\"([^\"]+)\"\\)\\);");
        Pattern userInjectionPattern = Pattern.compile("setUp(\\(.*?);", Pattern.DOTALL);

        // Extract base URL
        Matcher baseUrlMatcher = baseUrlPattern.matcher(gatlingScript);
        if (baseUrlMatcher.find()) {
            System.out.println("Base URL: " + baseUrlMatcher.group(1));
        }

        // Extract scenario title
        Matcher scenarioTitleMatcher = scenarioTitlePattern.matcher(gatlingScript);
        if (scenarioTitleMatcher.find()) {
            System.out.println("Scenario Title: " + scenarioTitleMatcher.group(1));
        }

        // Extract scenario requests
        Matcher requestMatcher = requestPattern.matcher(gatlingScript);
        while (requestMatcher.find()) {
            System.out.println("Request Title: " + requestMatcher.group(1));
            System.out.println("Request Path: " + requestMatcher.group(2));
        }

        // Extract user injection
        Matcher userInjectionMatcher = userInjectionPattern.matcher(gatlingScript);
        if (userInjectionMatcher.find()) {
            System.out.println("User Injection: " + userInjectionMatcher.group(1));
        }
    }
}