package mk.iwec.paymentsDemo.type.dto;

import jakarta.validation.constraints.NotBlank;

public record PaymentTypeDTO(
        @NotBlank(message = "type is mandatory")
        String type) {
}
