package mk.iwec.paymentsDemo.payment.api;


import mk.iwec.paymentsDemo.infrastructure.Endpoints;
import mk.iwec.paymentsDemo.payment.dto.PaymentDTO;
import mk.iwec.paymentsDemo.payment.service.PaymentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(Endpoints.PAYMENT)
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<PaymentDTO> getPaymentById(@PathVariable UUID uuid){
        return ResponseEntity.ok(paymentService.findById(uuid));
    }

    @GetMapping
    public ResponseEntity<Page<PaymentDTO>> getAllPayments(Pageable pageable){
        Page<PaymentDTO> payments = paymentService.findAll(pageable);
        return ResponseEntity.ok(payments);
    }
    @PostMapping
    public ResponseEntity<PaymentDTO> createPayment(@RequestBody PaymentDTO paymentDTO){
        return new ResponseEntity<>(paymentService.save(paymentDTO), HttpStatus.CREATED);
    }
    @PutMapping("/{uuid}")
    public ResponseEntity<PaymentDTO> updatePayment(@PathVariable UUID uuid, @RequestBody PaymentDTO paymentDTO){
        return ResponseEntity.ok(paymentService.update(uuid,paymentDTO));
    }
    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> deletePayment(@PathVariable UUID uuid){
        paymentService.deleteById(uuid);
        return ResponseEntity.noContent().build();
    }
}
