package mk.iwec.paymentsDemo.type.repository;

import mk.iwec.paymentsDemo.type.model.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PaymentTypeRepository extends JpaRepository<PaymentType, UUID> {
}
