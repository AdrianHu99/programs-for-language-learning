package com.qih.moviecatalogservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Value("${my.greetings}")
    private String greeting;

    @GetMapping("/greetings")
    public String getGreetings() {
        return greeting;
    }
}
