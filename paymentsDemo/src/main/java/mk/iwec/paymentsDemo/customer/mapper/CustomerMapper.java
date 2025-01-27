package mk.iwec.paymentsDemo.customer.mapper;

import mk.iwec.paymentsDemo.customer.dto.CustomerDTO;
import mk.iwec.paymentsDemo.customer.model.Customer;
import mk.iwec.paymentsDemo.infrastructure.mapper.GeneralMapper;
import mk.iwec.paymentsDemo.location.mapper.LocationMapper;
import mk.iwec.paymentsDemo.payment.mappper.PaymentMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses ={LocationMapper.class, PaymentMapper.class})
public interface CustomerMapper extends GeneralMapper<CustomerDTO, Customer> {
}
