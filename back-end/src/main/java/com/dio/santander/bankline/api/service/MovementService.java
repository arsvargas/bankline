package com.dio.santander.bankline.api.service;


import com.dio.santander.bankline.api.constant.MovementEnum;
import com.dio.santander.bankline.api.model.AccountHolder;
import com.dio.santander.bankline.api.model.Movement;
import com.dio.santander.bankline.api.repository.AccountHolderRepository;
import com.dio.santander.bankline.api.repository.MovementRepository;
import com.dio.santander.bankline.api.vo.NewMovement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MovementService {
    private final MovementRepository movementRepository;
    private final AccountHolderRepository accountHolderRepository;
    @Autowired
    public MovementService(MovementRepository movementRepository, AccountHolderRepository accountHolderRepository) {
        this.movementRepository = movementRepository;
        this.accountHolderRepository = accountHolderRepository;
    }

    public void save(NewMovement newMovement) {
        Movement movement = new Movement();
        MovementEnum type = newMovement.getType();
        Double value = verifyType(type,newMovement.getValue());
        Integer idAccount = newMovement.getIdAccount();

        movement.setDateTime(LocalDateTime.now());
        movement.setDescription(newMovement.getDescription());
        movement.setType(type);
        movement.setIdAccount(idAccount);
        movement.setValue(value);

        updateAccountHolderBalance(value, idAccount);
        movementRepository.save(movement);
    }
    private void updateAccountHolderBalance(Double updatedValue, Integer idAccount){
        AccountHolder accountHolder = accountHolderRepository.findById(idAccount).orElse(null);
        if(accountHolder != null) {
            accountHolder.getAccount().setBalance(accountHolder.getAccount().getBalance() + updatedValue);
            accountHolderRepository.save(accountHolder);
        }
    }
    private Double verifyType(MovementEnum movementEnum, Double value) {
        if (movementEnum == MovementEnum.EXPENSE){
            return value * -1;
        }
        return value;
    }

}
