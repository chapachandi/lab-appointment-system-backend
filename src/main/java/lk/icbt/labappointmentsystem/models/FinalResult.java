package lk.icbt.labappointmentsystem.models;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Set;


@Entity
public class FinalResult {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long finalResultId;


    private String description;
    private String createdBy;
    private Timestamp createdDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    @OneToMany(mappedBy = "finalResult", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<FinalResultHasTest> finalResultHasTestList;

    public Long getFinalResultId() {
        return finalResultId;
    }

    public void setFinalResultId(Long finalResultId) {
        this.finalResultId = finalResultId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Set<FinalResultHasTest> getFinalResultHasTestList() {
        return finalResultHasTestList;
    }

    public void setFinalResultHasTestList(Set<FinalResultHasTest> finalResultHasTestList) {
        this.finalResultHasTestList = finalResultHasTestList;
    }

    public FinalResult(Long finalResultId, String description, String createdBy, Timestamp createdDate, Reservation reservation, Set<FinalResultHasTest> finalResultHasTestList) {
        this.finalResultId = finalResultId;
        this.description = description;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.reservation = reservation;
        this.finalResultHasTestList = finalResultHasTestList;
    }

    public FinalResult() {
    }
}
