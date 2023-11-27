package com.example.redeamerica.dto;


import jakarta.validation.constraints.NotBlank;

// UserProfileUpdateDTO.java
public class UserProfileUpdateDTO {
    private String fullName;
    private String address;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



}

