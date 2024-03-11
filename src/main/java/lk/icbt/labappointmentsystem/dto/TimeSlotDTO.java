package lk.icbt.labappointmentsystem.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lk.icbt.labappointmentsystem.entity.Reservation;
import lk.icbt.labappointmentsystem.entity.Test;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TimeSlotDTO {
    private Integer timeSlotId;

    private String startTime;
    private String endTime;
    private String displayText;
    private Boolean isActive;

}
