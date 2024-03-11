package lk.icbt.labappointmentsystem.service;

import lk.icbt.labappointmentsystem.dto.ChangeTypeDTO;
import lk.icbt.labappointmentsystem.dto.ReservationDTO;
import lk.icbt.labappointmentsystem.entity.Reservation;

import java.util.ArrayList;
import java.util.List;

public interface ReservationService  {

    public List<ReservationDTO> getAllReservations() ;
    public List<ReservationDTO> getAllReservationsByUser(Long userId) ;
    public ReservationDTO changeReservationsStatus(ChangeTypeDTO changeTypeDTO) ;


    public ReservationDTO getReservationById(Long reservationId);


    public ReservationDTO createReservation(ReservationDTO reservationDTO) ;

    public ReservationDTO updateReservation(ReservationDTO reservationDTO);
    public ReservationDTO updatePayment(Long reservationId);


    public void deleteReservation(Long reservationId) ;
}