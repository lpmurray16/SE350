package hw1;


//import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Test;



public class VideoTEST {
  @Test
  public void testConstructorAndAttributes() {
    String title1 = "XX";
    String director1 = "XY";
    String title2 = " XX ";
    String director2 = " XY ";
    int year = 2002;

    VideoObj v1 = new VideoObj(title1, year, director1);
    assertSame(title1, v1.title());
    assertEquals(year, v1.year());
    assertSame(director1, v1.director());

    VideoObj v2 = new VideoObj(title2, year, director2);
    assertEquals(title1, v2.title());
    assertEquals(director1, v2.director());
  }
  @Test
  public void testConstructorExceptionYear() {
    try {
      new VideoObj("X", 1800, "Y");
      fail();
    } catch (IllegalArgumentException e) { }
    try {
      new VideoObj("X", 5000, "Y");
      fail();
    } catch (IllegalArgumentException e) { }
    try {
      new VideoObj("X", 1801, "Y");
      new VideoObj("X", 4999, "Y");
    } catch (IllegalArgumentException e) {
      fail();
    }
  }
  
  
  public void testConstructorExceptionTitle() {
    try {
      new VideoObj(null, 2002, "Y");
      fail();
    } catch (IllegalArgumentException e) { }
    try {
      new VideoObj("", 2002, "Y");
      fail();
    } catch (IllegalArgumentException e) { }
    try {
      new VideoObj(" ", 2002, "Y");
      fail();
    } catch (IllegalArgumentException e) { }
  }

  public void testConstructorExceptionDirector() {
	  try {
	      new VideoObj("j", 2002, null);
	      fail();
	    } catch (IllegalArgumentException e) { }
	    try {
	      new VideoObj("d", 2002, "");
	      fail();
	    } catch (IllegalArgumentException e) { }
	    try {
	      new VideoObj("f", 2002, " ");
	      fail();
	    } catch (IllegalArgumentException e) { }  
  }

  public void testHashCode() {
    assertEquals(-875826552,
       new VideoObj("None", 2009, "Zebra").hashCode());
    assertEquals(-1391078111,
       new VideoObj("Blah", 1954, "Cante").hashCode());
  }

  public void testEquals() { 
    
	  VideoObj example1 = new VideoObj("KingKong", 2013, "Smith");
	  VideoObj sameAs = new VideoObj("KingKong", 2013, "Smith");
	  VideoObj example2 = new VideoObj("CoolBeans", 2012, "Mack");
	
	  assertTrue(example1.equals(sameAs));
	  assertFalse(example1.equals(example2));
  }

  public void testCompareTo() { 
	  VideoObj example1 = new VideoObj("KingKong", 2013, "Smith");
	  VideoObj sameAs = new VideoObj("KingKong", 2013, "Smith");
	  VideoObj example2 = new VideoObj("CoolBeans", 2012, "Mack");
    
	  assertTrue(example1.compareTo(example2) > 0);
	  assertTrue(example2.compareTo(example1) < 0);
	  assertTrue(example1.compareTo(sameAs)==0);
  }

  public void testToString() { 
	
	  VideoObj example2 = new VideoObj("CoolBeans", 2012, "Mack");
	
	  String ex2 = example2.toString();
	
	  assertEquals(ex2, "CoolBeans (2012) : Mack");
  }
}
