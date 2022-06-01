package com.acedia.uthorization.controller;

import com.accedia.apple.auth.user.AppleAuthorizationToken;
import com.acedia.uthorization.service.AuthService;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/validate-token")
    public AppleAuthorizationToken test(@RequestBody MultiValueMap<String, String> values) throws IOException {
        return authService.test(String.valueOf(values.get("code")));
    }
}
