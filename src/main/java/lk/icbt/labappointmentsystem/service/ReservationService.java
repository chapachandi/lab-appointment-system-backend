package lk.icbt.labappointmentsystem.service;

import lk.icbt.labappointmentsystem.dto.ReservationDTO;
import lk.icbt.labappointmentsystem.entity.Reservation;

import java.util.ArrayList;
import java.util.List;

public interface ReservationService {

    public List<ReservationDTO> getAllReservations() ;


    public ReservationDTO getReservationById(Long reservationId);


    public ReservationDTO createReservation(ReservationDTO reservationDTO) ;

    public ReservationDTO updateReservation(ReservationDTO reservationDTO);


    public void deleteReservation(Long reservationId) ;
}