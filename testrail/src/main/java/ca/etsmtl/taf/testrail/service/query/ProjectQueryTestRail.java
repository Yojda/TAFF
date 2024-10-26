package ca.etsmtl.taf.testrail.service.query;

import ca.etsmtl.taf.testrail.model.entity.TestRailData;
import ca.etsmtl.taf.testrail.model.entity.TestRailProject;
import ca.etsmtl.taf.testrail.model.factory.TestRailProjectFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



public class ProjectQueryTestRail implements QueryTestRail {

    /*
     * Class that contains common requests about TestRail projects
     * This class doesn't save the data, it only queries TestRail
     * This class doesn't check if data is already loaded or in the database
     * Class build assisted by IA (copilot & chatGPT & intellij)
     * Tests : TODO
     * */

    private final HttpSenderToTestRail httpSenderToTestRail;

    public ProjectQueryTestRail(HttpSenderToTestRail httpSenderToTestRail) {
        this.httpSenderToTestRail = httpSenderToTestRail;
    }


    @Override
    public List<TestRailData> getAll() {
        /*
        * Query TestRail to get all projects accessible to the user
        * @return List of TestRailProject objects
        * Tests : TODO
        * Assisted by IA (copilot & chatGPT & intellij)
        * */

        String route = "get_projects";
        Optional<String> body = httpSenderToTestRail.getSender(route);

        if (body.isEmpty()) {
            return new ArrayList<>();
        }

        // If response is correct, Body is a JSON object with a list of projects
        // It contains a list of projects which are converted to TestRailProject objects

        try {
            JSONObject jsonResponse = new JSONObject(body.get());
            JSONArray projectsArray = jsonResponse.getJSONArray("projects");
            List<TestRailData> projects = new ArrayList<>();
        
            for (int i = 0; i < projectsArray.length(); i++) {
                JSONObject projectJson = projectsArray.getJSONObject(i);
                TestRailProject project = TestRailProjectFactory.create(projectJson); // Create a TestRailProject object from the JSON object
                projects.add(project);
            }
        
            return projects;
        } catch (JSONException e) {
            e.printStackTrace(); // TODO: improve logging
            return new ArrayList<>();
        }

    }

    @Override
    public TestRailData addNew(String projectName) {
        /*
        * Add a new project to TestRail
        * @param projectName : name of the project to add
        * @return TestRailProject object
        * @Use getByName to get the project added
        * Tests : TODO
        * Assisted by IA (copilot & chatGPT & intellij)
        * */

        // Send a post request to add a new project
        String route = "add_project";
        HttpResponse<String> response = null;
        Optional<String> body = httpSenderToTestRail.postSender(route, "{\"name\":\"" + projectName + "\"}");

        // Check if the response is successful

        if (body.isEmpty()) {
            System.err.println("Erreur lors de l'ajout du projet");
            return null;
        }

        // Use getByName to get the project added
        return getByName(projectName);
    }

    @Override
    public TestRailData getById(int id) {

        /*
        * Query TestRail to get a project by its ID
        * @param id : ID of the project to get
        * @return TestRailProject object
        * Tests : TODO
        * Assisted by IA (copilot & chatGPT & intellij)
        * */

        // Build the route for the API
        String route = "get_project/" + id;

        // Send the GET request via httpSenderToTestRail
        Optional<String> body = httpSenderToTestRail.getSender(route);

        // Check if the response body is present
        if (body.isEmpty()) {
            System.err.println("Projet avec l'ID " + id + " non trouvé.");
            return null;
        }

        // Convert the JSON response to a TestRailData object
        try {
            JSONObject projectJson = new JSONObject(body.get());
            return TestRailProjectFactory.create(projectJson); // Crée un objet TestRailData (TestRailProject) à partir du JSON
        } catch (JSONException e) {
            e.printStackTrace(); // TODO: Améliorer la gestion des erreurs
            return null;
        }
    }

    @Override
    public TestRailData getByName(String name) {
        /*
        * Query TestRail to get a project by its name
        * @param name : name of the project to get
        * @return TestRailProject object
        * Use getAll to get all projects and search the project by name
        * Tests : TODO
        * Assisted by IA (copilot & chatGPT & intellij)
        * */

        // Retrieve all projects
        List<TestRailData> allProjects = getAll();

        // Search for the project with the desired name
        for (TestRailData project : allProjects) {
            if (((TestRailProject) project).getName().equals(name)) {
                return project;
            }
        }

        // If no project with the given name is found, return null or throw an exception if necessary
        System.err.println("Project with the name \"" + name + "\" not found."); // TODO: improve logging
        return null;
        }
}