package com.example.carservice.repository;

import com.example.carservice.entity.EngineType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EngineTypeRepository extends JpaRepository<EngineType, Long> {
}