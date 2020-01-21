package hw1;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecordTEST {
    VideoObj video = new VideoObj( "A", 2000, "B" );
    Record r1 = new Record( video, 20, 10, 300 );
    Record r2 = r1.copy();
    
    @Test
    public void testCopy() {
      // be sure to test that copy returns a NEW reference!
      assertTrue( r1 != r2 );
      assertTrue( r1.toString().equals(r2.toString()) );
    }
}

