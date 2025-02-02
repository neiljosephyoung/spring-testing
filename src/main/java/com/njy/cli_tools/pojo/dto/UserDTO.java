package com.njy.cli_tools.pojo.dto;

import com.njy.cli_tools.annotations.ValidPhoneNumber;
import jakarta.validation.constraints.NotNull;


public class UserDTO {

    @NotNull
    @ValidPhoneNumber
    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
