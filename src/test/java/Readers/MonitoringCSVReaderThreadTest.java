/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Readers;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Elize
 */
public class MonitoringCSVReaderThreadTest {
    
    private static final String path = "C:\\Users\\School\\Documents\\HBO\\2\\Project 1\\Code\\Monitoring.csv"; 
    public MonitoringCSVReaderThreadTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testReading() throws InterruptedException{
        //First check if reading is false, when no thread is running.
        assertFalse(CSVFileReader.reading);
        //Then read a new file
        MonitoringCSVReaderThread reader = new MonitoringCSVReaderThread(path);
        reader.start();
        Thread.sleep(500);
        assertTrue(CSVFileReader.reading);
    }

    @Test
    public void testReadTime() throws InterruptedException{
     long starttime = System.nanoTime();
     MonitoringCSVReaderThread reader = new MonitoringCSVReaderThread(path);
     reader.readAndInsertMonitoringCSV();
     double secondsPassed = (System.nanoTime() - starttime) / 1000000000.0;
     assertTrue(secondsPassed < 15);
    }
    
}
