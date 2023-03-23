package com.example.sfgdi.config;

import com.example.sfgdi.repositories.EnglishGreetingRepository;
import com.example.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import com.example.sfgdi.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class GreetingServiceConfig {

    @Bean
    @Primary
    PrimaryGreetingService primaryGreetingService() { return new PrimaryGreetingService(); }


    //Spring is smart enough to create this bean first before it uses it injects it inside of following
    //method i18nService
    @Bean
    EnglishGreetingRepository englishGreetingRepository() {
        return new EnglishGreetingRepositoryImpl();
    }

    @Bean
    @Profile("EN")
    I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository) { return new I18nEnglishGreetingService(englishGreetingRepository); }

    @Bean("i18nService")
    @Profile("ES")
    I18nSpanishGreetingService i18NSpanishService() { return new I18nSpanishGreetingService(); }

    //The spring context will take the name of the method not the clas so be sure to
    //make the method name the same as the class if you are going to define your spring
    //beans in the config class.
    //One reason to define beans(classes) in a config like this class rather than annotating the bean
    //itself with @service or something similar that indicates that a class is a bean, is that spring uses reflection
    //when starting up the application and scanning for beans in the project which can slow the start-up of the application way
    //down which can be a problem for bigger more enterprise level applications. So defining your bean in a config class can speed
    //things up
    //If your method name doesn't start with a lowercase letter and is not names the same as the class you
    //are trying to instantiate then spring won't pick it up and this may stop your program from compiling
    @Bean
    ConstructorGreetingService constructorGreetingService() {
        return new ConstructorGreetingService();
    }

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService() {
        return new PropertyInjectedGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService() {
        return new SetterInjectedGreetingService();
    }
}
