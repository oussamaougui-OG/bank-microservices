package ma.mundiapolis.ebank_service.dtos;

import jakarta.validation.constraints.NotNull;
import ma.mundiapolis.ebank_service.enums.AccountType;

public record BankAccountRequestDTO(
        double balance,
        @NotNull String currency,
        @NotNull AccountType type,
        @NotNull Long customerId) {
}