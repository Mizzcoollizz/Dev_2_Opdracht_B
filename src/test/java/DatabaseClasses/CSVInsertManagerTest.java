/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseClasses;

import DatabaseClasses.EntityClasses.EntityClass;
import java.util.ArrayList;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author Elize
 */
@RunWith(MockitoJUnitRunner.class)

public class CSVInsertManagerTest {
    private ArrayList<EntityClass> entityData = null;
    private static EntityManagerFactory emf = null;
   
    public CSVInsertManagerTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
        emf = Persistence.createEntityManagerFactory("CSVInsertThread");
  
    }
    
    public ArrayList<EntityClass> getSampleEntityClassData(){
        ArrayList<EntityClass> list = new ArrayList();
        for(int i = 0; i < 1000; i++){
            list.add(mock(EntityClass.class));
        }
        return list;
    }
        
        
    
    @AfterClass
    public static void tearDownClass() {
        if(emf != null && emf.isOpen()){
            emf.close();
        }
    }
    
    @Before
    public void setUp() {
        entityData = getSampleEntityClassData();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public final void testInsertThreadDivider(){
        for(int i = 0; i < 1000; i++){
            CSVInsertManager.addObjectToPersistList(entityData.get(i));
        }
        
        assertTrue(CSVInsertManager.getInsertThreadsSize() == 10);
    
    }
   
    
    
    
}
