package com.njy.cli_tools.annotations;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, String> {

    private static final List<String> ALLOWED_REGIONS = Arrays.asList("GB", "IE");
    private final PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();

    @Override
    public void initialize(ValidPhoneNumber constraintAnnotation) {
    }

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
        if (phoneNumber == null || phoneNumber.isEmpty() ) {
            return false;
        }

        try {
            phoneNumber = PhoneNumberUtil.normalizeDigitsOnly(phoneNumber);
            Phonenumber.PhoneNumber parsedNumber = phoneNumberUtil.parse(phoneNumber, "IE");
            String regionCode = phoneNumberUtil.getRegionCodeForNumber(parsedNumber);
            System.out.println(parsedNumber);
            return phoneNumberUtil.isValidNumber(parsedNumber) && ALLOWED_REGIONS.contains(regionCode);
        } catch (NumberParseException e) {
            return false;
        }
    }
}
