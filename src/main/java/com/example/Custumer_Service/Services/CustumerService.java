package com.example.Custumer_Service.Services;

import com.example.Custumer_Service.dto.CustumerRequestDto;
import com.example.Custumer_Service.dto.CustumerResponseDto;

import java.util.List;

public interface CustumerService {
    List<CustumerResponseDto> getAllCustumers();

    CustumerResponseDto getCustumerById(Long id);

    CustumerResponseDto createCustumer(CustumerRequestDto dto);

    CustumerResponseDto updateCustumer(Long id, CustumerRequestDto dto);

    void deleteCustumer(Long id);
}
