package mk.iwec.paymentsDemo.type.api;

import mk.iwec.paymentsDemo.infrastructure.Endpoints;
import mk.iwec.paymentsDemo.payment.dto.PaymentDTO;
import mk.iwec.paymentsDemo.type.dto.PaymentTypeDTO;
import mk.iwec.paymentsDemo.type.repository.PaymentTypeRepository;
import mk.iwec.paymentsDemo.type.service.PaymentTypeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(Endpoints.TYPE)
public class PaymentTypeController {

    private final PaymentTypeService paymentTypeService;

    public PaymentTypeController(PaymentTypeService paymentTypeService) {
        this.paymentTypeService = paymentTypeService;
    }


    @GetMapping("/{uuid}")
    public ResponseEntity<PaymentTypeDTO> getPaymentTypeById(@PathVariable UUID uuid) {
        return ResponseEntity.ok(paymentTypeService.findById(uuid));
    }

    @GetMapping
    public ResponseEntity<Page<PaymentTypeDTO>> getAllPaymentTypes(Pageable pageable) {
        Page<PaymentTypeDTO> paymentTypes = paymentTypeService.findAll(pageable);
        return ResponseEntity.ok(paymentTypes);
    }

    @PostMapping
    public ResponseEntity<PaymentTypeDTO> createPaymentType(@RequestBody PaymentTypeDTO paymentTypeDTO) {
        return new ResponseEntity<>(paymentTypeService.save(paymentTypeDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<PaymentTypeDTO> updatePaymentType(@PathVariable UUID uuid, @RequestBody PaymentTypeDTO paymentTypeDTO) {
        return ResponseEntity.ok(paymentTypeService.update(uuid, paymentTypeDTO));
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> deletePaymentType(@PathVariable UUID uuid) {
        paymentTypeService.deleteById(uuid);
        return ResponseEntity.noContent().build();
    }
}