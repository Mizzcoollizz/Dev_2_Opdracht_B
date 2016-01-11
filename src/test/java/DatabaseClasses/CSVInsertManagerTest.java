/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseClasses;

import DatabaseClasses.EntityClasses.Car;
import DatabaseClasses.EntityClasses.EntityClass;
import Readers.CSVFileReader;
import java.util.ArrayList;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import static org.mockito.Mockito.mock;

/**
 *
 * @author Elize
 */
public class CSVInsertManagerTest {
    private ArrayList<EntityClass> entityClassData;
    private static EntityManagerFactory emf = null;
    
    public CSVInsertManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        emf = Persistence.createEntityManagerFactory("CSVInsertThread"); 
    }
    
    @AfterClass
    public static void tearDownClass() {
        if(emf != null && emf.isOpen()){
            emf.close();
        }
    }
    
    @Before
    public void setUp() {
        setSampleEntityClassData();
    }
    
    @After
    public void tearDown() {
        EntityManager em = emf.createEntityManager();
        CSVInsertManager.stopAllThreads();
            for(EntityClass entityClass: entityClassData){
                EntityClass foundObject = em.find(entityClass.getClass(), 
                        entityClass.getPK());
                if(foundObject != null){
                    em.remove(foundObject);
                }
            
            }
    }

    public void setSampleEntityClassData(){
        entityClassData = new ArrayList<EntityClass>();
        for(int i = 0; i < 1000; i++){
            Car car = new Car();
            car.setUnitId("Test" + i);
            entityClassData.add(car);
        }
    }
    
    @Test
    public final void testInsertThreadDivider(){
        System.out.println("testInsertThreadDivider");
        CSVFileReader.setReading(true);
        for(int i = 0; i < 1000; i++){
            CSVInsertManager.addObjectToPersistList(entityClassData.get(i));
        }
        CSVFileReader.setReading(false);
        assertTrue(CSVInsertManager.getInsertThreadsSize() == 10
        || CSVInsertManager.getInsertThreadsSize() == 9
        );
    }
    
    @Test
    public final void testStopAllThreads(){
        System.out.println("testStopAllThreads");
        CSVFileReader.setReading(true);
        for(int i = 0; i < 1000; i++){
            CSVInsertManager.addObjectToPersistList(entityClassData.get(i));
        }
        CSVFileReader.setReading(false);
        CSVInsertManager.stopAllThreads();
        assertTrue(CSVInsertManager.getInsertThreadsSize() == 0);
        
       }
    
    @Test
    public final void testThreadsCreation(){
        System.out.println("testThreadsCreation");
        CSVFileReader.setReading(true);
        for(int i = 0; i < 1000; i++){
            CSVInsertManager.addObjectToPersistList(entityClassData.get(i));
        }
        CSVFileReader.setReading(false);
        
        int startAmountOfThreads = CSVInsertManager.getInsertThreadsSize();
        int amountToDelete = new Random().nextInt(5);
        for(int i = 0; i < amountToDelete; i++){
            if(!CSVInsertManager.getInsertThreads().isEmpty()){
            CSVInsertManager.removeThread(CSVInsertManager.getInsertThreads().get(0));
            }
        }
        int expectedAmountOfThreads = (startAmountOfThreads - amountToDelete);
        assertTrue(CSVInsertManager.getInsertThreadsSize() == expectedAmountOfThreads
            || CSVInsertManager.getInsertThreadsSize() == expectedAmountOfThreads - 1);
       }
    
    @Test
    public final void testIsInserting(){
        System.out.println("testIsInserting");
        //Check if inserting is false, if there are no threads running, so 2x false
        assertEquals(CSVInsertManager.isInserting(), (CSVInsertManager.getInsertThreadsSize() > 0));
        CSVFileReader.setReading(true);
        for(int i = 0; i < 500; i++){
            CSVInsertManager.addObjectToPersistList(entityClassData.get(i));
        }
        CSVFileReader.setReading(false);
        //Check if inserting is true, if there are threads running, so 2x true
        assertEquals(CSVInsertManager.isInserting(), (CSVInsertManager.getInsertThreadsSize() > 0));
    }
    
    @Test
    public final void testInsertTime() throws InterruptedException{
     System.out.println("testInsertTime");
     long starttime = System.nanoTime();
     CSVFileReader.setReading(true);
     for(int i = 0; i < 1000; i++){
            CSVInsertManager.addObjectToPersistList(entityClassData.get(i));
        }
     CSVFileReader.setReading(false);
     while(CSVInsertManager.getInsertThreadsSize() > 0){
         Thread.sleep(500);
         System.out.println("sleeping...");
     }
     double secondsPassed = (System.nanoTime() - starttime) / 1000000000.0;
     assertTrue(secondsPassed < 15);
    }
   
}
