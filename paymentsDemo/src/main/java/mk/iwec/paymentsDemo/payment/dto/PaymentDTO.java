package mk.iwec.paymentsDemo.payment.dto;

import jakarta.validation.constraints.NotBlank;
import mk.iwec.paymentsDemo.bank.model.Bank;
import mk.iwec.paymentsDemo.customer.model.Customer;
import mk.iwec.paymentsDemo.location.model.Location;
import mk.iwec.paymentsDemo.type.model.PaymentType;

import java.time.LocalDateTime;

public record PaymentDTO(
        @NotBlank(message = "The date and time are mandatory")
        LocalDateTime dateTime,
        @NotBlank(message = "The date and time are mandatory")
        float amount,
        @NotBlank(message = "A description of the payment is mandatory")
        String note,
        @NotBlank(message = "The customer of the payment is mandatory")
        Customer customer,
        @NotBlank(message = "The type of the payment mandatory")
        PaymentType paymentType,
        @NotBlank(message = "The location the payment is made is mandatory")
        Location location,
        @NotBlank(message = "The bank of the payment is mandatory")
        Bank bank

) {}
