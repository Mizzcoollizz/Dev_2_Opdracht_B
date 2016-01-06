/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseClasses;

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
     * Test of getCarPositionDataPK method, of class CarPositionData.
     */
    @Test
    public void testGetCarPositionDataPK() {
        System.out.println("getCarPositionDataPK");
        CarPositionDataPK instancePK = new CarPositionDataPK("1248", null , "gps");
        CarPositionData instance = new CarPositionData(instancePK);
        CarPositionDataPK expResult = instancePK;
        CarPositionDataPK result = instance.getCarPositionDataPK();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCarPositionDataPK method, of class CarPositionData.
     */
    @Test
    public void testSetAndGetCarPositionDataPK() {
        System.out.println("testSetAndGetCarPositionDataPK");
        CarPositionDataPK carPositionDataPK = new CarPositionDataPK("1248", null , "gps");
        CarPositionData instance = new CarPositionData();
        instance.setCarPositionDataPK(carPositionDataPK);
        assertEquals(instance.getCarPositionDataPK(), carPositionDataPK);
    }

    /**
     * Test of setLatitude method, of class CarPositionData.
     */
    @Test
    public void testSetAndGetLatitude() {
        System.out.println("testSetAndGetLatitude");
        double latitude = 1.268;
        CarPositionData instance = new CarPositionData();
        instance.setLatitude(latitude);
        assertTrue("Latitudes are the same.", instance.getLatitude() == latitude );
    }

    /**
     * Test of setLongitude method, of class CarPositionData.
     */
    @Test
    public void testSetAndGetLongitude() {
        System.out.println("testSetAndGetLongitude");
        double longitude = 8.148;
        CarPositionData instance = new CarPositionData();
        instance.setLongitude(longitude);
        assertTrue("Longitudes are the same.", instance.getLongitude() == longitude );
    }

    /**
     * Test of setSpeed method, of class CarPositionData.
     */
    @Test
    public void testSetAndGetSpeed() {
        System.out.println("testSetAndGetSpeed");
        Integer speed = new Integer(12);
        CarPositionData instance = new CarPositionData();
        instance.setSpeed(speed);
        assertEquals(instance.getSpeed(), speed);
    }

    /**
     * Test of setCourse method, of class CarPositionData.
     */
    @Test
    public void testSetAndSetCourse() {
        System.out.println("testSetAndSetCourse");
        Integer course = new Integer(145);
        CarPositionData instance = new CarPositionData();
        instance.setCourse(course);
        assertEquals(instance.getCourse(), course);
    }


    /**
     * Test of setHdop method, of class CarPositionData.
     */
    @Test
    public void testGetAndSetHdop() {
        System.out.println("setHdop");
        Integer hdop = new Integer(14);
        CarPositionData instance = new CarPositionData();
        instance.setHdop(hdop);
        assertEquals(instance.getHdop(), hdop);
        
    }

    /**
     * Test of getCar method, of class CarPositionData.
     */
    @Test
    public void testSetAndGetCar() {
        System.out.println("getCar");
        CarPositionData instance = new CarPositionData();
        Car car = new Car("12485");
        instance.setCar(car);
        Car expResult = car;
        Car result = instance.getCar();
        assertEquals(expResult, result);
    }


    /**
     * Test of equals method, of class CarPositionData.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = new CarPositionData();
        CarPositionData instance = new CarPositionData();
        boolean expResult = true;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
    }

    /**
     * Test of getPK method, of class CarPositionData.
     */
    @Test
    public void testGetPK() {
        System.out.println("getPK");
        CarPositionDataPK instancePK = new CarPositionDataPK("124785", null , "cs");
        CarPositionData instance = new CarPositionData(instancePK);
        Object expResult = instancePK;
        Object result = instance.getPK();
        assertEquals(expResult, result);
    }

    /**
     * Test of mergeWithObjectFromDatabase method, of class CarPositionData.
     */
    @Test
    public void testMergeWithObjectFromDatabase() {
        System.out.println("mergeWithObjectFromDatabase");
        CarPositionDataPK pk = new CarPositionDataPK("14526", null, "mixed");
        EntityClass ec = new CarPositionData(pk);
        CarPositionData instance = new CarPositionData();
        EntityClass expResult = new CarPositionData(pk);
        EntityClass result = instance.mergeWithObjectFromDatabase(ec);
        assertEquals(expResult, result);
    }
    
}
