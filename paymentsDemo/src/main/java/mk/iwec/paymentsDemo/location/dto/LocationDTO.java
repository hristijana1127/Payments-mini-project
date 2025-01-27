package mk.iwec.paymentsDemo.location.dto;


import jakarta.validation.constraints.NotBlank;

public record LocationDTO(
        @NotBlank(message = "The country is mandatory")
        String country,
        @NotBlank(message = "The region is mandatory")
        String region,
        @NotBlank(message = "The city is mandatory")
        String city
) {
}
