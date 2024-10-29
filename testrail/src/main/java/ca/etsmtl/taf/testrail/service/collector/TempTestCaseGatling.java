package ca.etsmtl.taf.testrail.service.collector;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TempTestCaseGatling {
    private static final Logger logger = Logger.getLogger(TempTestCaseGatling.class.getName());

    static {
        try {
            File logDir = new File("./logs");
            if (!logDir.exists()) {
                logDir.mkdirs(); // Crée le dossier "logs" si inexistant
            }

            FileHandler fileHandler = new FileHandler("./logs/TempTestCaseGatling.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (Exception e) {
            logger.severe("Erreur de configuration du FileHandler.");
        }
    }

    private String scenarioName;
    private String requestName;
    private String baseUrl;
    private String userInjection;

    private Map<String, Integer> usersInjection = new HashMap<>();
    public void parse() {
        logger.setLevel(Level.INFO);
        String SimulationPath = "backend/src/main/resources/testrail/SimpleSimulation.java";
        logger.info("SimulationPath=" + SimulationPath);
        String gatlingScript = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(SimulationPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                gatlingScript += line + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Pattern baseUrlPattern = Pattern.compile("baseUrl\\(\"([^\"]+)\"\\)");
        Pattern scenarioTitlePattern = Pattern.compile("scenario\\(\"([^\"]+)\"\\)");
        Pattern requestPattern = Pattern.compile("exec\\(http\\(\"([^\"]+)\"\\)\\s*\\.get\\(\"([^\"]+)\"\\)\\);");
        Pattern userInjectionPattern = Pattern.compile("setUp(\\(.*?);", Pattern.DOTALL);

        // Extract base URL
        Matcher baseUrlMatcher = baseUrlPattern.matcher(gatlingScript);
        if (baseUrlMatcher.find()) {
            logger.info("Base URL: " + baseUrlMatcher.group(1));
        } else {
            logger.warning("Base URL not found in the Gatling script.");
        }

        // Extract scenario title
        Matcher scenarioTitleMatcher = scenarioTitlePattern.matcher(gatlingScript);
        if (scenarioTitleMatcher.find()) {
            logger.info("Scenario Title: " + scenarioTitleMatcher.group(1));
        } else {
            logger.warning("Scenario title not found in the Gatling script.");
        }

        // Extract scenario requests
        Matcher requestMatcher = requestPattern.matcher(gatlingScript);
        if (requestMatcher.find()) {
            logger.info("Request: " + requestMatcher.group(1) + " - " + requestMatcher.group(2));
        } else {
            logger.warning("Requests not found in the Gatling script.");
        }

        // Extract user injection
        Matcher userInjectionMatcher = userInjectionPattern.matcher(gatlingScript);
        if (userInjectionMatcher.find()) {
            this.userInjection = userInjectionMatcher.replaceAll("\\s");
            logger.info("User Injection: " + userInjectionMatcher.group(1));
        } else {
            logger.warning("User injection not found in the Gatling script.");
        }
    }
}