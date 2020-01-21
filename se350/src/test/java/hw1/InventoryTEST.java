package hw1;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

//import java.util.Iterator;
//import java.util.Set;
//import java.util.HashSet;

public class InventoryTEST {

  InventorySet testInv = new InventorySet();
  
  VideoObj aNa = new VideoObj("Abby and Angela", 2000, "Xaxier Leon");
  VideoObj bbH = new VideoObj("Baseball Heroes", 2001, "Yoyo Mah");
  VideoObj csB = new VideoObj("Cool Story Bro", 2002, "Zack Bacon");
  
  Record r_aNa = new Record(aNa, 30, 15, 120);
  Record r_bbH = new Record(bbH, 15, 14, 1233);
  Record r_csB = new Record(csB, 28, 0, 156);
  public void printTest(InventorySet is){
    System.out.println("==below is current DB status==\n" + is);
  }

  @Test
  public void testSize() {
    assertTrue(testInv.size()==0);
    testInv.addNumOwned(aNa, 2);
    
    assertTrue(testInv.size()==1);
    testInv.addNumOwned(csB, 4);
    assertTrue(testInv.size()==2);

    System.out.println("===call in testSize=== \n"+ testInv.toString());

  }
  
  @Test
  public void testAddNumOwned() {
	
	  assertTrue(testInv.size()==0);
    testInv.addNumOwned(bbH, 30);
    assertTrue(testInv.get(bbH).numOwned==30);
    assertTrue(testInv.size()==1);
    testInv.addNumOwned(bbH, -5);
    assertTrue(testInv.get(bbH).numOwned==25);

    System.out.println("===call in testAddNumOwned===\n "+ testInv.toString());
  }
  
  @Test
  public void testCheckOutCheckIn() {
    //change the number of 
    testInv.addNumOwned(bbH, 30);
    assertTrue(testInv.get(bbH).numOwned == 30);
    System.out.println("===call in testCheckOutCheckIn 1===\n" + testInv.toString());
    
    testInv.checkOut(bbH);
    assertTrue(testInv.get(bbH).numOut==1);
    System.out.println("==call in testCheckOutCheckIn 2==\n" + testInv.toString());

    testInv.checkIn(bbH);
    assertTrue(testInv.get(bbH).numOut==0);
    System.out.println("==call in testCheckOutCheckIn 3==\n" + testInv.toString());

  }
  
  @Test
  public void testClear() {
	  testInv.addNumOwned(aNa, 13);
	  testInv.addNumOwned(bbH, 44);
    System.out.print("===called from testClear 1===\n"+testInv.toString());
    testInv.clear();
    assertTrue(testInv.size()==0);
    System.out.print("===called from testClear 2===\n"+testInv.toString());
  }
  
  @Test
  public void testGet() {
    System.out.println("===Called from testGet:===\n" + testInv.toString());
    Record testex = testInv.get(aNa);
    System.out.println(testex);
    assertTrue(testInv.get(aNa) == testex);
  }
  
  @Test
  public void testToCollection() {
    // Be sure to test that changing records in the returned
    // collection does not change the original records in the
    // inventory.  ToCollection should return a COPY of the records,
    // not the records themselves.
    // TODO  
    Collection<Record> result = testInv.toCollection();
    printTest(testInv);
    System.out.println(result.toString());
  }
}
