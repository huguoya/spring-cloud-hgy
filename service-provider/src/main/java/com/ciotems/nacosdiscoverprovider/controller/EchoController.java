package com.ciotems.nacosdiscoverprovider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class EchoController {
    @GetMapping("/echo/{string}")
    public String echo(@org.springframework.web.bind.annotation.PathVariable String string) {
        return "Hello Nacos Discovery " + string + ";" + LocalDateTime.now();
    }
}
