package lk.icbt.labappointmentsystem.service;

import lk.icbt.labappointmentsystem.dto.InvoiceCreateDTO;
import lk.icbt.labappointmentsystem.dto.InvoiceDTO;
import lk.icbt.labappointmentsystem.dto.TestDTO;
import lk.icbt.labappointmentsystem.dto.UserDTO;
import lk.icbt.labappointmentsystem.entity.Test;
import org.springframework.data.domain.Page;

public interface InvoiceService {
    public InvoiceDTO createInvoice(InvoiceCreateDTO invoiceCreateDTO);
}
