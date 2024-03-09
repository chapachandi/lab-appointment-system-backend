package lk.icbt.labappointmentsystem.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Set;


@Entity
public class TestParameter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer testParameterId;

    @NotBlank(message = "Patient name cannot be blank")
    private String patientName;

    @NotBlank(message = "Test name cannot be blank")
    private String testName;


    private BigDecimal price;
    private String createdBy;
    private Timestamp createdDate;


    @OneToMany(mappedBy = "testParameter", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<FinalResultHasTest> finalResultHasTestList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id")
    private Test test;

    public TestParameter(Integer testParameterId, String patientName, String testName, BigDecimal price, String createdBy, Timestamp createdDate, Set<FinalResultHasTest> finalResultHasTestList, Test test) {
        this.testParameterId = testParameterId;
        this.patientName = patientName;
        this.testName = testName;
        this.price = price;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.finalResultHasTestList = finalResultHasTestList;
        this.test = test;
    }

    public TestParameter() {
    }

    public Integer getTestParameterId() {
        return testParameterId;
    }

    public void setTestParameterId(Integer testParameterId) {
        this.testParameterId = testParameterId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Set<FinalResultHasTest> getFinalResultHasTestList() {
        return finalResultHasTestList;
    }

    public void setFinalResultHasTestList(Set<FinalResultHasTest> finalResultHasTestList) {
        this.finalResultHasTestList = finalResultHasTestList;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }


}
