package ca.etsmtl.taf.testrail.repository;

import ca.etsmtl.taf.testrail.model.entity.TestRailSuite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestRAilSuiteRepository extends JpaRepository<TestRailSuite, Long> {
    /*
     * This interface is used to interact with the TestRailProject table in the database.
     * TODO
     *     To be completed and tested
     * Assisted by IA (copilot & chatGPT & intellij)
     * */

    Optional<TestRailSuite> findByTRId(Integer id);

}
