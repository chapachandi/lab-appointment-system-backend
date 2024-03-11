package lk.icbt.labappointmentsystem.service.impl;

import lk.icbt.labappointmentsystem.dto.AvalableTimeSlotDTO;
import lk.icbt.labappointmentsystem.dto.TimeSlotDTO;
import lk.icbt.labappointmentsystem.entity.Reservation;
import lk.icbt.labappointmentsystem.entity.Test;
import lk.icbt.labappointmentsystem.entity.TimeSlot;
import lk.icbt.labappointmentsystem.repeository.ReservationRepository;
import lk.icbt.labappointmentsystem.repeository.TestRepository;
import lk.icbt.labappointmentsystem.repeository.TimeSlotRepository;
import lk.icbt.labappointmentsystem.service.TimeSlotService;
import lk.icbt.labappointmentsystem.util.DateUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class TimeSlotServiceImpl implements TimeSlotService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private TimeSlotRepository timeSlotRepository;

    @Autowired
    private ReservationRepository reservationRepository;
    @Override
    public List<TimeSlotDTO> getAvailableTimeSlot(AvalableTimeSlotDTO avalableTimeSlotDTO) {
        Optional<Test> test = testRepository.findById(avalableTimeSlotDTO.getTestId());
        List<TimeSlot> allByTest = timeSlotRepository.findAllByTest(test.get());
        DateUtils dateUtils = new DateUtils();
        LocalDateTime startTime =dateUtils.getLocalTimeByString(avalableTimeSlotDTO.getReservingDate()+" 00:00:00");
        LocalDateTime endTime =dateUtils.getLocalTimeByString(avalableTimeSlotDTO.getReservingDate()+" 23:59:59");

        List<Reservation> allByDateAndTest = reservationRepository.findAllByDateAndTest(startTime, endTime);
        allByDateAndTest = allByDateAndTest.stream().filter((e) ->
                e.getTest().getTestId() == test.get().getTestId()
        ).toList();

        List<TimeSlot> bookedTimeSlot = allByDateAndTest.stream().map(e ->
            e.getTimeSlot()
        ).collect(Collectors.toList());
        allByTest = removeSameTimeSlots(bookedTimeSlot, allByTest);




        return allByTest.stream().map((e) -> modelMapper.map(e, TimeSlotDTO.class)).collect(Collectors.toList());
    }

    private List<TimeSlot> removeSameTimeSlots(List<TimeSlot> bookedTimeSlot,List<TimeSlot> allByTest){

        for (TimeSlot a:bookedTimeSlot){
            allByTest.removeIf((e) -> e.getTimeSlotId() == a.getTimeSlotId());
        }

        return allByTest;
    }
}
