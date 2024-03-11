package lk.icbt.labappointmentsystem.repeository;

import lk.icbt.labappointmentsystem.entity.Invoice;
import lk.icbt.labappointmentsystem.entity.Reservation;
import lk.icbt.labappointmentsystem.entity.Test;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByInvoice(Invoice invoice);

    @Query("SELECT r FROM Reservation r WHERE r.reservationDate BETWEEN :from AND :to ")

    List<Reservation> findAllByDateAndTest(@Param("from") LocalDateTime from, @Param("to") LocalDateTime to);
}
