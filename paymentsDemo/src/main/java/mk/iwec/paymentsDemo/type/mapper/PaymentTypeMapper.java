package mk.iwec.paymentsDemo.type.mapper;

import mk.iwec.paymentsDemo.infrastructure.mapper.GeneralMapper;
import mk.iwec.paymentsDemo.payment.model.Payment;
import mk.iwec.paymentsDemo.type.dto.PaymentTypeDTO;
import mk.iwec.paymentsDemo.type.model.PaymentType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentTypeMapper extends GeneralMapper<PaymentTypeDTO, PaymentType> {
}
