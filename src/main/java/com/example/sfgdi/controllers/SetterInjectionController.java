package com.example.sfgdi.controllers;

import com.example.sfgdi.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SetterInjectionController {

    private GreetingService greetingService;

    @Autowired //add this on the setter to allow setter injection from spring
    public void  setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String getGreeting() {
        return greetingService.sayGreeting();
    }
}
