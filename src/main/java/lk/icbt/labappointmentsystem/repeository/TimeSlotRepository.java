package lk.icbt.labappointmentsystem.repeository;

import lk.icbt.labappointmentsystem.entity.Test;
import lk.icbt.labappointmentsystem.entity.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TimeSlotRepository extends JpaRepository<TimeSlot, Integer> {

    List<TimeSlot> findAllByTest(Test test) ;
}
