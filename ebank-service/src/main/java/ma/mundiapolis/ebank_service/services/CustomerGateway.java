package ma.mundiapolis.ebank_service.services;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import ma.mundiapolis.ebank_service.clients.CustomerRestClient;
import ma.mundiapolis.ebank_service.models.CustomerDTO;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerGateway {
    private final CustomerRestClient customerRestClient;

    @CircuitBreaker(name = "customerService", fallbackMethod = "getDefaultCustomer")
    public CustomerDTO getCustomer(Long id) {
        return customerRestClient.findCustomerById(id);
    }

    public CustomerDTO getDefaultCustomer(Long id, Exception e) {
        return new CustomerDTO(id, "Not available", "Not available", "Not available");
    }
}