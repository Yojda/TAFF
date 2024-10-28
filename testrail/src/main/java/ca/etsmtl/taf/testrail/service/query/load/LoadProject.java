package ca.etsmtl.taf.testrail.service.query.load;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class LoadProject implements LoadData {
    /*
     * TODO
     * This class is used to load project data from TestRail.
     * The methods need to be implemented in the classes that will load the data.
     * Assisted by IA (copilot & chatGPT & intellij)
     * Tests : TODO
     * */


    @Override
    public void loadById(int id) {
        // TODO
    }

    @Override
    public void loadByName(String name) {
        // TODO
    }

    @Override
    public void loadAll() {
        // TODO
    }
}
