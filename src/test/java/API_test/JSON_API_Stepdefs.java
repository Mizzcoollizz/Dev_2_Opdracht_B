/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API_test;

import Cucumber.Hello;
import DatabaseClasses.Database_Manager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.Before;
import org.json.JSONObject;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author Elize
 */
public class JSON_API_Stepdefs {
    
    JSONObject jsonMessage = null;
    JSONObject returnMessage = null;
    
    public void after(){
        Database_Manager.closeConnection();
    }
    
    @Given("I have an jsonObject with type \"([^\"]*)\" and reportType \"([^\"]*)\" and unitId \"([^\"]*)\"$")
    public void I_have_an_jsonObject_with(String type, String reportType, String unitId){
            jsonMessage = new JSONObject();
            jsonMessage.put("type", type);
            jsonMessage.put("reportType", reportType);
            jsonMessage.put("unitId", unitId);
    }
          
    @When("I ask the server to get the report$")
    public void I_ask_the_server_to_get_the_report(){
        returnMessage = 
                Database_Manager.getJSONReportFromDatabase(
                        jsonMessage.getString("reportType"), 
                        jsonMessage.getString("unitId"));
    }
    
    @Then("it should anwer with a jsonObject with type \"([^\"]*)\" and reportType \"([^\"]*)\" and an \"([^\"]*)\" attribute$")
    public void it_should_anwer_with_a_jsonObject_with_type(String type, String reportType, String attribute){
        assertEquals(returnMessage.getString("type"), type);
        assertEquals(returnMessage.getString("reportType"), reportType);
        assertTrue(returnMessage.has(attribute));
        
    }

    
}
