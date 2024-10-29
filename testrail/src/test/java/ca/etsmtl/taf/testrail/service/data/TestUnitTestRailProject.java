package ca.etsmtl.taf.testrail.service.data;

import ca.etsmtl.taf.testrail.TestConfig;
import ca.etsmtl.taf.testrail.model.entity.TestRailProject;
import ca.etsmtl.taf.testrail.model.factory.TestRailProjectFactory;
import ca.etsmtl.taf.testrail.repository.TestRailProjectRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import java.sql.Timestamp;
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
        testRailProjectService.deleteAll(); // Drop all data from the table
        defaultName = "defaultName_" + LocalDate.now() + LocalTime.now() + TestConfig.getRandomString(16);
        testRailProject = TestRailProjectFactory.create(defaultName);

    }

    @Test
    public void testSave() {
        // Arrange
        testRailProject.setTRId(1);

        // Act
        TestRailProject savedTestRailProject = testRailProjectService.save(testRailProject);

        // Assert
        assertNotNull(savedTestRailProject);
        assertEquals(testRailProject, savedTestRailProject);
        assertEquals(defaultName, savedTestRailProject.getName());
    }

    @Test
    public void testUpdate() {

        // ID

        // Arrange
        testRailProject.setTRId(2);

        // Act
        TestRailProject savedTestRailProject = testRailProjectService.save(testRailProject);

        // Assert
        assertNotNull(savedTestRailProject);
        assertEquals(testRailProject, savedTestRailProject);
        assertEquals(defaultName, savedTestRailProject.getName());
        assertEquals(2, savedTestRailProject.getTRId());

        // Updated Name

        String updatedName = "updatedName_" + LocalDate.now() + LocalTime.now() + TestConfig.getRandomString(16);
        savedTestRailProject.setName(updatedName);
        TestRailProject updatedTestRailProject = testRailProjectService.save(savedTestRailProject);
        TestRailProject getTestRailProject = testRailProjectService.findByTRId(2).get();
        System.out.println("updatedTestRailProject : " + updatedTestRailProject);

        assertNotNull(updatedTestRailProject);
        assertEquals(savedTestRailProject, updatedTestRailProject);
        assertEquals(updatedName, updatedTestRailProject.getName());
        assertEquals(2, updatedTestRailProject.getTRId());
        assertEquals(updatedTestRailProject, getTestRailProject);

        // Updated announcement

        String updatedAnnouncement = "updatedAnnouncement_" + LocalDate.now() + LocalTime.now() + TestConfig.getRandomString(16);
        updatedTestRailProject.setAnnouncement(updatedAnnouncement);
        TestRailProject updatedTestRailProject2 = testRailProjectService.save(updatedTestRailProject);
        TestRailProject getTestRailProject2 = testRailProjectService.findByTRId(2).get();

        assertNotNull(updatedTestRailProject2);
        assertEquals(updatedTestRailProject, updatedTestRailProject2);
        assertEquals(updatedAnnouncement, updatedTestRailProject2.getAnnouncement());
        assertEquals(2, updatedTestRailProject2.getTRId());
        assertEquals(updatedTestRailProject2, getTestRailProject2);

        // Updated showAnnouncement

        boolean updatedShowAnnouncement = true;
        updatedTestRailProject.setShowAnnouncement(updatedShowAnnouncement);
        TestRailProject updatedTestRailProject3 = testRailProjectService.save(updatedTestRailProject2);
        TestRailProject getTestRailProject3 = testRailProjectService.findByTRId(2).get();

        assertNotNull(updatedTestRailProject3);
        assertEquals(updatedTestRailProject2, updatedTestRailProject3);
        assertEquals(updatedShowAnnouncement, updatedTestRailProject3.getShowAnnouncement());
        assertEquals(2, updatedTestRailProject3.getTRId());
        assertEquals(updatedTestRailProject3, getTestRailProject3);

        // Updated isCompleted

        boolean updatedIsCompleted = true;
        updatedTestRailProject2.setIsCompleted(updatedIsCompleted);
        TestRailProject updatedTestRailProject4 = testRailProjectService.save(updatedTestRailProject2);
        TestRailProject getTestRailProject4 = testRailProjectService.findByTRId(2).get();

        assertNotNull(updatedTestRailProject4);
        assertEquals(updatedTestRailProject2, updatedTestRailProject4);
        assertEquals(updatedIsCompleted, updatedTestRailProject4.getIsCompleted());
        assertEquals(2, updatedTestRailProject4.getTRId());
        assertEquals(updatedTestRailProject4, getTestRailProject3);

        // Updated completedOn

        Timestamp updatedCompletedOn = new Timestamp(System.currentTimeMillis());
        updatedTestRailProject2.setCompletedOn(updatedCompletedOn);
        TestRailProject updatedTestRailProject5 = testRailProjectService.save(updatedTestRailProject2);
        TestRailProject getTestRailProject5 = testRailProjectService.findByTRId(2).get();

        assertNotNull(updatedTestRailProject5);
        assertEquals(updatedTestRailProject2, updatedTestRailProject5);
        assertEquals(updatedCompletedOn, updatedTestRailProject5.getCompletedOn());
        assertEquals(2, updatedTestRailProject5.getTRId());
        assertEquals(updatedTestRailProject5, getTestRailProject5);

        // Updated suiteMode

        int updatedSuiteMode = 1;
        updatedTestRailProject2.setSuiteMode(updatedSuiteMode);
        TestRailProject updatedTestRailProject6 = testRailProjectService.save(updatedTestRailProject2);
        TestRailProject getTestRailProject6 = testRailProjectService.findByTRId(2).get();

        assertNotNull(updatedTestRailProject6);
        assertEquals(updatedTestRailProject2, updatedTestRailProject6);
        assertEquals(updatedSuiteMode, updatedTestRailProject6.getSuiteMode());
        assertEquals(2, updatedTestRailProject6.getTRId());






    }
}