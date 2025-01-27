package mk.iwec.paymentsDemo.payment.mappper;

import mk.iwec.paymentsDemo.bank.mapper.BankMapper;
import mk.iwec.paymentsDemo.customer.mapper.CustomerMapper;
import mk.iwec.paymentsDemo.infrastructure.mapper.GeneralMapper;
import mk.iwec.paymentsDemo.location.mapper.LocationMapper;
import mk.iwec.paymentsDemo.payment.dto.PaymentDTO;
import mk.iwec.paymentsDemo.payment.model.Payment;
import mk.iwec.paymentsDemo.type.mapper.PaymentTypeMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses =  {CustomerMapper.class, PaymentTypeMapper.class, LocationMapper.class, BankMapper.class})
public interface PaymentMapper extends GeneralMapper<PaymentDTO, Payment> {
}
