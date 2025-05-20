package com.example.Custumer_Service.repositories;

import com.example.Custumer_Service.models.CustumerModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustumerRepository extends JpaRepository<CustumerModel, Long> {


}
