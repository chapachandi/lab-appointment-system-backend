package lk.icbt.labappointmentsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Entity
public class FinalResultHasTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long finalResultHasTestId;


    private String description;

    private Timestamp createdDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "testParameter_id")
    private TestParameter testParameter;

    /*@OneToMany(mappedBy = "testParameter", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FinalResultHasTest> finalResultHasTestList;*/


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "finalResult_id")
    private FinalResult finalResult;
}
