package com.example.helloworldrevservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloworldRevServiceController {
	
	@Autowired
	ServiceInvoker invoker;

    @RequestMapping(value = "/reversedMessage", method = RequestMethod.GET)
    public JsonMessage reverse() 
    {
        System.out.println("Inside reverse service");
        JsonMessage message = invoker.getMessage();
        message.setMessage(new StringBuffer(message.getMessage()).reverse().toString());
        return message;
    }
}
