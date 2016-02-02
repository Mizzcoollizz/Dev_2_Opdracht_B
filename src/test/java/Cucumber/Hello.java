/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cucumber;

/**
 *
 * @author School
 */
public class Hello {
 
    private final String greeting;
    
    public Hello(String greeting) {
    this.greeting = greeting;
    }
        
    public String sayHi() {
    return greeting + " World";
    }
}

