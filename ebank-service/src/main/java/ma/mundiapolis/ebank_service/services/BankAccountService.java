package ma.mundiapolis.ebank_service.services;

import lombok.RequiredArgsConstructor;
import ma.mundiapolis.ebank_service.dtos.*;
import ma.mundiapolis.ebank_service.entities.BankAccount;
import ma.mundiapolis.ebank_service.mappers.BankAccountMapper;
import ma.mundiapolis.ebank_service.models.CustomerDTO;
import ma.mundiapolis.ebank_service.repositories.BankAccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BankAccountService {
    private final BankAccountRepository repository;
    private final BankAccountMapper mapper;
    private final CustomerGateway customerGateway;

    public BankAccountResponseDTO save(BankAccountRequestDTO dto) {
        BankAccount saved = repository.save(mapper.toEntity(dto));
        return mapper.toDTO(saved);
    }

    public List<BankAccountResponseDTO> findAll() {
        return repository.findAll().stream().map(this::withCustomer).toList();
    }

    public BankAccountResponseDTO findById(String id) {
        BankAccount account = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found: " + id));
        return withCustomer(account);
    }

    public List<BankAccountResponseDTO> findByCustomerId(Long customerId) {
        CustomerDTO customer = customerGateway.getCustomer(customerId);
        return repository.findByCustomerId(customerId).stream()
                .map(a -> mapper.toDTO(a, customer))
                .toList();
    }

    private BankAccountResponseDTO withCustomer(BankAccount account) {
        CustomerDTO customer = customerGateway.getCustomer(account.getCustomerId());
        return mapper.toDTO(account, customer);
    }
}