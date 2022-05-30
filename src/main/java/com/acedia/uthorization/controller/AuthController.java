package com.acedia.uthorization.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/validate-token")
public class AuthController {

    @PostMapping
    public String test(@RequestHeader String code) {
        return code;
    }
}
