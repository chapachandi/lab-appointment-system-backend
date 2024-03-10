package lk.icbt.labappointmentsystem.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class InvoiceDTO {
    private BigDecimal amount;
    private Long invoiceId;
}