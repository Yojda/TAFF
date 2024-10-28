package ca.etsmtl.taf.testrail.service.data;

import ca.etsmtl.taf.testrail.TestConfig;
import ca.etsmtl.taf.testrail.model.entity.TestRailProject;
import ca.etsmtl.taf.testrail.model.factory.TestRailProjectFactory;
import ca.etsmtl.taf.testrail.repository.TestRailProjectRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ContextConfiguration(classes = TestConfig.class)
@DataJpaTest(properties = {
        "spring.jpa.hibernate.ddl-auto=create-drop",
        "spring.datasource.url=jdbc:h2:mem:testdb"
})
public class TestUnitTestRailProject {

    private TestRailProject testRailProject;
    private String defaultName;

    @Autowired
    private TestRailProjectService testRailProjectService;

    @BeforeEach
    public void setUp() {
        defaultName = "defaultName_" + LocalDate.now() + LocalTime.now() + TestConfig.getRandomString(16);
        testRailProject = TestRailProjectFactory.create(defaultName);
    }

    @Test
    public void testSave() {
        testRailProject.setTRId(1);
        TestRailProject savedTestRailProject = testRailProjectService.save(testRailProject);
        System.out.println("savedTestRailProject : " + savedTestRailProject);
        assertNotNull(savedTestRailProject);
        assertEquals(testRailProject, savedTestRailProject);
        assertEquals(defaultName, savedTestRailProject.getName());
    }
}