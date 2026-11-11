package ma.mundiapolis.customer_service.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CustomerRequestDTO(
        @NotBlank String firstName,
        @NotBlank String lastName,
        @NotBlank @Email String email) {
}