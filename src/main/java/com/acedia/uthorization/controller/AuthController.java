package com.acedia.uthorization.controller;

import com.acedia.uthorization.auth.user.AppleAuthorizationToken;
import com.acedia.uthorization.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;

@Controller
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/validate-token")
    public AppleAuthorizationToken validateToken(@RequestBody MultiValueMap<String, String> values) throws IOException {
        return authService.test(String.valueOf(values.get("code")));
    }
}
