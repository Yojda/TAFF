package ca.etsmtl.taf.testrail.repository;

import ca.etsmtl.taf.testrail.model.entity.GatlingResult;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface GatlingResultRepository extends JpaRepository<GatlingResult, Long> {
    /*
    * This interface is used to interact with the GatlingResult table in the database.
    * Assisted by IA (copilot & chatGPT & intellij)
    * Tests : TODO
    * */

    // Search for GatlingResult by statusId
    List<GatlingResult> findByStatusId(Integer statusId);
}
