package lk.icbt.labappointmentsystem.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
@Getter
@Setter

public class ReservationDTO {

    private Long reservationId;

    private String description;

    private String reservationDate;

    private Boolean isActive;

    private Boolean isTested;
    private Boolean isPayed;
    private Long userId;
    private Integer testId;
    private Integer timeSlotId;



}
