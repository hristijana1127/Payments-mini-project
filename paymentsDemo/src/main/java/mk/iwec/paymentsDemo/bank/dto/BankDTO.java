package mk.iwec.paymentsDemo.bank.dto;

import jakarta.validation.constraints.NotBlank;

public record BankDTO(
        @NotBlank(message = "Name is mandatory")
        String name

) {}
