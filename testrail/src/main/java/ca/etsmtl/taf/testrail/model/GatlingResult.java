package ca.etsmtl.taf.testrail.model;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tr_gatling_result")
@Getter
@Setter
public class GatlingResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status_id", nullable = false)
    private Integer statusId;

    @Column(name = "comment")
    private String comment;

    @Column(name = "version")
    private String version;

    @Column(name = "elapsed")
    private String elapsed;

    @Column(name = "defects")
    private String defects;

    @Column(name = "assignedto_id")
    private Integer assignedToId;
}