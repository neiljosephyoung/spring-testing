package com.njy.cli_tools;

import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CliToolsApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testPhoneNoValid(){
		String phoneNumber = "+353872345678";
		PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
		try {
			Phonenumber.PhoneNumber parsedNumber = phoneNumberUtil.parse(phoneNumber, "IE");
			boolean isValid = phoneNumberUtil.isValidNumber(parsedNumber);
			System.out.println("Is valid number: " + isValid);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
