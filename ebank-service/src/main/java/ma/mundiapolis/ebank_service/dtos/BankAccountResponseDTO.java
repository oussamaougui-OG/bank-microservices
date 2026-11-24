package ma.mundiapolis.ebank_service.dtos;

import ma.mundiapolis.ebank_service.enums.AccountType;
import ma.mundiapolis.ebank_service.models.CustomerDTO;

import java.time.LocalDate;

public record BankAccountResponseDTO(
        String accountId,
        double balance,
        LocalDate createdAt,
        String currency,
        AccountType type,
        Long customerId,
        CustomerDTO customer) {
}