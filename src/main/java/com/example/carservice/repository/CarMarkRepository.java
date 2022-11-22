package com.example.carservice.repository;

import com.example.carservice.entity.CarMark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarMarkRepository extends JpaRepository<CarMark, Long> {
}