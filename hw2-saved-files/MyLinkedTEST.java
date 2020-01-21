package hw2;

//import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MyLinkedTEST {
  
  @Test
  public void testDelete () {
      //add one node and test
      MyLinked b = new MyLinked ();
      b.add (1);
      assertTrue(b.N == 1);
      //delete only node and test
      b.delete (0);
      assertTrue(b.N == 0);
      // add 1-12 into list test size
      for (double i = 1; i < 13; i++) {
          b.add (i);
      }
      assertTrue(b.N == 12);
      //delete the first node and test
      b.delete (0);
      assertTrue(b.first.item==11);
      //delete the last node and test
      b.delete (b.N-1);
      assertTrue(b.N==10);
      b.delete (4);
      assertTrue(b.N == 9);
  }
  @Test
  public void testReverse () {
    //create an empty linked list and reverse it
      MyLinked b = new MyLinked ();
      b.reverse ();
      assertTrue(b.isEmpty());
      //add a single element to the head and test
      b.add (1);
      assertTrue(b.first.item==1);
      //reverse that single element and test
      b.reverse ();
      assertTrue(b.first.item==1);
      //add one more element to the head and test
      b.add (2);
      assertTrue(b.N==2);
      //reverse so that 1 is first
      b.reverse ();
      assertTrue(b.first.item==1);
      //reverse it back so 2 is first
      b.reverse ();
      assertTrue(b.first.item==2);
      //add 3,3,4,4,5,5,6,6 to list
      for (double i = 3; i < 7; i++) {
          b.add (i);
          b.add (i);
      }
      assertTrue(b.N==10);
      //reverse it so 1 is back to being the head
      b.reverse ();
      assertTrue(b.first.item==1);
      assertTrue(b.first.next.next.item==3);
  }

  @Test
  public void testRemove () {
    // create an empty list and try to remove an element
      MyLinked b = new MyLinked ();
      b.remove (4);
      assertTrue("something went wrong I think", b.isEmpty());
      //add an element with value 1 and try to remove 4 instead
      b.add (1);
      b.remove (4);
      assertTrue(b.N==1);
      assertTrue(b.first.item==1);
      //this time try and remove the existing 1
      b.remove (1);
      assertTrue("couldn't remove b.first.item(1)", b.isEmpty());
      for (double i = 1; i < 5; i++) {
          b.add (i);
          b.add (i);
      }
      for (double i = 1; i < 5; i++) {
          b.add (i);
          b.add (i);
          b.add (i);
          b.add (i);
          b.add (i);
      }
      assertTrue(b.toString(), b.N==28);
      //try to remove a 9 that doesn't exist
      b.remove (9);
      assertTrue(b.N==28);
      //remove all 3s, should be 7
      b.remove (3);
      assertTrue(b.N==21);
      //removes all 1s, should be 7
      b.remove (1);
      assertTrue(b.N==14);
      //remove all 4s, should be 7
      b.remove (4);
      assertTrue(b.N==7);
      //remove all 2s, should be 7
      b.remove (2);
      assertTrue(b.isEmpty());
  }
}