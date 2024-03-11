package lk.icbt.labappointmentsystem.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.icbt.labappointmentsystem.dto.InvoiceCreateDTO;
import lk.icbt.labappointmentsystem.dto.InvoiceDTO;
import lk.icbt.labappointmentsystem.dto.TestDTO;
import lk.icbt.labappointmentsystem.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/invoice")
@CrossOrigin
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @PostMapping
    public ResponseEntity<InvoiceDTO> createInvoice(@RequestBody InvoiceCreateDTO invoiceCreateDTO) {
        InvoiceDTO invoice = invoiceService.createInvoice(invoiceCreateDTO);

        return new ResponseEntity<>(invoice, HttpStatus.CREATED);
    }
    @PostMapping("/{id}")
    public ResponseEntity<ByteArrayResource> printInvoice(HttpServletRequest request, HttpServletResponse response,@PathVariable Long id) {

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM).header("Content-Disposition", "attachment; filename=invoice.pdf").body(invoiceService.printInvoice(request,response,id));
    }


}
