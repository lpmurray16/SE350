package hw2;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class AssertExp1TEST {


  @Test
  public void testremoveDuplicates(){
    
    double[] test = new double[] {11,11,22,33,33,33,44};
    double[] newTest = hw2.AssertExp1.removeDuplicates(test);
    assertTrue(newTest.length==4);
    assertTrue(newTest[0]==11);
    assertTrue(newTest[1]==22);
    assertTrue(newTest[2]==33);
    assertTrue(newTest[3]==44);
  }
  @Test
  public void testnumUnique() {
    double[] test = new double[] {11,11,22,33,33,33,44};
    int unqNum = hw2.AssertExp1.numUnique(test);
    assertTrue(unqNum == 4);
  }
}