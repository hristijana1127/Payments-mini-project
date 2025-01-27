package mk.iwec.paymentsDemo.log.service;

import mk.iwec.paymentsDemo.infrastructure.mapper.GeneralMapper;
import mk.iwec.paymentsDemo.infrastructure.service.impl.GenericServiceImpl;
import mk.iwec.paymentsDemo.log.dto.LogDTO;
import mk.iwec.paymentsDemo.log.model.ChangesLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LogService extends GenericServiceImpl<LogDTO, ChangesLog, UUID> {
    public LogService(JpaRepository<ChangesLog, UUID> repository, GeneralMapper<LogDTO, ChangesLog> mapper) {
        super(repository, mapper);
    }
}
