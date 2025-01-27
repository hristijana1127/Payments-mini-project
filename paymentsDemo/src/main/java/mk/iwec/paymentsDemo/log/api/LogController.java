package mk.iwec.paymentsDemo.log.api;

import mk.iwec.paymentsDemo.infrastructure.Endpoints;
import mk.iwec.paymentsDemo.log.dto.LogDTO;
import mk.iwec.paymentsDemo.log.service.LogService;
import mk.iwec.paymentsDemo.payment.dto.PaymentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(Endpoints.LOG)
public class LogController {
    private final LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<LogDTO> getLogById(@PathVariable UUID uuid){
        return ResponseEntity.ok(logService.findById(uuid));
    }

    @GetMapping
    public ResponseEntity<Page<LogDTO>> getAllLogs(Pageable pageable){
        Page<LogDTO> logs = logService.findAll(pageable);
        return ResponseEntity.ok(logs);
    }

}
