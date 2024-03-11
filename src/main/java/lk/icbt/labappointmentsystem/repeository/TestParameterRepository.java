package lk.icbt.labappointmentsystem.repeository;

import lk.icbt.labappointmentsystem.entity.Test;
import lk.icbt.labappointmentsystem.entity.TestParameter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestParameterRepository extends JpaRepository<TestParameter, Integer> {
}