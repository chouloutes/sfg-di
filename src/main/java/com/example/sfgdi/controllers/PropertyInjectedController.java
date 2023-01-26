package com.example.sfgdi.controllers;

import com.example.sfgdi.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PropertyInjectedController {
    @Autowired
    public GreetingService greetingService; // Use @Autowired so that spring knows this is a variable that need to be injected


    public String getGreeting(){
        return greetingService.sayGreeting(); //this return null if the GreetingServiceImpl class doesn't have a spring annotation on it such as @Service
    }
}
