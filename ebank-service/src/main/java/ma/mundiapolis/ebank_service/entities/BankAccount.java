package ma.mundiapolis.ebank_service.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.mundiapolis.ebank_service.enums.AccountType;

import java.time.LocalDate;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccount {
    @Id
    private String accountId;
    private double balance;
    private LocalDate createdAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    private Long customerId;
}