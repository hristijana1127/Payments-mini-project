package mk.iwec.paymentsDemo.customer.api;

import mk.iwec.paymentsDemo.customer.dto.CustomerDTO;
import mk.iwec.paymentsDemo.customer.service.CustomerService;
import mk.iwec.paymentsDemo.infrastructure.Endpoints;
import mk.iwec.paymentsDemo.payment.dto.PaymentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(Endpoints.CUSTOMER)
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping("/{uuid}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable UUID uuid){
        return ResponseEntity.ok(customerService.findById(uuid));
    }

    @GetMapping
    public ResponseEntity<Page<CustomerDTO>> getAllCustomers(Pageable pageable){
        Page<CustomerDTO> customers = customerService.findAll(pageable);
        return ResponseEntity.ok(customers );
    }
    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO){
        return new ResponseEntity<>(customerService.save(customerDTO), HttpStatus.CREATED);
    }
    @PutMapping("/{uuid}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable UUID uuid, @RequestBody CustomerDTO customerDTO){
        return ResponseEntity.ok(customerService.update(uuid,customerDTO));
    }
    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable UUID uuid){
        customerService.deleteById(uuid);
        return ResponseEntity.noContent().build();
    }
}
