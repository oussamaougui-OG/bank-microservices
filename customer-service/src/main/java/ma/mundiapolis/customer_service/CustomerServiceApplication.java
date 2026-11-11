package ma.mundiapolis.customer_service;

import ma.mundiapolis.customer_service.entities.Customer;
import ma.mundiapolis.customer_service.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository repo) {
		return args -> {
			repo.save(Customer.builder().firstName("Oussama").lastName("A").email("oussama@mail.com").build());
			repo.save(Customer.builder().firstName("Sara").lastName("B").email("sara@mail.com").build());
			repo.save(Customer.builder().firstName("Yassine").lastName("C").email("yassine@mail.com").build());
		};
	}
}