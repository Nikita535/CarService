package com.example.carservice.repository;

import com.example.carservice.entity.Contract;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {

    @Override
    List<Contract> findAll();

    List<Contract> findByClient_Id(Long id);



    Contract findContractById(Long id);

    @Override
    void deleteById(Long aLong);
}