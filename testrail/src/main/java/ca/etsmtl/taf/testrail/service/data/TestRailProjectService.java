package ca.etsmtl.taf.testrail.service.data;


import ca.etsmtl.taf.testrail.model.entity.TestRailProject;
import ca.etsmtl.taf.testrail.repository.TestRailProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TestRailProjectService {

    @Autowired
    private TestRailProjectRepository testRailProjectRepository;

    public TestRailProject save(TestRailProject project) {
        return testRailProjectRepository.save(project);
    }

    public Optional<TestRailProject> findByTafId(Long tafId) {
        return testRailProjectRepository.findByTafId(tafId);
    }

    public Optional<TestRailProject> findById(Integer id) {
        return testRailProjectRepository.findById(id);
    }

    public Optional<TestRailProject> findByName(String name) {
        return testRailProjectRepository.findByName(name);
    }

    public void deleteByTafId(Long tafId) {
        testRailProjectRepository.deleteById(tafId);
    }
}
