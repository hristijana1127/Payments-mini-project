package mk.iwec.paymentsDemo.user.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

public record UserDTO(
        @NotBlank(message =  "username is mandatory")
        String username
) {
}
