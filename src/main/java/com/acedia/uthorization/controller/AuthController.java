package com.acedia.uthorization.controller;

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
    public String validateToken(@RequestBody MultiValueMap<String, String> values) throws IOException {
        String code = String.valueOf(values.get("code"));
//        System.out.println(code);
//        return authService.test(code).toString();

        return code;
    }
}
