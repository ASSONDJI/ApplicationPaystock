package com.example.Custumer_Service.Services;

import com.example.Custumer_Service.dto.CustumerRequestDto;
import com.example.Custumer_Service.dto.CustumerResponseDto;
import com.example.Custumer_Service.exceptions.ResourceNotFoundException;
import com.example.Custumer_Service.mapper.CustumerMapper;
import com.example.Custumer_Service.models.Custumer;
import com.example.Custumer_Service.repositories.custumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustumerService {

    @Autowired
    private custumerRepository custumerRepository;

    @Autowired
    private CustumerMapper mapper;


    public List<CustumerResponseDto> getAllCustumers() {
        return custumerRepository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public CustumerResponseDto getCustumerById(Long id) {
        Custumer custumer = custumerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Le client avec l'ID " + id + " n'existe pas."));
        return mapper.toDto(custumer);
    }

    public CustumerResponseDto createCustumer(CustumerRequestDto dto) {
        Custumer entity = mapper.toEntity(dto);
        return mapper.toDto(custumerRepository.save(entity));
    }

    public CustumerResponseDto updateCustumer(Long id, CustumerRequestDto dto) {
        Custumer existing = custumerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Impossible de modifier : le client avec l'ID " + id + " n'existe pas."));

        existing.setNom_client(dto.nom_client());
        existing.setPrenom_client(dto.prenom_client());
        existing.setAdd_client(dto.add_client());

        return mapper.toDto(custumerRepository.save(existing));
    }

    public void deleteCustumer(Long id) {
        Custumer custumer = custumerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Impossible de supprimer : le client avec l'ID " + id + " n'existe pas."));
        custumerRepository.delete(custumer);
    }
}
