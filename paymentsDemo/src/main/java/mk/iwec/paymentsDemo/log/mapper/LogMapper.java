package mk.iwec.paymentsDemo.log.mapper;

import mk.iwec.paymentsDemo.infrastructure.mapper.GeneralMapper;
import mk.iwec.paymentsDemo.log.dto.LogDTO;
import mk.iwec.paymentsDemo.log.model.ChangesLog;
import mk.iwec.paymentsDemo.payment.mappper.PaymentMapper;
import mk.iwec.paymentsDemo.user.mapper.UserMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class, PaymentMapper.class})
public interface LogMapper extends GeneralMapper<LogDTO, ChangesLog> {}
