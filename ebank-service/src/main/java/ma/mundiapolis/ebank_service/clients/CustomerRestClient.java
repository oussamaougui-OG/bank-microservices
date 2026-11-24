package ma.mundiapolis.ebank_service.clients;

import ma.mundiapolis.ebank_service.models.CustomerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
public interface CustomerRestClient {

    @GetMapping("/api/customers/{id}")
    CustomerDTO findCustomerById(@PathVariable("id") Long id);
}