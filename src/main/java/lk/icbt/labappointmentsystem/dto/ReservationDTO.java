package lk.icbt.labappointmentsystem.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
@Getter
@Setter

public class ReservationDTO {

    private Long reservationId;

    private String description;

    private Timestamp reservationDate;

    private Boolean isActive;

    private Boolean isTested;

    private String createdBy;

    private Timestamp createdDate;
}
