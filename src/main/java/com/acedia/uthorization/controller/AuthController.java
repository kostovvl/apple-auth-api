package com.acedia.uthorization.controller;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/validate-token")
public class AuthController {

    @PostMapping
    public MultiValueMap<String, Object> test(@RequestBody MultiValueMap<String, Object> data) {
        return data;
    }
}
