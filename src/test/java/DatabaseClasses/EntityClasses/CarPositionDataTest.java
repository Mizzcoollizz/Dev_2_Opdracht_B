/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseClasses.EntityClasses;

import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author School
 */
public class CarPositionDataTest {
    
    public CarPositionDataTest() {
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

    /**
     * Test of getLatitude method, of class CarPositionData.
     */
    @Test
    public void testGetLatitude() {
        System.out.println("getLatitude");
        CarPositionData instance = new CarPositionData();
        double expResult = 0.0;
        double result = instance.getLatitude();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setLatitude method, of class CarPositionData.
     */
    @Test
    public void testSetLatitude() {
        System.out.println("setLatitude");
        double latitude = 5.2450;
        CarPositionData instance = new CarPositionData();
        instance.setLatitude(latitude);
        assertTrue(latitude == instance.getLatitude());
    }

    /**
     * Test of getLongitude method, of class CarPositionData.
     */
    @Test
    public void testGetLongitude() {
        System.out.println("getLongitude");
        CarPositionData instance = new CarPositionData();
        double expResult = 0.0;
        double result = instance.getLongitude();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setLongitude method, of class CarPositionData.
     */
    @Test
    public void testSetLongitude() {
        System.out.println("setLongitude");
        double longitude = 5.0112;
        CarPositionData instance = new CarPositionData();
        instance.setLongitude(longitude);
        assertTrue(longitude == instance.getLongitude());
    }

    /**
     * Test of getSpeed method, of class CarPositionData.
     */
    @Test
    public void testGetSpeed() {
        System.out.println("getSpeed");
        CarPositionData instance = new CarPositionData();
        Integer expResult = null;
        Integer result = instance.getSpeed();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSpeed method, of class CarPositionData.
     */
    @Test
    public void testSetSpeed() {
        System.out.println("setSpeed");
        Integer speed = new Integer(5);
        CarPositionData instance = new CarPositionData();
        instance.setSpeed(speed);
        assertEquals(speed, instance.getSpeed());
    }

    /**
     * Test of getCourse method, of class CarPositionData.
     */
    @Test
    public void testGetCourse() {
        System.out.println("getCourse");
        CarPositionData instance = new CarPositionData();
        Integer expResult = null;
        Integer result = instance.getCourse();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCourse method, of class CarPositionData.
     */
    @Test
    public void testSetCourse() {
        System.out.println("setCourse");
        Integer course = new Integer(240);
        CarPositionData instance = new CarPositionData();
        instance.setCourse(course);
        assertTrue(course == instance.getCourse());
    }

    /**
     * Test of getHdop method, of class CarPositionData.
     */
    @Test
    public void testGetHdop() {
        System.out.println("getHdop");
        CarPositionData instance = new CarPositionData();
        Integer expResult = null;
        Integer result = instance.getHdop();
        assertEquals(expResult, result);
    }

    /**
     * Test of setHdop method, of class CarPositionData.
     */
    @Test
    public void testSetHdop() {
        System.out.println("setHdop");
        Integer hdop = new Integer(0);
        CarPositionData instance = new CarPositionData();
        instance.setHdop(hdop);
        assertTrue(hdop == instance.getHdop());
    }   

    /**
     * Test of getCar method, of class CarPositionData.
     */
    @Test
    public void testGetCar() {
        System.out.println("getCar");
        CarPositionData instance = new CarPositionData();
        Car expResult = null;
        Car result = instance.getCar();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCar method, of class CarPositionData.
     */
    @Test
    public void testSetCar() {
        System.out.println("setCar");
        Car car = new Car("145267");
        CarPositionData instance = new CarPositionData();
        instance.setCar(car);
        assertEquals(car, instance.getCar());
    }

    /**
     * Test of equals method, of class CarPositionData.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        
        CarPositionData instance1 = new CarPositionData("14278", null, "gps");
        CarPositionData instance2 = new CarPositionData("174878", null, "car_system");
         
        boolean expResult = false;
        boolean result = instance1.equals(instance2);
        assertEquals(expResult, result);
    }

    /**
     * Test of mergeWithObjectFromDatabase method, of class CarPositionData.
     */
    @Test
    public void testMergeWithObjectFromDatabase() {
        System.out.println("mergeWithObjectFromDatabase");
        EntityClass ec = new CarPositionData("78548", null, "car_system");
        
        CarPositionData instance = new CarPositionData("78548", null, "car_system");
            instance.setHdop(new Integer(5));
        CarPositionData expResult = new CarPositionData("78548", null, "car_system");
            expResult.setHdop(new Integer(5));
        EntityClass result = instance.mergeWithObjectFromDatabase(ec);
        assertEquals(expResult, result);
    }

   
    
}
