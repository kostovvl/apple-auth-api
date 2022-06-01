package com.acedia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;
import java.security.spec.InvalidKeySpecException;

@SpringBootApplication
public class AppleAuthApplication {

	public static void main(String[] args) throws IOException, InvalidKeySpecException {
		SpringApplication.run(AppleAuthApplication.class, args);
	}
}
