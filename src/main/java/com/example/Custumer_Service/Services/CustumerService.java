package com.example.Custumer_Service.Services;

import com.example.Custumer_Service.models.Custumer;
import com.example.Custumer_Service.repositories.custumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustumerService {

    @Autowired
    private custumerRepository custumerRepository;

    public List<Custumer> getAllCustumers() {
        return custumerRepository.findAll();
    }

    public Optional<Custumer> getCustumerById(Long id) {
        return custumerRepository.findById(id);
    }

    public Custumer createCustumer(Custumer custumer) {
        return custumerRepository.save(custumer);
    }

    public Custumer updateCustumer(Long id, Custumer updatedCustumer) {
        return custumerRepository.findById(id).map(custumer -> {
            custumer.setNom_client(updatedCustumer.getNom_client());
            custumer.setPrenom_client(updatedCustumer.getPrenom_client());
            custumer.setAdd_client(updatedCustumer.getAdd_client());
            return custumerRepository.save(custumer);
        }).orElse(null);
    }

    public void deleteCustumer(Long id) {
        custumerRepository.deleteById(id);
    }
}
