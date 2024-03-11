package lk.icbt.labappointmentsystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lk.icbt.labappointmentsystem.enums.ReservationStatus;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;


    private String description;
    private LocalDateTime reservationDate;
    private Boolean isActive;
    private Boolean isTested;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id")
    private Test test;

    @ManyToOne
    @JoinColumn(name = "timeSlot_id")
    private TimeSlot timeSlot;

    @OneToOne(mappedBy = "reservation", cascade = CascadeType.ALL)
    private FinalResult  finalResult;
    @Enumerated(EnumType.STRING)
    private ReservationStatus reservationStatus;

}
