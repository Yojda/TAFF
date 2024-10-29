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

    public void beforeUpdate() {
        testRailProject.setTRId(2);
        testRailProjectService.save(testRailProject);
    }

    @Test
    public void testUpdateId() {
        /* Arrange */
        beforeUpdate();
        testRailProject.setTRId(3);

        /* Act */
        TestRailProject savedTestRailProject = testRailProjectService.save(testRailProject);

        /* Assert */
        assertNotNull(savedTestRailProject);
        assertEquals(testRailProject, savedTestRailProject);
        assertEquals(defaultName, savedTestRailProject.getName());
        assertEquals(3, savedTestRailProject.getTRId());
    }

    @Test
    public void testUpdateName() {
        /* Arrange */
        beforeUpdate();
        String updatedName = "updatedName_" + LocalDate.now() + LocalTime.now() + TestConfig.getRandomString(16);

        /* Act */
        testRailProject.setName(updatedName);
        TestRailProject updatedTestRailProject = testRailProjectService.save(testRailProject);
        TestRailProject getTestRailProject = testRailProjectService.findByTRId(2).get();

        /* Assert */
        assertNotNull(updatedTestRailProject);
        assertEquals(2, updatedTestRailProject.getTRId());
        assertEquals(updatedName, updatedTestRailProject.getName());
        assertEquals(testRailProject, updatedTestRailProject);
        assertEquals(updatedTestRailProject, getTestRailProject);
    }

    @Test
    public void testUpdateAnnouncement() {
        /* Arrange */
        beforeUpdate();
        String updatedAnnouncement = "updatedAnnouncement_" + LocalDate.now() + LocalTime.now() + TestConfig.getRandomString(16);

        /* Act */
        testRailProject.setAnnouncement(updatedAnnouncement);
        TestRailProject updatedTestRailProject = testRailProjectService.save(testRailProject);
        TestRailProject getTestRailProject = testRailProjectService.findByTRId(2).get();

        /* Assert */
        assertNotNull(updatedTestRailProject);
        assertEquals(2, updatedTestRailProject.getTRId());
        assertEquals(updatedAnnouncement, updatedTestRailProject.getAnnouncement());
        assertEquals(testRailProject, updatedTestRailProject);
        assertEquals(updatedTestRailProject, getTestRailProject);
    }

    @Test
    public void testUpdateShowAnnouncement() {
        /* Arrange */
        beforeUpdate();
        boolean updatedShowAnnouncement = true;

        /* Act */
        testRailProject.setShowAnnouncement(updatedShowAnnouncement);
        TestRailProject updatedTestRailProject = testRailProjectService.save(testRailProject);
        TestRailProject getTestRailProject = testRailProjectService.findByTRId(2).get();

        /* Assert */
        assertNotNull(updatedTestRailProject);
        assertEquals(2, updatedTestRailProject.getTRId());
        assertEquals(updatedShowAnnouncement, updatedTestRailProject.getShowAnnouncement());
        assertEquals(testRailProject, updatedTestRailProject);
        assertEquals(updatedTestRailProject, getTestRailProject);
    }

    @Test
    public void testUpdateIsCompleted() {
        /* Arrange */
        beforeUpdate();
        boolean updatedIsCompleted = true;

        /* Act */
        testRailProject.setIsCompleted(updatedIsCompleted);
        TestRailProject updatedTestRailProject = testRailProjectService.save(testRailProject);
        TestRailProject getTestRailProject = testRailProjectService.findByTRId(2).get();

        /* Assert */
        assertNotNull(updatedTestRailProject);
        assertEquals(testRailProject, updatedTestRailProject);
        assertEquals(updatedIsCompleted, updatedTestRailProject.getIsCompleted());
        assertEquals(2, updatedTestRailProject.getTRId());
        assertEquals(updatedTestRailProject, getTestRailProject);

    }

    @Test
    public void testUpdateCompletedOn() {
        /* Arrange */
        beforeUpdate();
        Timestamp updatedCompletedOn = new Timestamp(System.currentTimeMillis());

        /* Act */
        testRailProject.setCompletedOn(updatedCompletedOn);
        TestRailProject updatedTestRailProject = testRailProjectService.save(testRailProject);
        TestRailProject getTestRailProject = testRailProjectService.findByTRId(2).get();

        /* Assert */
        assertNotNull(updatedTestRailProject);
        assertEquals(2, updatedTestRailProject.getTRId());
        assertEquals(updatedCompletedOn, updatedTestRailProject.getCompletedOn());
        assertEquals(testRailProject, updatedTestRailProject);
        assertEquals(updatedTestRailProject, getTestRailProject);

    }

    @Test
    public void testUpdateSuiteMode() {
        /* Arrange */
        beforeUpdate();
        int updatedSuiteMode = 1;

        /* Act */
        testRailProject.setSuiteMode(updatedSuiteMode);
        TestRailProject updatedTestRailProject = testRailProjectService.save(testRailProject);
        TestRailProject getTestRailProject = testRailProjectService.findByTRId(2).get();

        /* Assert */
        assertNotNull(updatedTestRailProject);
        assertEquals(2, updatedTestRailProject.getTRId());
        assertEquals(updatedSuiteMode, updatedTestRailProject.getSuiteMode());
        assertEquals(testRailProject, updatedTestRailProject);
        assertEquals(updatedTestRailProject, getTestRailProject);
    }

    @Test
    public void testUpdateDefaultRoleId() {
        /* Arrange */
        beforeUpdate();
        int updatedDefaultRoleId = 1;

        /* Act */
        testRailProject.setDefaultRoleId(updatedDefaultRoleId);
        TestRailProject updatedTestRailProject = testRailProjectService.save(testRailProject);
        TestRailProject getTestRailProject = testRailProjectService.findByTRId(2).get();

        /* Assert */
        assertNotNull(updatedTestRailProject);
        assertEquals(2, updatedTestRailProject.getTRId());
        assertEquals(updatedDefaultRoleId, updatedTestRailProject.getDefaultRoleId());
        assertEquals(testRailProject, updatedTestRailProject);
        assertEquals(updatedTestRailProject, getTestRailProject);
    }

    @Test
    public void testUpdateCaseStatusesEnabled() {
        /* Arrange */
        beforeUpdate();
        boolean updatedCaseStatusesEnabled = true;

        /* Act */
        testRailProject.setCaseStatusesEnabled(updatedCaseStatusesEnabled);
        TestRailProject updatedTestRailProject = testRailProjectService.save(testRailProject);
        TestRailProject getTestRailProject = testRailProjectService.findByTRId(2).get();

        /* Assert */
        assertNotNull(updatedTestRailProject);
        assertEquals(2, updatedTestRailProject.getTRId());
        assertEquals(updatedCaseStatusesEnabled, updatedTestRailProject.getCaseStatusesEnabled());
        assertEquals(testRailProject, updatedTestRailProject);
        assertEquals(updatedTestRailProject, getTestRailProject);
    }

    @Test
    public void testUpdateUrl() {
        /* Arrange */
        beforeUpdate();
        String updatedUrl = "updatedUrl_" + LocalDate.now() + LocalTime.now() + TestConfig.getRandomString(16);

        /* Act */
        testRailProject.setUrl(updatedUrl);
        TestRailProject updatedTestRailProject = testRailProjectService.save(testRailProject);
        TestRailProject getTestRailProject = testRailProjectService.findByTRId(2).get();

        /* Assert */
        assertNotNull(updatedTestRailProject);
        assertEquals(2, updatedTestRailProject.getTRId());
        assertEquals(updatedUrl, updatedTestRailProject.getUrl());
        assertEquals(testRailProject, updatedTestRailProject);
        assertEquals(updatedTestRailProject, getTestRailProject);
    }

}