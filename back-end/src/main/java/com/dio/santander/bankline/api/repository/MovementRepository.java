package com.dio.santander.bankline.api.repository;

import com.dio.santander.bankline.api.model.Movement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovementRepository extends JpaRepository<Movement,Integer> {
    public List<Movement> findByIdAccount(Integer idAccount);
}
