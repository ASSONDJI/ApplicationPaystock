
package com.example.Custumer_Service.controllers;

import com.example.Custumer_Service.Services.CustumerService;
import com.example.Custumer_Service.dto.CustumerRequestDto;
import com.example.Custumer_Service.dto.CustumerResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/custumers")
@CrossOrigin(origins = "*")
public class CustumerController {

    @Autowired
    private CustumerService custumerService;

    @GetMapping
    public List<CustumerResponseDto> getAllCustumers() {
        return custumerService.getAllCustumers();
    }

    @GetMapping("/{id}")
    public Optional<CustumerResponseDto> getCustumerById(@PathVariable Long id) {
        return Optional.ofNullable(custumerService.getCustumerById(id));
    }

    @PostMapping
    public CustumerResponseDto createCustomer(@RequestBody CustumerRequestDto dto) {
        return custumerService.createCustumer(dto);
    }

    @PutMapping("/{id}")
    public CustumerResponseDto updateCustomer(@PathVariable Long id, @RequestBody CustumerRequestDto dto) {
        return custumerService.updateCustumer(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteCustumer(@PathVariable Long id) {
        custumerService.deleteCustumer(id);
    }
}
