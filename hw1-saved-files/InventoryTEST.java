package hw1;

import org.junit.Test;

import static org.junit.Assert.*;

//import java.util.Iterator;
//import java.util.Set;
//import java.util.HashSet;

public class InventoryTEST {

  InventorySet testInv = new InventorySet();
  
  VideoObj ex1 = new VideoObj("ABC", 2000, "Xion");
  VideoObj ex2 = new VideoObj("BCD", 2001, "Yion");
  VideoObj ex3 = new VideoObj("CDE", 2002, "Zion");
  
  Record r1 = new Record(ex1, 30, 15, 120);
  Record r2 = new Record(ex2, 15, 14, 1233);
  Record r3 = new Record(ex3, 28, 0, 156);


  @Test
  public void testSize() {
    assertTrue(testInv.size()==0);
    testInv.addNumOwned(ex1, 2);
    
    assertTrue(testInv.size()==1);
    testInv.addNumOwned(ex3, 4);
    assertTrue(testInv.size()==2);

  }
  
  @Test
  public void testAddNumOwned() {
	
	  assertTrue(testInv.size()==0);
    testInv.addNumOwned(ex2, 30);
    assertTrue(testInv.get(ex2).numOwned==30);
    assertTrue(testInv.size()==1);
    testInv.addNumOwned(ex2, -5);
    assertTrue(testInv.get(ex2).numOwned==25);
    //System.out.print(testInv.toString());
  }
  
  @Test
  public void testCheckOutCheckIn() {
    testInv.addNumOwned(ex2, 30);
    assertTrue(testInv.get(ex2).numOwned == 30);
    System.out.println(testInv);
    
    testInv.checkOut(ex2);
    assertTrue(testInv.get(ex2).numOut==1);
  }
  
  // @Test
  // public void testClear() {
	//   testInv.addNumOwned(ex1, 13);
	//   testInv.addNumOwned(ex2, 44);
  //   System.out.print(testInv.toString());
  //   testInv.clear();
  //   assertTrue(testInv.size()==0);
  //   System.out.print(testInv.toString());
  // }
  
  @Test
  public void testGet() {
    System.out.println(testInv);
    Record testex = testInv.get(ex1);
    System.out.println(testex);
    assertTrue(testInv.get(ex1) == testex);
  }
  
  @Test
  public void testToCollection() {
    // Be sure to test that changing records in the returned
    // collection does not change the original records in the
    // inventory.  ToCollection should return a COPY of the records,
    // not the records themselves.
    // TODO  
  }
}
