package mk.iwec.paymentsDemo.customer.dto;

import jakarta.validation.constraints.NotBlank;
import mk.iwec.paymentsDemo.location.model.Location;

public record CustomerDTO(
        @NotBlank(message = "First name is mandatory")
        String firstName,
        @NotBlank(message = "Last name is mandatory")
        String lastName,
        @NotBlank(message = "Location of origin is mandatory")
        Location location
) {
}
