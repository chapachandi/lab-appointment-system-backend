package lk.icbt.labappointmentsystem.service;

import lk.icbt.labappointmentsystem.dto.AvalableTimeSlotDTO;
import lk.icbt.labappointmentsystem.dto.TimeSlotDTO;

import java.util.List;

public interface TimeSlotService {
    public List<TimeSlotDTO> getAvailableTimeSlot(AvalableTimeSlotDTO avalableTimeSlotDTO);
}
