package lk.icbt.labappointmentsystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Entity
public class TestParameter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer testParameterId;



    @NotBlank(message = "Test name cannot be blank")
    private String testName;


    private BigDecimal price;
    private String parameterRange;


    @OneToMany(mappedBy = "testParameter", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FinalResultHasTest> finalResultHasTestList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id")
    private Test test;


}
