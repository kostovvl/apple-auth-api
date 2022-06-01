package com.acedia.uthorization.service;

import com.accedia.apple.auth.AppleAuthProvider;
import com.accedia.apple.auth.AppleUserScope;
import com.accedia.apple.auth.SecretGenerator;
import com.accedia.apple.auth.key.AppleClientPrivateKeyFactory;
import com.accedia.apple.auth.user.AppleAuthorizationToken;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

@Service
public class AuthService {
    private final static String CLIENT_ID = "com.appleauth.java";
    private static final String KEY_ID = "28843H4K83";
    private static final String TEAM_ID = "8TEBZUZ6U9";
    private static final String REDIRECT_URL = "https://apple-auth-api.herokuapp.com/validate-token";
    private static final String PK = "MIGTAgEAMBMGByqGSM49AgEGCCqGSM49AwEHBHkwdwIBAQQggS4/z4p1sPe0xCGj\n" +
                                     "5pVDVDmdKATpyBmH1qyfvZJ70nKgCgYIKoZIzj0DAQehRANCAASLIX+vWbGnV2kr\n" +
                                     "M73RMN2sSBBp5/MgNw/YI3NymAQOV7fKRgF2xRf47OMMwKpb/7cXDAaU5Qe/6yoJ\n" +
                                     "N/hDrZa3";
    AppleClientPrivateKeyFactory appleClientPrivateKeyFactory = new AppleClientPrivateKeyFactory();
    ECPrivateKey privateKey = appleClientPrivateKeyFactory.getEcPrivateKey(PK);
    SecretGenerator secretGenerator = new SecretGenerator();
    AppleAuthProvider appleAuthProvider = new AppleAuthProvider(
            CLIENT_ID,
            KEY_ID,
            TEAM_ID,
            secretGenerator,
            privateKey,
            Arrays.asList(AppleUserScope.EMAIL, AppleUserScope.NAME),
            REDIRECT_URL
    );
    String loginLink = appleAuthProvider.getLoginLink("Some form of state");

    public AuthService() throws IOException, InvalidKeySpecException {
    }

    public AppleAuthorizationToken test(String code) throws IOException {
        String authCode = "the code in the callback request";
        AppleAuthorizationToken initialToken = appleAuthProvider.makeNewAuthorisationTokenRequest(authCode);
        return appleAuthProvider.makeNewRefreshTokenRequest(initialToken.getRefreshToken());
    }

}
