package mk.iwec.paymentsDemo.bank.mapper;

import mk.iwec.paymentsDemo.bank.dto.BankDTO;
import mk.iwec.paymentsDemo.bank.model.Bank;
import mk.iwec.paymentsDemo.infrastructure.mapper.GeneralMapper;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface BankMapper extends GeneralMapper<BankDTO, Bank> {
}
