package lk.icbt.labappointmentsystem.repeository;

import lk.icbt.labappointmentsystem.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Integer> {
}