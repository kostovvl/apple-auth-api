package com.acedia.uthorization.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/validate-token")
public class AuthController {

    @GetMapping
    public String test(@RequestHeader String code) {
        return code;
    }
}
