package ca.etsmtl.taf.testrail.model.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tr_project")
@Getter
@Setter
public class TestRailProject extends TestRailData {

    /*
    * Class to save projects from TestRail in TAF database to be used in the application.
    * Class build assisted by IA (copilot & chatGPT & intellij)
    * Tests : TODO
    * */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tafId;

    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "announcement")
    private String announcement;

    @Column(name = "show_announcement")
    private Boolean showAnnouncement;

    @Column(name = "is_completed")
    private Boolean isCompleted;

    @Column(name = "completed_on")
    private String completedOn;

    @Column(name = "suite_mode")
    private Integer suiteMode;

    @Column(name = "default_role_id")
    private Integer defaultRoleId;

    @Column(name = "case_statuses_enabled")
    private Boolean caseStatusesEnabled;

    @Column(name = "url")
    private String url;

    @ManyToMany(mappedBy = "projects")
    private List<TestRailUser> users;
}
