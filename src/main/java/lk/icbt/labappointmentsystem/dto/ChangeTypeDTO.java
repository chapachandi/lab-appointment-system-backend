package lk.icbt.labappointmentsystem.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ChangeTypeDTO {

    private Long reservationId;
    private String status;


}
