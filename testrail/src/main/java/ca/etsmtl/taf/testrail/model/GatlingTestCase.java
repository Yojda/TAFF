package ca.etsmtl.taf.testrail.model;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tr_gatling_test_case")
@Getter
@Setter
public class GatlingTestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "section_id", nullable = false)
    private Integer sectionId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "template_id")
    private Integer templateId;

    @Column(name = "type_id")
    private Integer typeId;

    @Column(name = "priority_id")
    private Integer priorityId;

    @Column(name = "estimate")
    private String estimate;

    @Column(name = "milestone_id")
    private Integer milestoneId;

    @Column(name = "refs")
    private String refs;
}