import org.junit.*;
import static org.junit.Assert.*;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class TestZero {
    Systeme sys;
    Processus p1;
    @Before
    public void setUp() throws ErreurSysteme {
        sys = new Systeme();
        p1 = new Processus("p1");
    }

    @Test
    public void testInit() {
        assertTrue(sys.getWaiting().isEmpty());
        assertTrue(sys.isCurrent(null));
        assertTrue(sys.isLast(null));
    }

    @Test(expected = ErreurSysteme.class)
    public void testFalseAdd() throws ErreurSysteme {
        sys.add(null);
    }

    @Test
    public void testFalseAddBis() {
        try {
            sys.add(null);
        } catch (ErreurSysteme e) {
            assertTrue(sys.getWaiting().isEmpty());
            assertTrue(sys.isCurrent(null));
            assertTrue(sys.isLast(null));
        }
    }

    @Test(expected = ErreurSysteme.class)
    public void testFalseAdd2() throws ErreurSysteme {
        sys.add(new Processus(""));
    }

    @Test
    public void testFalseAdd2Bis() {
        try {
            sys.add(new Processus(""));
        } catch (ErreurSysteme e) {
            assertTrue(sys.getWaiting().isEmpty());
            assertTrue(sys.isCurrent(null));
            assertTrue(sys.isLast(null));
        }
    }

    @Test(expected = ErreurSysteme.class)
    public void testFalseSwap() throws ErreurSysteme {
        sys.swap();
    }

    @Test
    public void testFalseSwapBis() {
        try {
            sys.swap();
        } catch (ErreurSysteme e) {
            assertTrue(sys.getWaiting().isEmpty());
            assertTrue(sys.isCurrent(null));
            assertTrue(sys.isLast(null));
        }
    }

    @Test
    public void testTransition() {
        try{
            sys.add(p1);
        }catch (ErreurSysteme e){
            fail("ErreurSysteme inattendue");
        }
        assertTrue(sys.getWaiting().isEmpty());
        assertTrue(sys.isCurrent(p1));
        assertTrue(sys.isLast(null));
    }
}
