package com.example.helloworldservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloworldServiceController {

    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public JsonMessage getMessage() 
    {
        System.out.println("Inside Hello world service");
        return new JsonMessage("1", "Hello world");
    }
}
