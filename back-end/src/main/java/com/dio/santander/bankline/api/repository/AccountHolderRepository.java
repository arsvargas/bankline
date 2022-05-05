package com.dio.santander.bankline.api.repository;

import com.dio.santander.bankline.api.model.AccountHolder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountHolderRepository extends JpaRepository<AccountHolder, Integer> {
}
