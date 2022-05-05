package com.dio.santander.bankline.api.controller;


import com.dio.santander.bankline.api.model.Movement;
import com.dio.santander.bankline.api.repository.MovementRepository;
import com.dio.santander.bankline.api.service.MovementService;
import com.dio.santander.bankline.api.vo.NewMovement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/movements")
public class MovementController {
    private final MovementRepository movementRepository;
    private final MovementService movementService;

    @Autowired
    public MovementController(MovementRepository movementRepository, MovementService movementService) {
        this.movementRepository = movementRepository;
        this.movementService = movementService;
    }

    @GetMapping
    public List<Movement> findAll(){
        return movementRepository.findAll();

    }

    @PostMapping
    public void save(@RequestBody NewMovement newMovement) {
        movementService.save(newMovement);
    }
}
