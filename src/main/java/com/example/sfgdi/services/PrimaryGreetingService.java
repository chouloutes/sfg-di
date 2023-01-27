package com.example.sfgdi.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

//This annotation is simply used to indicate to Spring that if we have more
// than one implementation of an interface when injecting a bean default to
// this class if a bean is not specified
//@Qualifier annotation specified at injection point will take precedence over @Primary annotation here
@Primary
@Service
public class PrimaryGreetingService implements GreetingService{

    @Override
    public String sayGreeting() {
        return "Hello World - From the Primary bean";
    }
}
