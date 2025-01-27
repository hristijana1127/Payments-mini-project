package mk.iwec.paymentsDemo.bank.api;

import mk.iwec.paymentsDemo.bank.dto.BankDTO;
import mk.iwec.paymentsDemo.bank.service.BankService;
import mk.iwec.paymentsDemo.infrastructure.Endpoints;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(Endpoints.BANK)
public class BankController {
    private final BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }


    @GetMapping("/{uuid}")
    public ResponseEntity<BankDTO> getBankById(@PathVariable UUID uuid){
        return ResponseEntity.ok(bankService.findById(uuid));
    }

    @GetMapping
    public ResponseEntity<Page<BankDTO>> getAllBank(Pageable pageable){
        Page<BankDTO> banks = bankService.findAll(pageable);
        return ResponseEntity.ok(banks);
    }
    @PostMapping
    public ResponseEntity<BankDTO> createBank(@RequestBody BankDTO bankDTO){
        return new ResponseEntity<>(bankService.save(bankDTO), HttpStatus.CREATED);
    }
    @PutMapping("/{uuid}")
    public ResponseEntity<BankDTO> updateBank(@PathVariable UUID uuid, @RequestBody BankDTO bankDTO){
        return ResponseEntity.ok(bankService.update(uuid, bankDTO));
    }
    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> deleteBank(@PathVariable UUID uuid){
        bankService.deleteById(uuid);
        return ResponseEntity.noContent().build();
    }
}


