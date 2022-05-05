package com.dio.santander.bankline.api.repository;

import com.dio.santander.bankline.api.model.Movement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovementRepository extends JpaRepository<Movement,Integer> {
}
