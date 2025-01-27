package mk.iwec.paymentsDemo.log.dto;


import jakarta.validation.constraints.NotBlank;
import mk.iwec.paymentsDemo.payment.model.Payment;
import mk.iwec.paymentsDemo.user.model.User;

import java.sql.Timestamp;
import java.util.List;

public record LogDTO(
        @NotBlank(message = "Payments are madatory")
        List<Payment> payments,
        @NotBlank(message = "The users that made the changes are madatory")
        User user,
        @NotBlank(message = "The actions made are madatory")
        String action,
        @NotBlank(message = "Timestamps are madatory")
        Timestamp timestamp,
        @NotBlank(message = "Details are madatory")
        String details
) {
}
