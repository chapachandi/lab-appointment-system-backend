package lk.icbt.labappointmentsystem.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateFinalResultDTO {
    private Long reservationId;
    private String description;
    private List<PrameterDataDTO> prameterDataDTOList;

}
