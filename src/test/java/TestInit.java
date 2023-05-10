import org.junit.*;
import static org.junit.Assert.fail;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestInit {
    @Test
    public void testInit() {
        Systeme sys = new Systeme();
        assertTrue(sys.getWaiting().isEmpty());
        assertTrue(sys.isCurrent(null));
        assertTrue(sys.isLast(null));
        //test that las is null

    }

@Test
    public void testInit2() {
        Systeme sys = new Systeme();
        try {
            sys.swap();
            fail();
        } catch (ErreurSysteme e) {
            assertTrue(sys.getWaiting().isEmpty());
            assertTrue(sys.isCurrent(null));
            assertTrue(sys.isLast(null));
        }
    }


}
