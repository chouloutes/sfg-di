package com.example.sfgdi.controllers;

import org.springframework.stereotype.Controller;

/**
 * There are 3 different was to do Dependency Injection
 * 1.) By class properties (note do not make properties private)
 * 2.) By Setters
 * 3.) By constructor
 *
 * Dependency Injection(DI) can be done with concrete class or interfaces
 * -GenerallY DI with concrete classes should be avoided and use interfaces instead
 *  due to the ability to decide at runtime which implementation to use, it follows the
 *  Interface Segregation Principle of SOLID, and it also makes your code more testable (mocking becomes trivial)
 *
 *
 *  Inversion of Control
 *  This is a technique to allow dependencies to be injected at runtime. Dependencies are not predetermined.
 *  This technique allows the framework to compose the application by controlling which implementation is injected
 *      ex.) H2 in memory db source or MySql db source
 *
 *
 * Inversion of Control (IoC) and Dependency Injection(DI) can get confused with each other
 * DI is when you write code(a Class) to expect its dependencies to be injected from somewhere other than itself
 * IoC is when we actually switch responsibility for Dependency Injection from ourselves to a framework in this case
 * the Spring framework. Spring would be in control of the injection of dependencies
 *
 * Best Practices
 * - Favor constructor injection over setter injection
 * - Use final properties for injected components
 *      - Declare properties private final and initialize in the constructor
 * - Whenever practical, code to an interface
 *
 */
@Controller
public class MyController {

    public String sayHello () {
        System.out.println("Hello World");

        return "Hi Folks";
    }
}
