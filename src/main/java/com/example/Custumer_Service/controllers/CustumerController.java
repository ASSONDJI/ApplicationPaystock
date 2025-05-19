package com.example.Custumer_Service.controllers;

import com.example.Custumer_Service.Services.CustumerService;
import com.example.Custumer_Service.models.Custumer;
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
    public List<Custumer> getAllCustumers() {
        return custumerService.getAllCustumers();
    }

    @GetMapping("/{id}")
    public Optional<Custumer> getCustumerById(@PathVariable Long id) {
        return custumerService.getCustumerById(id);
    }

    @PostMapping
    public Custumer createCustomer(@RequestBody Custumer custumer) {
        return custumerService.createCustumer(custumer);
    }

    @PutMapping("/{id}")
    public Custumer updateCustomer(@PathVariable Long id, @RequestBody Custumer custumer) {
        return custumerService.updateCustumer(id, custumer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustumer(@PathVariable Long id) {
        custumerService.deleteCustumer(id);
    }
}
