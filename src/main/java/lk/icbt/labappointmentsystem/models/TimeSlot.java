package lk.icbt.labappointmentsystem.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;


import java.sql.Timestamp;
import java.util.Set;


@Entity
public class TimeSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer timeSlotId;

    private Timestamp startTime;
    private Timestamp endTime;

    @NotBlank(message = "Display Text cannot be blank")
    private String displayText;


    private Boolean isActive;
    private Boolean isBooked;
    private String createdBy;
    private Timestamp createdDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id")
    private Test test;

    @OneToMany(mappedBy = "timeSlot", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Reservation> reservationList;

}
