/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataverwerkingssysteem;

import DatabaseClasses.Database_Manager;
import Server_Manager.WebServerCommunicationManager;
import UI.User_Interface;
import java.text.ParseException;

/**
 *
 * @author Elize
 */
public class DataVerwerkingsSysteem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        
        User_Interface ui = new User_Interface();
        Database_Manager dbManager = new Database_Manager(ui); 
        WebServerCommunicationManager wsc = new WebServerCommunicationManager();
    }
    
     
}
