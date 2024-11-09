package ca.etsmtl.taf.testrail.model.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "tr_gatling_test_case")
@Getter
@Setter
public class GatlingTestCase {

    /*
     * Assisted by IA (copilot & chatGPT & intellij)
     * Tests : TODO
     * */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tr_id", unique = true, nullable = true)
    private Integer TRId;

    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @Column(name = "section_id")
    private Integer sectionId;

    @Column(name = "type_id")
    private Integer typeId;

    @Column(name = "priority_id")
    private Integer priorityId;

    @Column(name = "milestone_id")
    private Integer milestoneId;

    @Column(name = "refs")
    private String refs;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "created_on")
    private Timestamp createdOn;

    @Column(name = "updated_by")
    private Integer updatedBy;

    @Column(name = "updated_on")
    private Timestamp updatedOn;

    @Column(name = "estimate")
    private Timestamp estimate;

    @Column(name = "estimate_forecast")
    private Timestamp estimateForecast;

    @Column(name = "suite_id")
    private Integer suiteId;

    @Column(name = "template_id")
    private Integer templateId;

    @Column(name = "scenario_name", nullable = false)
    private String scenarioName;

    @Column(name = "base_url", nullable = false)
    private String baseUrl;

    @Column(name = "user_injection")
    private String userInjection;
}