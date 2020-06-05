package com.qih.moviecatalogservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GreetingController {

    @Value("${my.greetings:default value}")
    private String greeting;

    @Value("${my.list.value}")
    private List<String> list;

    @Value("#{${my.db.map}}")
    private Map<String, String> map;


    @GetMapping("/greetings")
    public String getGreetings() {
        return greeting + list + map;
    }


}
