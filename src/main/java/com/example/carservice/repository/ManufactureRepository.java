package com.example.carservice.repository;

import com.example.carservice.entity.Manufacture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufactureRepository extends JpaRepository<Manufacture, Long> {
}