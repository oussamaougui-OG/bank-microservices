package ma.mundiapolis.ebank_service.mappers;

import ma.mundiapolis.ebank_service.dtos.*;
import ma.mundiapolis.ebank_service.entities.BankAccount;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

@Component
public class BankAccountMapper {

    public BankAccount toEntity(BankAccountRequestDTO dto) {
        return BankAccount.builder()
                .accountId(UUID.randomUUID().toString())
                .balance(dto.balance())
                .createdAt(LocalDate.now())
                .currency(dto.currency())
                .type(dto.type())
                .customerId(dto.customerId())
                .build();
    }

    public BankAccountResponseDTO toDTO(BankAccount a) {
        return new BankAccountResponseDTO(a.getAccountId(), a.getBalance(), a.getCreatedAt(),
                a.getCurrency(), a.getType(), a.getCustomerId());
    }
}