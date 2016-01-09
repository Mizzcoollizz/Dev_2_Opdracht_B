/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseClasses;

import DatabaseClasses.EntityClasses.Car;
import DatabaseClasses.EntityClasses.CarStatusEvent;
import DatabaseClasses.EntityClasses.EntityClass;
import DatabaseClasses.EntityClasses.HsdpaConnection;
import DatabaseClasses.EntityClasses.OverallConnection;
import java.util.Collection;
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
public class CarTest {
    
    public CarTest() {
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
     * Test of getUnitId method, of class Car.
     */
    @Test
    public void testGetUnitId() {
        System.out.println("getUnitId");
        Car instance = new Car("125678");
        String expResult = "125678";
        String result = instance.getUnitId();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setUnitId method, of class Car.
     */
    @Test
    public void testSetUnitId() {
        System.out.println("setUnitId");
        String unitId = "78954";
        Car instance = new Car("89647");
        instance.setUnitId(unitId);
        assertEquals(unitId, instance.getUnitId());
    }

    /**
     * Test of getCarStatusEventCollection method, of class Car.
     */
    @Test
    public void testGetCarStatusEventCollection() {
        System.out.println("getCarStatusEventCollection");
        Car instance = new Car("17458");
        Collection<CarStatusEvent> expResult = null;
        Collection<CarStatusEvent> result = instance.getCarStatusEventCollection();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setCarStatusEventCollection method, of class Car.
     */
    @Test
    public void testSetCarStatusEventCollection() {
        System.out.println("setCarStatusEventCollection");
        Collection<CarStatusEvent> carStatusEventCollection = null;
        Car instance = new Car("78954563");
        instance.setCarStatusEventCollection(carStatusEventCollection);
        assertEquals(carStatusEventCollection, instance.getCarStatusEventCollection());
    }

    /**
     * Test of getHsdpaConnectionCollection method, of class Car.
     */
    @Test
    public void testGetHsdpaConnectionCollection() {
        System.out.println("getHsdpaConnectionCollection");
        Car instance = new Car("78546");
        Collection<HsdpaConnection> expResult = null;
        Collection<HsdpaConnection> result = instance.getHsdpaConnectionCollection();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setHsdpaConnectionCollection method, of class Car.
     */
    @Test
    public void testSetHsdpaConnectionCollection() {
        System.out.println("setHsdpaConnectionCollection");
        Collection<HsdpaConnection> hsdpaConnectionCollection = null;
        Car instance = new Car("123456");
        instance.setHsdpaConnectionCollection(hsdpaConnectionCollection);
        assertEquals(instance.getHsdpaConnectionCollection(), hsdpaConnectionCollection);
    }

    /**
     * Test of getOverallConnectionCollection method, of class Car.
     */
    @Test
    public void testGetOverallConnectionCollection() {
        System.out.println("getOverallConnectionCollection");
        Car instance = new Car("785469");
        Collection<OverallConnection> expResult = null;
        Collection<OverallConnection> result = instance.getOverallConnectionCollection();
        assertEquals(expResult, result);
       
    }


    /**
     * Test of equals method, of class Car.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = new Car("1456");
        Car instance = new Car("1456");
        boolean expResult = true;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
    }

    

    /**
     * Test of getPK method, of class Car.
     */
    @Test
    public void testGetPK() {
        System.out.println("getPK");
        Car instance = new Car("456456");
        Object expResult = "456456";
        Object result = instance.getPK();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCar method, of class Car.
     */
    @Test
    public void testGetCar() {
        System.out.println("getCar");
        Car instance = new Car("456456");
        Car expResult = null;
        Car result = instance.getCar();
        assertEquals(expResult, result);
    }

    /**
     * Test of mergeWithObjectFromDatabase method, of class Car.
     */
    @Test
    public void testMergeWithObjectFromDatabase() {
        System.out.println("mergeWithObjectFromDatabase");
        EntityClass ec = new Car("456456");
        Car instance = new Car("456456");
        EntityClass expResult = new Car("456456");
        EntityClass result = instance.mergeWithObjectFromDatabase(ec);
        assertEquals(expResult, result);
    }
    
}
