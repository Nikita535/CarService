package com.example.carservice.repository;

import com.example.carservice.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("select c from Client c where c.id = ?1")
    Client findClientById(Long id);

    @Query("select c from Client c where c.telephoneNumber = ?1")
    Client findClientByTelephoneNumber(String telephoneNumber);

    @Query("select c from Client c")
    @Override
    List<Client> findAll();

    @Query("delete from Client c where c.id = ?1")
    @Transactional
    @Modifying
    @Override
    void deleteById(Long aLong);

    @Transactional
    @Modifying
    @Query("update Client c set c.password = ?1 where c.telephoneNumber = ?2")
    int updatePasswordByTelephoneNumber(String password, String telephoneNumber);

    @Transactional
    @Modifying
    @Query("update Client c set c.name = ?1, c.surname = ?2, c.passportData = ?3, c.telephoneNumber = ?4 where c.id = ?5")
    void updateNameAndSurnameAndPassportDataAndTelephoneNumberById(String name, String surname, String passportData, String telephoneNumber, Long id);








}