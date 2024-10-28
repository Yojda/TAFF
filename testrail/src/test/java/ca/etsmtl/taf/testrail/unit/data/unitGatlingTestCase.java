package ca.etsmtl.taf.testrail.unit.data;
import ca.etsmtl.taf.testrail.model.entity.GatlingTestCase;
import ca.etsmtl.taf.testrail.service.data.GatlingTestCaseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class unitGatlingTestCase {
    private GatlingTestCaseService service;
    @BeforeEach
    void setUp() {
        service = new GatlingTestCaseService();
    }

    @Test
    void save() {
        GatlingTestCase gatlingTestCase = new GatlingTestCase();
        gatlingTestCase.setId(1L);
        gatlingTestCase.setSectionId(1);
        gatlingTestCase.setTitle("Test");

        GatlingTestCase gatlingTestCaseSaved = service.save(gatlingTestCase);
        assertEquals(gatlingTestCase, gatlingTestCaseSaved);
    }

    @Test
    void findById() {
        GatlingTestCase gatlingTestCase = new GatlingTestCase();
        gatlingTestCase.setId(1L);
        gatlingTestCase.setSectionId(1);
        gatlingTestCase.setTitle("Test");

        gatlingTestCase.setId(1L);
        assertEquals(1L, gatlingTestCase.getId());
    }

    @Test
    void findAll() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void findBySectionId() {
    }

    @Test
    void findByTitle() {
    }
}
