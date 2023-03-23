package com.example.sfgdi.config;

import com.example.sfgdi.datasource.FakeDataSource;
import com.example.sfgdi.repositories.EnglishGreetingRepository;
import com.example.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import com.example.sfgdi.services.*;
import com.springframework.pets.PetService;
import com.springframework.pets.PetServiceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@PropertySource("classpath:datasource.properties")
@ImportResource("classpath:sfgdi-config.xml") //we can define in any config component what xml file to find beans in
@Configuration
public class GreetingServiceConfig {

    //@Value work with the class annotation @PropertySource to grab the values in the specified properties file
    //When grabbing values from the @Value annotation be sure to put name in curly braces with the dollar sign ($)
    // out of curly braces all in a string. Ex) @Value("${guru.username}") . Doing it like this @Value("$guru.username")
    //with output that literal string instead of the values in the properties file.
    @Bean
    FakeDataSource fakeDataSource(@Value("${guru.username}")String username,
                                  @Value("${guru.password}") String password,
                                  @Value("${guru.jdbcurl}") String jdbcUrl){

        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUserName(username);
        fakeDataSource.setPassword(password);
        fakeDataSource.setJdbcUrl(jdbcUrl);
        return fakeDataSource;
    }

    @Bean
    PetServiceFactory petServiceFactory() {
        return new PetServiceFactory();
    }

    //Spring is smart enough to create this bean first before it uses it injects it inside of following
    //method i18nService
    @Bean
    EnglishGreetingRepository englishGreetingRepository() {
        return new EnglishGreetingRepositoryImpl();
    }

    @Profile({"dog", "default"})
    @Bean
    PetService dogPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("dog");
    }

    @Profile("cat")
    @Bean
    PetService catPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("cat");
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
//    @Bean  //comment annotation and method out since we are defining this one in sfgdi-config.xml
//    ConstructorGreetingService constructorGreetingService() {
//        return new ConstructorGreetingService();
//    }

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService() {
        return new PropertyInjectedGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService() {
        return new SetterInjectedGreetingService();
    }

    @Bean
    @Primary
    PrimaryGreetingService primaryGreetingService() { return new PrimaryGreetingService(); }
}
