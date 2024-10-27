package ca.etsmtl.taf.testrail.repository;

import ca.etsmtl.taf.testrail.model.entity.TestRailProject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestRailProjectRepository extends JpaRepository<TestRailProject, Long> {

    Optional<TestRailProject> findByTafId(Long tafId);

    Optional<TestRailProject> findById(Integer id);

    Optional<TestRailProject> findByName(String name);

}
