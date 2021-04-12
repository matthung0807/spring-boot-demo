package com.abc.demo.controller.request;

import com.abc.demo.controller.validation.annotation.Password;
import lombok.Data;

import java.io.Serializable;

@Data
public class RegisterRequest implements Serializable {

    private String account;
    @Password
    private String password;

    public RegisterRequest(String account, String password) {
        this.account = account;
        this.password = password;
    }

}
