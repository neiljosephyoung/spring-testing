package com.njy.cli_tools;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import com.njy.cli_tools.pojo.dto.UserDTO;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CliToolsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CliToolsApplication.class, args);
	}

}
