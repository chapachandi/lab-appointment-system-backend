package lk.icbt.labappointmentsystem.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.icbt.labappointmentsystem.dto.CreateFinalResultDTO;
import lk.icbt.labappointmentsystem.dto.ReservationDTO;
import org.springframework.core.io.ByteArrayResource;

public interface FinalResultService {
    public ReservationDTO createFinalResult(CreateFinalResultDTO createFinalResultDTO);

    public ByteArrayResource printReport(HttpServletRequest request, HttpServletResponse response, Long id);
}
