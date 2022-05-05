package com.dio.santander.bankline.api.data;

import com.dio.santander.bankline.api.model.Account;
import com.dio.santander.bankline.api.model.AccountHolder;
import com.dio.santander.bankline.api.repository.AccountHolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DatabaseLoader implements ApplicationRunner {
    private final AccountHolderRepository accountHolderRepository;

    private List<AccountHolder> listHolders = new ArrayList<>();

    @Autowired
    public DatabaseLoader(AccountHolderRepository accountHolderRepository) {
        this.accountHolderRepository = accountHolderRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        listHolders.addAll(Arrays.asList(
                new AccountHolder("12345678910", "Oliver",new Account(Long.parseLong("1"),Double.parseDouble("10.50"))),
                new AccountHolder("22345678910", "Aurora",new Account(Long.parseLong("2"),Double.parseDouble("20.40")))

        ));
        accountHolderRepository.saveAll(listHolders);

    }


}



