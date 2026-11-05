package com.devconnect.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {
    @PostMapping("/api/v1/developer")
    public String createDeveloper(){
        return "Developer profile created successfully";
    }
    
}
