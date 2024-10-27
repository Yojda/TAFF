package ca.etsmtl.taf.testrail.repository;

import ca.etsmtl.taf.testrail.model.entity.GatlingTestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface GatlingTestCaseRepository extends JpaRepository<GatlingTestCase, Long> {
    /*
    * TODO
    *       To be completed and tested
    * Assisted by IA (copilot & chatGPT & intellij)
    * */


    // Find GatlingTestCase entries by sectionId
    List<GatlingTestCase> findBySectionId(Integer sectionId);

    // Find GatlingTestCase entries by title
    List<GatlingTestCase> findByTitle(String title);
}
