package lk.icbt.labappointmentsystem.repeository;

import lk.icbt.labappointmentsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    User findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email, String password);

    boolean existsByEmail(String email);
}
