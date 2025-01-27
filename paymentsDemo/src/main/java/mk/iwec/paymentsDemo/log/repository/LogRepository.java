package mk.iwec.paymentsDemo.log.repository;

import mk.iwec.paymentsDemo.log.model.ChangesLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LogRepository extends JpaRepository<ChangesLog, UUID> {
}
