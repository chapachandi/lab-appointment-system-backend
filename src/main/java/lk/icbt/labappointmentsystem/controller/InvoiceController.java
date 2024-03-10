package lk.icbt.labappointmentsystem.controller;

import lk.icbt.labappointmentsystem.dto.InvoiceCreateDTO;
import lk.icbt.labappointmentsystem.dto.InvoiceDTO;
import lk.icbt.labappointmentsystem.dto.TestDTO;
import lk.icbt.labappointmentsystem.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/invoice")
@CrossOrigin
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @PostMapping
    public ResponseEntity<InvoiceDTO> createTest(@RequestBody InvoiceCreateDTO invoiceCreateDTO) {
        InvoiceDTO invoice = invoiceService.createInvoice(invoiceCreateDTO);

        return new ResponseEntity<>(invoice, HttpStatus.CREATED);
    }
}
