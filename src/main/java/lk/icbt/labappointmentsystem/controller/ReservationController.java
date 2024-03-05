package lk.icbt.labappointmentsystem.controller;

import lk.icbt.labappointmentsystem.dto.ReservationDTO;
import lk.icbt.labappointmentsystem.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping
    public ResponseEntity<List<ReservationDTO>> getAllReservations() {
        List<ReservationDTO> reservationDTOs = reservationService.getAllReservations();
        return ResponseEntity.ok(reservationDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationDTO> getReservationById(@PathVariable Long id) {
        ReservationDTO reservationDTO = reservationService.getReservationById(id);
        if (reservationDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(reservationDTO);
    }

    @PostMapping
    public ResponseEntity<ReservationDTO> createReservation(@RequestBody ReservationDTO reservationDTO) {
        ReservationDTO createdReservationDTO = reservationService.createReservation(reservationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdReservationDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservationDTO> updateReservation(@PathVariable Long id, @RequestBody ReservationDTO reservationDTO) {
        //reservationDTO.setReservationId(id);
        ReservationDTO updatedReservationDTO = reservationService.updateReservation(reservationDTO);
        if (updatedReservationDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedReservationDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
      /*  if (reservationService.deleteReservation(id)) {
            return ResponseEntity.noContent().build();
        }*/
        return ResponseEntity.notFound().build();
    }
}