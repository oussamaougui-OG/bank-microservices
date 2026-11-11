package ma.mundiapolis.customer_service.web;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.mundiapolis.customer_service.dtos.*;
import ma.mundiapolis.customer_service.services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public List<CustomerResponseDTO> all() { return customerService.findAll(); }

    @GetMapping("/{id}")
    public CustomerResponseDTO byId(@PathVariable Long id) { return customerService.findById(id); }

    @PostMapping
    public CustomerResponseDTO save(@Valid @RequestBody CustomerRequestDTO dto) { return customerService.save(dto); }

    @PutMapping("/{id}")
    public CustomerResponseDTO update(@PathVariable Long id, @Valid @RequestBody CustomerRequestDTO dto) {
        return customerService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { customerService.delete(id); }
}