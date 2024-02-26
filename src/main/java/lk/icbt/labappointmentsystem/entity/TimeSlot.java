package lk.icbt.labappointmentsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
public class TimeSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer timeSlotId;

    private Timestamp startTime;
    private Timestamp endTime;

    @NotBlank(message = "Test name cannot be blank")
    private String displayText;


    private Boolean isActive;
    private Boolean isBooked;
    private String createdBy;
    private Timestamp createdDate;
}
