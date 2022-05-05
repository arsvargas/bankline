package com.dio.santander.bankline.api.model;

import javax.persistence.*;

@Entity
public class AccountHolder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 20)
    private String cpf;

    @Column(length = 60)
    private String name;

    @Embedded
    private Account account;

    public AccountHolder(String cpf, String name, Account account) {
        this.cpf = cpf;
        this.name = name;
        this.account = account;
    }

    public AccountHolder() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
