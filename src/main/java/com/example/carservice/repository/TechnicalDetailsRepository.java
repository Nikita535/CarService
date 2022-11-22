package com.example.carservice.repository;

import com.example.carservice.entity.TechnicalDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicalDetailsRepository extends JpaRepository<TechnicalDetails, Long> {
}