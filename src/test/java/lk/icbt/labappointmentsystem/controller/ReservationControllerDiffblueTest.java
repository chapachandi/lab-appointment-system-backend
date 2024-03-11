package lk.icbt.labappointmentsystem.controller;

import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

import lk.icbt.labappointmentsystem.dto.ReservationDTO;
import lk.icbt.labappointmentsystem.service.ReservationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {ReservationController.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class ReservationControllerDiffblueTest {
    @Autowired
    private ReservationController reservationController;

    @MockBean
    private ReservationService reservationService;

    /**
     * Method under test: {@link ReservationController#getAllReservations()}
     */
    @Test
    void testGetAllReservations() throws Exception {
        // Arrange
        when(reservationService.getAllReservations()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/reservations");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(reservationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link ReservationController#getReservationById(Long)}
     */
    @Test
    void testGetReservationById() throws Exception {
        // Arrange
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setCustomerId(1L);
        reservationDTO.setDescription("The characteristics of someone or something");
        reservationDTO.setIsActive(true);
        reservationDTO.setIsTested(true);
        reservationDTO.setReservationDate("2020-03-01");
        reservationDTO.setReservationId(1L);
        reservationDTO.setTestId(1);
        reservationDTO.setTimeSlotId(1);
        when(reservationService.getReservationById(Mockito.<Long>any())).thenReturn(reservationDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/reservations/{id}", 1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(reservationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"reservationId\":1,\"description\":\"The characteristics of someone or something\",\"reservationDate\":\"2020"
                                        + "-03-01\",\"isActive\":true,\"isTested\":true,\"customerId\":1,\"testId\":1,\"timeSlotId\":1}"));
    }

    /**
     * Method under test:
     * {@link ReservationController#createReservation(ReservationDTO)}
     */
    @Test
    void testCreateReservation() throws Exception {
        // Arrange
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setCustomerId(1L);
        reservationDTO.setDescription("The characteristics of someone or something");
        reservationDTO.setIsActive(true);
        reservationDTO.setIsTested(true);
        reservationDTO.setReservationDate("2020-03-01");
        reservationDTO.setReservationId(1L);
        reservationDTO.setTestId(1);
        reservationDTO.setTimeSlotId(1);
        when(reservationService.createReservation(Mockito.<ReservationDTO>any())).thenReturn(reservationDTO);

        ReservationDTO reservationDTO2 = new ReservationDTO();
        reservationDTO2.setCustomerId(1L);
        reservationDTO2.setDescription("The characteristics of someone or something");
        reservationDTO2.setIsActive(true);
        reservationDTO2.setIsTested(true);
        reservationDTO2.setReservationDate("2020-03-01");
        reservationDTO2.setReservationId(1L);
        reservationDTO2.setTestId(1);
        reservationDTO2.setTimeSlotId(1);
        String content = (new ObjectMapper()).writeValueAsString(reservationDTO2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/reservations")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(reservationController)
                .build()
                .perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"reservationId\":1,\"description\":\"The characteristics of someone or something\",\"reservationDate\":\"2020"
                                        + "-03-01\",\"isActive\":true,\"isTested\":true,\"customerId\":1,\"testId\":1,\"timeSlotId\":1}"));
    }

    /**
     * Method under test:
     * {@link ReservationController#updateReservation(Long, ReservationDTO)}
     */
    @Test
    void testUpdateReservation() throws Exception {
        // Arrange
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setCustomerId(1L);
        reservationDTO.setDescription("The characteristics of someone or something");
        reservationDTO.setIsActive(true);
        reservationDTO.setIsTested(true);
        reservationDTO.setReservationDate("2020-03-01");
        reservationDTO.setReservationId(1L);
        reservationDTO.setTestId(1);
        reservationDTO.setTimeSlotId(1);
        when(reservationService.updateReservation(Mockito.<ReservationDTO>any())).thenReturn(reservationDTO);

        ReservationDTO reservationDTO2 = new ReservationDTO();
        reservationDTO2.setCustomerId(1L);
        reservationDTO2.setDescription("The characteristics of someone or something");
        reservationDTO2.setIsActive(true);
        reservationDTO2.setIsTested(true);
        reservationDTO2.setReservationDate("2020-03-01");
        reservationDTO2.setReservationId(1L);
        reservationDTO2.setTestId(1);
        reservationDTO2.setTimeSlotId(1);
        String content = (new ObjectMapper()).writeValueAsString(reservationDTO2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/reservations/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(reservationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"reservationId\":1,\"description\":\"The characteristics of someone or something\",\"reservationDate\":\"2020"
                                        + "-03-01\",\"isActive\":true,\"isTested\":true,\"customerId\":1,\"testId\":1,\"timeSlotId\":1}"));
    }

    /**
     * Method under test: {@link ReservationController#deleteReservation(Long)}
     */
    @Test
    void testDeleteReservation() throws Exception {
        // Arrange
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/reservations/{id}", 1L);

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(reservationController)
                .build()
                .perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Method under test: {@link ReservationController#deleteReservation(Long)}
     */
    @Test
    void testDeleteReservation2() throws Exception {
        // Arrange
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/reservations/{id}", 1L);
        requestBuilder.contentType("https://example.org/example");

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(reservationController)
                .build()
                .perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}
