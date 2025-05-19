package com.example.Custumer_Service.mapper;

import com.example.Custumer_Service.dto.CustumerRequestDto;
import com.example.Custumer_Service.dto.CustumerResponseDto;
import com.example.Custumer_Service.models.Custumer;
import org.springframework.stereotype.Component;

@Component
public class CustumerMapper {
    public Custumer toEntity(CustumerRequestDto dto) {
        if (dto == null) return null;

        Custumer entity = new Custumer();
        entity.setNom_client(dto.nom_client());
        entity.setPrenom_client(dto.prenom_client());
        entity.setAdd_client(dto.add_client());
        return entity;
    }

    public CustumerResponseDto toDto(Custumer entity) {
        if (entity == null) return null;

        return new CustumerResponseDto(
                entity.getId_client(),
                entity.getNom_client(),
                entity.getPrenom_client(),
                entity.getAdd_client()
        );
    }
}
