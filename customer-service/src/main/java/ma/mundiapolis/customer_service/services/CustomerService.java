package ma.mundiapolis.customer_service.services;


import lombok.RequiredArgsConstructor;
import ma.mundiapolis.customer_service.dtos.*;
import ma.mundiapolis.customer_service.entities.Customer;
import ma.mundiapolis.customer_service.mappers.CustomerMapper;
import ma.mundiapolis.customer_service.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public List<CustomerResponseDTO> findAll() {
        return customerRepository.findAll().stream().map(customerMapper::toDTO).toList();
    }

    public CustomerResponseDTO findById(Long id) {
        return customerMapper.toDTO(getOrThrow(id));
    }

    public CustomerResponseDTO save(CustomerRequestDTO dto) {
        Customer saved = customerRepository.save(customerMapper.toEntity(dto));
        return customerMapper.toDTO(saved);
    }

    public CustomerResponseDTO update(Long id, CustomerRequestDTO dto) {
        Customer c = getOrThrow(id);
        c.setFirstName(dto.firstName());
        c.setLastName(dto.lastName());
        c.setEmail(dto.email());
        return customerMapper.toDTO(customerRepository.save(c));
    }

    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    private Customer getOrThrow(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found: " + id));
    }
}