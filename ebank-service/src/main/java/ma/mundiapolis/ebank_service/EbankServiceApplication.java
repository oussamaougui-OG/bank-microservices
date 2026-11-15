package ma.mundiapolis.ebank_service;

import ma.mundiapolis.ebank_service.entities.BankAccount;
import ma.mundiapolis.ebank_service.enums.AccountType;
import ma.mundiapolis.ebank_service.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
public class EbankServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EbankServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(BankAccountRepository repo) {
		return args -> {
			repo.save(BankAccount.builder().accountId(UUID.randomUUID().toString())
					.balance(12000).createdAt(LocalDate.now()).currency("MAD")
					.type(AccountType.CURRENT_ACCOUNT).customerId(1L).build());
			repo.save(BankAccount.builder().accountId(UUID.randomUUID().toString())
					.balance(45000).createdAt(LocalDate.now()).currency("MAD")
					.type(AccountType.SAVING_ACCOUNT).customerId(1L).build());
			repo.save(BankAccount.builder().accountId(UUID.randomUUID().toString())
					.balance(8000).createdAt(LocalDate.now()).currency("MAD")
					.type(AccountType.CURRENT_ACCOUNT).customerId(2L).build());
		};
	}
}