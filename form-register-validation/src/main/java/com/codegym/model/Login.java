package com.codegym.model;

import javax.validation.constraints.*;

public class Login {
    @NotEmpty
    @Size(min = 5, max =45)
    private String userName;

    @Email
    private String email;

    @Size(min = 5, max =45)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]+$")
    private String password;

    @NotEmpty
    @Pattern(regexp = "\\d{10,11}")
    private String phoneNumber;

    public Login() {
    }

    public Login(String userName, String password, String email, String phoneNumber) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
