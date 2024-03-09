package lk.icbt.labappointmentsystem.repeository;

import lk.icbt.labappointmentsystem.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
