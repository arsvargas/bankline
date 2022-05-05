package com.dio.santander.bankline.api.controller;

import com.dio.santander.bankline.api.model.AccountHolder;
import com.dio.santander.bankline.api.repository.AccountHolderRepository;
import com.dio.santander.bankline.api.service.AccountHolderService;
import com.dio.santander.bankline.api.vo.NewAccountHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/account-holders")
public class AccountHolderController {


    private final AccountHolderRepository accountHolderRepository;

    private final AccountHolderService accountHolderService;

    @Autowired
    public AccountHolderController(AccountHolderRepository accountHolderRepository, AccountHolderService accountHolderService) {
        this.accountHolderRepository = accountHolderRepository;
        this.accountHolderService = accountHolderService;
    }

    @GetMapping
    public List<AccountHolder> findAll(){
        return accountHolderRepository.findAll();

    }

    @PostMapping
    public ResponseEntity<NewAccountHolder> save(@RequestBody NewAccountHolder newAccountHolder) {

        return ResponseEntity.ok(accountHolderService.save(newAccountHolder));
    }
}
