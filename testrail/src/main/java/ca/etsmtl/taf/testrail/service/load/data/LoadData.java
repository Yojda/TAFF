package ca.etsmtl.taf.testrail.service.load.data;

public interface LoadData {
    /*
    * Interface for loading data from TestRail.
    * The methods need to be implemented in the classes that will load the data.
    * Assisted by IA (copilot & chatGPT & intellij)
    * Tests : TODO
    * */

    void loadById(int id);
    void loadByName(String name);
    void loadAll();
}
