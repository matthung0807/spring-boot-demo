package com.abc.demo.controller.request;

import com.abc.demo.controller.validation.annotation.Password;

import java.io.Serializable;

public class RegisterRequest implements Serializable {

    private String account;
//    @Password
    private String password;

    public RegisterRequest(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
