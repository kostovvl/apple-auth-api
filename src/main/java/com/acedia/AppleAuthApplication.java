package com.acedia;

import com.accedia.apple.auth.AppleAuthProvider;
import com.accedia.apple.auth.AppleUserScope;
import com.accedia.apple.auth.SecretGenerator;
import com.accedia.apple.auth.key.AppleClientPrivateKeyFactory;
import com.accedia.apple.auth.user.AppleAuthorizationToken;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

@SpringBootApplication
public class AppleAuthApplication {



	public static void main(String[] args) throws IOException, InvalidKeySpecException {
		SpringApplication.run(AppleAuthApplication.class, args);
	}
}
