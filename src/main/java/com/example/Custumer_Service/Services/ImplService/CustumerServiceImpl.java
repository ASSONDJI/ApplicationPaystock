package com.example.Custumer_Service.Services.ImplService;

import com.example.Custumer_Service.Services.CustumerService;
import com.example.Custumer_Service.dto.CustumerRequestDto;
import com.example.Custumer_Service.dto.CustumerResponseDto;
import com.example.Custumer_Service.exceptions.CustumerNotFoundException;
import com.example.Custumer_Service.mapper.CustumerMapper;
import com.example.Custumer_Service.models.CustumerModel;
import com.example.Custumer_Service.repositories.CustumerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustumerServiceImpl implements CustumerService {

    private final CustumerRepository custumerRepository;
    private final CustumerMapper mapper;

    public CustumerServiceImpl(CustumerRepository custumerRepository, CustumerMapper mapper) {
        this.custumerRepository = custumerRepository;
        this.mapper = mapper;
    }

    @Override
    public CustumerResponseDto createCustumer(CustumerRequestDto dto) {
        CustumerModel entity = mapper.toEntity(dto);
        CustumerModel saved = custumerRepository.save(entity);
        return mapper.toDto(saved);
    }

    @Override
    public List<CustumerResponseDto> getAllCustumers() {
        return custumerRepository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CustumerResponseDto getCustumerById(Long id) {
        CustumerModel custumer = custumerRepository.findById(id)
                .orElseThrow(() -> new CustumerNotFoundException(id));
         return mapper.toDto(custumer);
    }

    @Override
    public CustumerResponseDto updateCustumer(Long id, CustumerRequestDto dto) {
        CustumerModel existing = custumerRepository.findById(id)
                .orElseThrow(() -> new CustumerNotFoundException(id));

        existing.setNom_client(dto.nom_client());
        existing.setPrenom_client(dto.prenom_client());
        existing.setAdd_client(dto.add_client());

        CustumerModel updated = custumerRepository.save(existing);
        return mapper.toDto(updated);
    }

    @Override
    public void deleteCustumer(Long id) {
        CustumerModel custumer = custumerRepository.findById(id)
                .orElseThrow(() -> new CustumerNotFoundException(id));
        custumerRepository.delete(custumer);
    }
}
