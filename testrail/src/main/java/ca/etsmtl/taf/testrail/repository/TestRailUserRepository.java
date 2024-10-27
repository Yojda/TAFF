package ca.etsmtl.taf.testrail.repository;

import ca.etsmtl.taf.testrail.model.entity.TestRailUser;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TestRailUserRepository extends JpaRepository<TestRailUser, Long> {

    // Find a TestRailUser by their unique username
    Optional<TestRailUser> findByUsername(String username);

    // Find a TestRailUser by their unique email
    Optional<TestRailUser> findByEmail(String email);
}
