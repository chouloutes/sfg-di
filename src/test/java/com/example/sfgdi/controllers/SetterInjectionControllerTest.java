package com.example.sfgdi.controllers;

import com.example.sfgdi.services.ConstructorGreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SetterInjectionControllerTest {

    SetterInjectionController controller;
    @BeforeEach
    void setUp() {
        controller = new SetterInjectionController();
        controller.setGreetingService(new ConstructorGreetingService());
    }

    @Test
    void getGreeting() {
        System.out.println(controller.getGreeting());
    }
}