package lk.icbt.labappointmentsystem.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.icbt.labappointmentsystem.dto.AvalableTimeSlotDTO;
import lk.icbt.labappointmentsystem.dto.CreateFinalResultDTO;
import lk.icbt.labappointmentsystem.dto.ReservationDTO;
import lk.icbt.labappointmentsystem.dto.TimeSlotDTO;
import lk.icbt.labappointmentsystem.repeository.ReservationRepository;
import lk.icbt.labappointmentsystem.service.FinalResultService;
import lk.icbt.labappointmentsystem.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/finalResult")
@CrossOrigin
public class FinalResultController {
    @Autowired
    private FinalResultService finalResultService;


    @PostMapping
    public ResponseEntity<ReservationDTO> addFinalResults(@RequestBody CreateFinalResultDTO createFinalResultDTO){
        ReservationDTO finalResult = finalResultService.createFinalResult(createFinalResultDTO);
        return new ResponseEntity<>(finalResult, HttpStatus.CREATED);

    }
    @PostMapping("/{id}")
    public ResponseEntity<ByteArrayResource> printReport(HttpServletRequest request, HttpServletResponse response, @PathVariable Long id) {

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM).header("Content-Disposition", "attachment; filename=report.pdf").body(finalResultService.printReport(request,response,id));
    }
}
