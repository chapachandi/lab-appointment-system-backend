package lk.icbt.labappointmentsystem.service.impl;

import lk.icbt.labappointmentsystem.dto.ReservationDTO;
import lk.icbt.labappointmentsystem.entity.Reservation;
import lk.icbt.labappointmentsystem.entity.Test;
import lk.icbt.labappointmentsystem.entity.TimeSlot;
import lk.icbt.labappointmentsystem.entity.User;
import lk.icbt.labappointmentsystem.repeository.ReservationRepository;
import lk.icbt.labappointmentsystem.repeository.TestRepository;
import lk.icbt.labappointmentsystem.repeository.TimeSlotRepository;
import lk.icbt.labappointmentsystem.repeository.UserRepository;
import lk.icbt.labappointmentsystem.service.ReservationService;
import lk.icbt.labappointmentsystem.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private TimeSlotRepository timeSlotRepository;

    @Override
    public List<ReservationDTO> getAllReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        List<ReservationDTO> reservationDTOs = new ArrayList<>();

        for (Reservation reservation : reservations) {
            reservationDTOs.add(modelMapper.map(reservation, ReservationDTO.class));
        }
        return reservationDTOs;
    }

    @Override
    public ReservationDTO getReservationById(Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId).orElse(null);
        return modelMapper.map(reservation, ReservationDTO.class);
    }

    @Override
    public ReservationDTO createReservation(ReservationDTO reservationDTO) {
        Reservation reservation = modelMapper.map(reservationDTO, Reservation.class);
        Optional<User> reservedUser = userRepository.findById(reservationDTO.getCustomerId());
        Optional<Test> test = testRepository.findById(reservationDTO.getTestId());
        Optional<TimeSlot> timeSlot = timeSlotRepository.findById(reservationDTO.getTimeSlotId());
        if(reservedUser.isPresent() && test.isPresent() && timeSlot.isPresent()){
            reservation.setUser(reservedUser.get());
            reservation.setTest(test.get());
            reservation.setTimeSlot(timeSlot.get());
        }

        reservation = reservationRepository.save(reservation);
        return modelMapper.map(reservation, ReservationDTO.class);
    }

    @Override
    public ReservationDTO updateReservation(ReservationDTO reservationDTO) {
        Reservation reservation = modelMapper.map(reservationDTO, Reservation.class);
        reservation = reservationRepository.save(reservation);
        return modelMapper.map(reservation, ReservationDTO.class);
    }

    @Override
    public void deleteReservation(Long reservationId) {
        reservationRepository.deleteById(reservationId);
    }
}

