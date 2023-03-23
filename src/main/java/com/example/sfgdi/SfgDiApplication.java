package com.example.sfgdi;

import com.example.sfgdi.controllers.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//Spring bean components that live outside of package com.example.sfgdi (where main
// class that runs spring boot lives) won't get picked up unless we explicitly define
// the packages to look at to scann for all of our components
@ComponentScan(basePackages = {"com.example.sfgdi", "com.springframework.pets"})
@SpringBootApplication
public class SfgDiApplication {

	//Notes
	//Dependency injection is dependency injection is a design pattern in
	// which an object or function receives other objects or functions that it depends on.
	// A form of inversion of control, dependency injection aims to separate the concerns of
	// constructing objects and using them, leading to loosely coupled programs.
	//
	// Dependency injection is where a needed dependency is injected by another object / or program. It can
	// be injected via the constructor or after via the setter. The Class being injected into has no responsibility
	// in instantiating the object being injected that it depends on.
	//
	// Note: Since we have dependency injection in Spring, that doesn't mean that we will never instantiate an object
	// ourselves ever again. There may be special cases where you don't want Spring to manage your beans in the Spring Context.
	// So be pragmatic in what is and is not being managed in the Spring Context.
	//
	//
	//Dependency Injection is a way to provide a need while guarding against doing anything else but
	//what you need. It is like a kid who wants something from the fridge and if he gets it himself
	//he may make a mess or leave the door open. The better way for the kid to get what he wants is from
	// mommy or daddy who know how to get what he wants in a cleaner way.
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		PetController petController = ctx.getBean("petController", PetController.class);
		System.out.println("--- The Best Pet is ---");
		System.out.println(petController.whichPetIsTheBest());

		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		System.out.println(i18nController.sayHello());

		//Spring provides new instantiated object
		//This is how dependency injection happens
		MyController myController = (MyController) ctx.getBean("myController");


		System.out.println("----------- Primary Bean");
		System.out.println(myController.sayHello());

		System.out.println("----------- Property");

		//In order for spring to inject the bean needed that class has to be annotated with a spring annotation indicating
		//that it should manage that class and inject it where ever needed
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());


		System.out.println("-----------Setter");
		SetterInjectionController setterInjectionController = (SetterInjectionController) ctx.getBean("setterInjectionController");

		System.out.println(setterInjectionController.getGreeting());

		System.out.println("-----------Constructor");
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");

		System.out.println(constructorInjectedController.getGreeting());
	}

}
