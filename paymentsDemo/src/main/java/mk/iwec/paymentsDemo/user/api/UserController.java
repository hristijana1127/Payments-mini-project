package mk.iwec.paymentsDemo.user.api;

import mk.iwec.paymentsDemo.infrastructure.Endpoints;
import mk.iwec.paymentsDemo.payment.dto.PaymentDTO;
import mk.iwec.paymentsDemo.user.dto.UserDTO;
import mk.iwec.paymentsDemo.user.model.User;
import mk.iwec.paymentsDemo.user.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(Endpoints.USER)
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/{uuid}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable UUID uuid){
        return ResponseEntity.ok(userService.findById(uuid));
    }



    @GetMapping
    public ResponseEntity<Page<UserDTO>> getAllUsers(Pageable pageable){
        Page<UserDTO> users = userService.findAll(pageable);
        return ResponseEntity.ok(users);
    }
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        return new ResponseEntity<>(userService.save(userDTO), HttpStatus.CREATED);
    }
    @PutMapping("/{uuid}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable UUID uuid, @RequestBody UserDTO userDTO){
        return ResponseEntity.ok(userService.update(uuid,userDTO));
    }
    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID uuid){
        userService.deleteById(uuid);
        return ResponseEntity.noContent().build();
    }
}
