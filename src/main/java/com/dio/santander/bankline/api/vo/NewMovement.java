package com.dio.santander.bankline.api.vo;

import com.dio.santander.bankline.api.constant.MovementEnum;

public class NewMovement {
    private String description;
    private Double value;
    private Integer idAccount;
    private MovementEnum type;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Integer getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Integer idAccount) {
        this.idAccount = idAccount;
    }

    public MovementEnum getType() {
        return type;
    }

    public void setType(MovementEnum type) {
        this.type = type;
    }
}
