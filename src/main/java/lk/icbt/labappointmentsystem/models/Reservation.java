package lk.icbt.labappointmentsystem.models;

import jakarta.persistence.*;


import java.sql.Timestamp;


@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;


    private String description;
    private Timestamp reservationDate;
    private Boolean isActive;
    private Boolean isTested;
    private String createdBy;
    private Timestamp createdDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id")
    private Test test;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "timeSlot_id")
    private TimeSlot timeSlot;

    @OneToOne(mappedBy = "reservation", cascade = CascadeType.ALL)
    private FinalResult  finalResult;

    public Reservation(Long reservationId, String description, Timestamp reservationDate, Boolean isActive, Boolean isTested, String createdBy, Timestamp createdDate, User user, Invoice invoice, Test test, TimeSlot timeSlot, FinalResult finalResult) {
        this.reservationId = reservationId;
        this.description = description;
        this.reservationDate = reservationDate;
        this.isActive = isActive;
        this.isTested = isTested;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.user = user;
        this.invoice = invoice;
        this.test = test;
        this.timeSlot = timeSlot;
        this.finalResult = finalResult;
    }

    public Reservation() {
    }

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Timestamp reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Boolean getTested() {
        return isTested;
    }

    public void setTested(Boolean tested) {
        isTested = tested;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

    public FinalResult getFinalResult() {
        return finalResult;
    }

    public void setFinalResult(FinalResult finalResult) {
        this.finalResult = finalResult;
    }
}
