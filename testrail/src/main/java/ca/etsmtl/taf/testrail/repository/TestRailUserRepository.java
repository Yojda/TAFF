package ca.etsmtl.taf.testrail.repository;

import ca.etsmtl.taf.testrail.model.entity.TestRailUser;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TestRailUserRepository extends JpaRepository<TestRailUser, Long> {
    /*
     * This interface is used to interact with the TestRailUser table in the database.
     * Assisted by IA (copilot & chatGPT & intellij)
     * Tests : TODO
     * */

    // Find a TestRailUser by their unique id (TR id)
    Optional<TestRailUser> findByTRId(Integer id);

    // Find a TestRailUser by their unique username
    Optional<TestRailUser> findByUsername(String username);

    // Find a TestRailUser by their unique email
    Optional<TestRailUser> findByEmail(String email);
}
