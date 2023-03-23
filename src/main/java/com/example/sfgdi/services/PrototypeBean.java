package com.example.sfgdi.services;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//This takes the bean scope from a Singleton to a Prototype meaning every time this class is needed there
//will be a different instance created every time
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
public class PrototypeBean {


    public PrototypeBean() {
        System.out.println("Creating a Prototype Bean!!!!!!!!!!!!!!!!!!!!!!!!!");
    }

    public String getMyScope() {
        return "I'm a Prototype";
    }
}
