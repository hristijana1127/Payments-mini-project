package mk.iwec.paymentsDemo.payment.service;

import mk.iwec.paymentsDemo.infrastructure.mapper.GeneralMapper;
import mk.iwec.paymentsDemo.infrastructure.service.impl.GenericServiceImpl;
import mk.iwec.paymentsDemo.payment.dto.PaymentDTO;
import mk.iwec.paymentsDemo.payment.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentService extends GenericServiceImpl<PaymentDTO, Payment, UUID>{

    public PaymentService(JpaRepository<Payment, UUID> repository, GeneralMapper<PaymentDTO, Payment> mapper) {
        super(repository, mapper);
    }
}
