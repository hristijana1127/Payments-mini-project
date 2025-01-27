package mk.iwec.paymentsDemo.userRole.dto;

import jakarta.validation.constraints.NotBlank;
import mk.iwec.paymentsDemo.user.model.User;

import java.util.Set;

public record UserRoleDTO(
        @NotBlank(message = "Name of role is mandatory")
       String roleName,
     @NotBlank(message = "User are mandatory")
     Set<User> users
) {
}
