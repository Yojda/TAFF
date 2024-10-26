package ca.etsmtl.taf.testrail.model.entity;


import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tr_user")
@Getter
@Setter
public class TestRailUser extends TestRailData {
    /*
    * Class to save users from TestRail.
    * Class build assisted by IA (copilot & chatGPT & intellij)
    * Tests : TODO
    * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tafId;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @ManyToMany
    @JoinTable(
        name = "tr_user_project",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "project_id"))
    private List<TestRailProject> projects;

}
