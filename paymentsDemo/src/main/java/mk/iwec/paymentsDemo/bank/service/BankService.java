package mk.iwec.paymentsDemo.bank.service;

import mk.iwec.paymentsDemo.bank.dto.BankDTO;
import mk.iwec.paymentsDemo.bank.model.Bank;
import mk.iwec.paymentsDemo.infrastructure.mapper.GeneralMapper;
import mk.iwec.paymentsDemo.infrastructure.service.impl.GenericServiceImpl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BankService  extends GenericServiceImpl<BankDTO, Bank, UUID> {
    public BankService(JpaRepository<Bank, UUID> repository, GeneralMapper<BankDTO, Bank> mapper) {
        super(repository, mapper);
    }
}
