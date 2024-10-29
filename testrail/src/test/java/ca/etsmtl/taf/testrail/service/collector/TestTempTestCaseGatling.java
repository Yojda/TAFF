package ca.etsmtl.taf.testrail.service.collector;

import ca.etsmtl.taf.testrail.TestConfig;
import ca.etsmtl.taf.testrail.model.entity.GatlingTestCase;
import ca.etsmtl.taf.testrail.model.entity.TestRailProject;
import ca.etsmtl.taf.testrail.model.factory.TestRailProjectFactory;
import ca.etsmtl.taf.testrail.repository.TestRailProjectRepository;
import ca.etsmtl.taf.testrail.service.collector.TempTestCaseGatling;
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

//@ContextConfiguration(classes = TestConfig.class)
//@DataJpaTest(properties = {
//        "spring.jpa.hibernate.ddl-auto=create-drop",
//        "spring.datasource.url=jdbc:h2:mem:testdb"
//})
public class TestTempTestCaseGatling {
    private String defaultName;

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void test() {
        TempTestCaseGatling tempTestCaseGatling = new TempTestCaseGatling();
        GatlingTestCase gatlingTestCase = tempTestCaseGatling.parse();
        assertNotNull(gatlingTestCase);
        assertEquals("My First Scenario", gatlingTestCase.getScenarioName());
        assertEquals("https://wikijs.fornoff.fr", gatlingTestCase.getBaseUrl());
        assertEquals("(Scenario.injectOpen(rampUsers(10).during(5))).protocols(httpProtocol)", gatlingTestCase.getUserInjection());
    }
}