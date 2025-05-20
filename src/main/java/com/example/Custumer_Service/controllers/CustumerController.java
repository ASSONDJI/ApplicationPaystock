package com.example.Custumer_Service.controllers;

import com.example.Custumer_Service.Services.CustumerService;
import com.example.Custumer_Service.dto.CustumerRequestDto;
import com.example.Custumer_Service.dto.CustumerResponseDto;
import com.example.Custumer_Service.exceptions.CustumerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/custumers")
@CrossOrigin(origins = "*")
public class CustumerController {

    private final CustumerService custumerService;

    public CustumerController(CustumerService custumerService) {
        this.custumerService = custumerService;
    }

    @PostMapping("/save")
    public ResponseEntity<CustumerResponseDto> saveCustumer(@RequestBody CustumerRequestDto dto) {
        CustumerResponseDto saved = custumerService.createCustumer(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<CustumerResponseDto>> getAllCustumers() {
        List<CustumerResponseDto> custumers = custumerService.getAllCustumers();
        return ResponseEntity.ok(custumers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustumerResponseDto> getCustumerById(@PathVariable Long id) {
        try {
            CustumerResponseDto custumer = custumerService.getCustumerById(id);
            return ResponseEntity.ok(custumer);
        } catch (CustumerNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CustumerResponseDto> updateCustumer(@PathVariable Long id,                                                              @RequestBody CustumerRequestDto dto) {
        try {
            CustumerResponseDto updated = custumerService.updateCustumer(id, dto);
            return ResponseEntity.ok(updated);
        } catch (CustumerNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteCustumer(@PathVariable Long id) {
        try {
            custumerService.deleteCustumer(id);
            return ResponseEntity.ok(true);
        } catch (CustumerNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
        }
    }
}
