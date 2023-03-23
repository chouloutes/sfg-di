package com.example.sfgdi.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

//Switch to this in application.properties then run application
//@Profile({"ES", "default" })
//@Service("i18nService") //annotations are commented out since we are moving implementation to the config class
public class I18nSpanishGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hola Mundo - ES";
    }
}
