package com.example.carservice.repository;

import com.example.carservice.entity.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    @Query("select p from Product p")
    @Override
    List<Product> findAll(Sort sort);

    @Query("select p from Product p where p.id = ?1")
    Product findProductById(Long id);


    @Query("delete from Product p where p.id = ?1")
    @Transactional
    @Modifying
    @Override
    void deleteById(Long aLong);


}