package com.freightflow.tracking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeathController {

    @GetMapping("/health")
    public String healthCheck(){
        return "tracking all ok";
    }
}
