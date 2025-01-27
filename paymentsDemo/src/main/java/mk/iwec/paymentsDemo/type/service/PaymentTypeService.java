package mk.iwec.paymentsDemo.type.service;

import mk.iwec.paymentsDemo.infrastructure.mapper.GeneralMapper;
import mk.iwec.paymentsDemo.infrastructure.service.impl.GenericServiceImpl;
import mk.iwec.paymentsDemo.type.dto.PaymentTypeDTO;
import mk.iwec.paymentsDemo.type.model.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentTypeService extends GenericServiceImpl<PaymentTypeDTO,PaymentType, UUID> {


    public PaymentTypeService(JpaRepository<PaymentType, UUID> repository, GeneralMapper<PaymentTypeDTO, PaymentType> mapper) {
        super(repository, mapper);
    }
}
