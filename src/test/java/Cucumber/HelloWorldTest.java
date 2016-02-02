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
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
// Associates Cucumber-JVM with the JUnit runner
@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\School\\Documents\\HBO\\2\\Project 1\\Code\\Github\\DataVerwerkingsSysteem_Dev_B\\src\\test\\java\\Cucumber\\hello_world.feature")
public class HelloWorldTest {
    
}
