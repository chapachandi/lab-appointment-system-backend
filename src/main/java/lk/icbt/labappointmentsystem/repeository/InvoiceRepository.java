package lk.icbt.labappointmentsystem.repeository;

import lk.icbt.labappointmentsystem.entity.Invoice;
import lk.icbt.labappointmentsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

}
