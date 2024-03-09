package lk.icbt.labappointmentsystem.models;

import jakarta.persistence.*;


import java.sql.Timestamp;


@Entity
public class FinalResultHasTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long finalResultHasTestId;


    private String description;
    private Boolean isActive;
    private String createdBy;
    private Timestamp createdDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "testParameter_id")
    private TestParameter testParameter;

    /*@OneToMany(mappedBy = "testParameter", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FinalResultHasTest> finalResultHasTestList;*/


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "finalResult_id")
    private FinalResult finalResult;

    public FinalResultHasTest(Long finalResultHasTestId, String description, Boolean isActive, String createdBy, Timestamp createdDate, TestParameter testParameter, FinalResult finalResult) {
        this.finalResultHasTestId = finalResultHasTestId;
        this.description = description;
        this.isActive = isActive;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.testParameter = testParameter;
        this.finalResult = finalResult;
    }

    public FinalResultHasTest() {
    }

    public Long getFinalResultHasTestId() {
        return finalResultHasTestId;
    }

    public void setFinalResultHasTestId(Long finalResultHasTestId) {
        this.finalResultHasTestId = finalResultHasTestId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
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

    public TestParameter getTestParameter() {
        return testParameter;
    }

    public void setTestParameter(TestParameter testParameter) {
        this.testParameter = testParameter;
    }

    public FinalResult getFinalResult() {
        return finalResult;
    }

    public void setFinalResult(FinalResult finalResult) {
        this.finalResult = finalResult;
    }
}
