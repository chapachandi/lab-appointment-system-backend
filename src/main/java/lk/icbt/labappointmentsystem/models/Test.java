package lk.icbt.labappointmentsystem.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;


import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Set;


@Entity
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer testId;


    @NotBlank(message = "Test name cannot be blank")
    private String testName;




    private BigDecimal price;
    private String createdBy;
    private Timestamp createdDate;

    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Reservation> reservationList;

    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TimeSlot> timeSlotList;

    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TestParameter> testParameterList;

    public Test(Integer testId, String testName, BigDecimal price, String createdBy, Timestamp createdDate, Set<Reservation> reservationList, Set<TimeSlot> timeSlotList, Set<TestParameter> testParameterList) {
        this.testId = testId;
        this.testName = testName;
        this.price = price;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.reservationList = reservationList;
        this.timeSlotList = timeSlotList;
        this.testParameterList = testParameterList;
    }

    public Test() {
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
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

    public Set<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(Set<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    public Set<TimeSlot> getTimeSlotList() {
        return timeSlotList;
    }

    public void setTimeSlotList(Set<TimeSlot> timeSlotList) {
        this.timeSlotList = timeSlotList;
    }

    public Set<TestParameter> getTestParameterList() {
        return testParameterList;
    }

    public void setTestParameterList(Set<TestParameter> testParameterList) {
        this.testParameterList = testParameterList;
    }
}
