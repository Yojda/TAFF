package ca.etsmtl.taf.testrail.repository;

import ca.etsmtl.taf.testrail.model.entity.TestRailCase;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TestRailCaseRepository {
    /*
     * This interface is used to interact with the TestRailProject table in the database.
     * TODO
     *     To be completed and tested
     * Assisted by IA (copilot & chatGPT & intellij)
     * */

    Optional<TestRailCase> findByTRId(Integer id);

    Optional<TestRailCase> findByTitle(String title);



}
