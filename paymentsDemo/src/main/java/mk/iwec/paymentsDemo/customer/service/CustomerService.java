package mk.iwec.paymentsDemo.customer.service;

import mk.iwec.paymentsDemo.customer.dto.CustomerDTO;
import mk.iwec.paymentsDemo.customer.model.Customer;
import mk.iwec.paymentsDemo.infrastructure.mapper.GeneralMapper;
import mk.iwec.paymentsDemo.infrastructure.service.impl.GenericServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class CustomerService extends GenericServiceImpl<CustomerDTO, Customer, UUID> {
    public CustomerService(JpaRepository<Customer, UUID> repository, GeneralMapper<CustomerDTO, Customer> mapper) {
        super(repository, mapper);
    }
}
