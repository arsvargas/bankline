package com.dio.santander.bankline.api.service;


import com.dio.santander.bankline.api.model.Account;
import com.dio.santander.bankline.api.model.AccountHolder;
import com.dio.santander.bankline.api.repository.AccountHolderRepository;
import com.dio.santander.bankline.api.vo.NewAccountHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AccountHolderService {

    private final AccountHolderRepository accountHolderRepository;

    @Autowired
    public AccountHolderService(AccountHolderRepository accountHolderRepository) {
        this.accountHolderRepository = accountHolderRepository;
    }

    public NewAccountHolder save(NewAccountHolder newAccountHolder) {
        AccountHolder accountHolder = new AccountHolder();
        accountHolder.setCpf(newAccountHolder.getCpf());
        accountHolder.setName(newAccountHolder.getName());

        Account account = new Account();
        account.setBalance(0.0);
        account.setNumber(new Date().getTime());

        accountHolder.setAccount(account);


        accountHolderRepository.save(accountHolder);

        return newAccountHolder;
    }
}
