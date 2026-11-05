package com.devconnect.controller;
import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class HealthController {

    @GetMapping("/health")
    public String health() {
        return "Application is running";
    }
    // spring boot uses jackson to convert the map to json and return it as a response and vice versa
    @GetMapping ("/api/v1/status")
public Map<String,Object> status() {
    Map<String,Object> map = new HashMap<>();
    map.put("Service", "DevConnect");
    map.put("Status", "Running");
    map.put("version", "1.0.0");
    map.put("Timestamp", new Date());
    return map;
}

}
        

