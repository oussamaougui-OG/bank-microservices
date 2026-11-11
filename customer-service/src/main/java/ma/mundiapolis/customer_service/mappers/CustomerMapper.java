package ma.mundiapolis.customer_service.mappers;

import ma.mundiapolis.customer_service.dtos.*;
import ma.mundiapolis.customer_service.entities.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer toEntity(CustomerRequestDTO dto) {
        return Customer.builder()
                .firstName(dto.firstName())
                .lastName(dto.lastName())
                .email(dto.email())
                .build();
    }

    public CustomerResponseDTO toDTO(Customer c) {
        return new CustomerResponseDTO(c.getId(), c.getFirstName(), c.getLastName(), c.getEmail());
    }
}