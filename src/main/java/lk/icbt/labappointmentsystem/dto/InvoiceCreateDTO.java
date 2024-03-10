package lk.icbt.labappointmentsystem.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class InvoiceCreateDTO {
    private List<Long> reservationIdList;
    private Long userId;


}
