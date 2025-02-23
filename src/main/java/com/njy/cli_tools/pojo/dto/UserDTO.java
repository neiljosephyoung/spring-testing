package com.njy.cli_tools.pojo.dto;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import com.njy.cli_tools.annotations.ValidPhoneNumber;
import jakarta.validation.constraints.NotNull;


public record UserDTO(@NotNull
                      @ValidPhoneNumber
                      String phoneNumber) {
    public UserDTO(String phoneNumber){
        this.phoneNumber = formatE164(phoneNumber);
    }

    private static String formatE164(String phoneNumber) {
        try {
            PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
            Phonenumber.PhoneNumber parsedNumber = phoneNumberUtil.parse(phoneNumber, "IE"); // Default to Ireland
            return phoneNumberUtil.format(parsedNumber, PhoneNumberUtil.PhoneNumberFormat.E164);
        } catch (NumberParseException e) {
            throw new IllegalArgumentException("Invalid phone number format: " + phoneNumber, e);
        }
    }

}
