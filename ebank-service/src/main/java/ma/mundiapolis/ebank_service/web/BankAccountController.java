package ma.mundiapolis.ebank_service.web;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.mundiapolis.ebank_service.dtos.*;
import ma.mundiapolis.ebank_service.services.BankAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class BankAccountController {
    private final BankAccountService service;

    @GetMapping
    public List<BankAccountResponseDTO> all() { return service.findAll(); }

    @GetMapping("/{id}")
    public BankAccountResponseDTO byId(@PathVariable String id) { return service.findById(id); }

    @GetMapping("/customer/{customerId}")
    public List<BankAccountResponseDTO> byCustomer(@PathVariable Long customerId) {
        return service.findByCustomerId(customerId);
    }

    @PostMapping
    public BankAccountResponseDTO save(@Valid @RequestBody BankAccountRequestDTO dto) {
        return service.save(dto);
    }
}