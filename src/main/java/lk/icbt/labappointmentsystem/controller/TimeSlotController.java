package lk.icbt.labappointmentsystem.controller;

import lk.icbt.labappointmentsystem.dto.AvalableTimeSlotDTO;
import lk.icbt.labappointmentsystem.dto.ReservationDTO;
import lk.icbt.labappointmentsystem.dto.TimeSlotDTO;
import lk.icbt.labappointmentsystem.service.TimeSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/timeslot")
@CrossOrigin
public class TimeSlotController {
    @Autowired
    private TimeSlotService timeSlotService;

@PostMapping("/getAvailableTimeSlot")
public ResponseEntity<List<TimeSlotDTO>> getAvailableTimeSlot(@RequestBody AvalableTimeSlotDTO avalableTimeSlotDTO){
    List<TimeSlotDTO> availableTimeSlot = timeSlotService.getAvailableTimeSlot(avalableTimeSlotDTO);
      return ResponseEntity.status(HttpStatus.CREATED).body(availableTimeSlot);
}
}
