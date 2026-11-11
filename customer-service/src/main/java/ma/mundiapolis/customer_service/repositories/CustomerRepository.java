package ma.mundiapolis.customer_service.repositories;


import ma.mundiapolis.customer_service.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
