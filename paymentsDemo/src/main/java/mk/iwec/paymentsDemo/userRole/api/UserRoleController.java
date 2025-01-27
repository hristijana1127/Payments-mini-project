package mk.iwec.paymentsDemo.userRole.api;

import mk.iwec.paymentsDemo.infrastructure.Endpoints;

import mk.iwec.paymentsDemo.userRole.dto.UserRoleDTO;
import mk.iwec.paymentsDemo.userRole.service.UserRoleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(Endpoints.ROLE)
public class UserRoleController {
    private final UserRoleService userRoleService;

    public UserRoleController(final UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }
    @GetMapping("/{uuid}")
    public ResponseEntity<UserRoleDTO> getUserRoleById(@PathVariable UUID uuid){
        return ResponseEntity.ok(userRoleService.findById(uuid));
    }

    @GetMapping
    public ResponseEntity<Page<UserRoleDTO>> getAllRoles(Pageable pageable){
        Page<UserRoleDTO> roles = userRoleService.findAll(pageable);
        return ResponseEntity.ok(roles);
    }
    @PostMapping
    public ResponseEntity<UserRoleDTO> createRoles(@RequestBody UserRoleDTO userRoleDTO){
        return new ResponseEntity<>(userRoleService.save(userRoleDTO), HttpStatus.CREATED);
    }
    @PutMapping("/{uuid}")
    public ResponseEntity<UserRoleDTO> updateRoles(@PathVariable UUID uuid, @RequestBody UserRoleDTO userRoleDTO){
        return ResponseEntity.ok(userRoleService.update(uuid,userRoleDTO));
    }
    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> deleteRole(@PathVariable UUID uuid){
        userRoleService.deleteById(uuid);
        return ResponseEntity.noContent().build();
    }
}


