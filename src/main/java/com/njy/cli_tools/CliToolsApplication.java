package com.njy.cli_tools;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import com.njy.cli_tools.pojo.dto.UserDTO;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class CliToolsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CliToolsApplication.class, args);

//		List<String> strings = new ArrayList<>(List.of("test","test1","test2"));
//		int x = 0;
//
//		OUTER:for (int i = 0; i < 10; i++) {
//			System.out.println("i: " + i);
//
//			INNER: for (String string : strings) {
//				if ("test1".equals(string)) {
//					break INNER;
//				} else if ("test2".equals(string)) {
//					break OUTER;
//				}
//			}
//		}

	}

}
