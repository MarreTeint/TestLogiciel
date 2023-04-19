import org.junit.*;

import static org.junit.Assert.*;

public class TestThree {

    Systeme sys;
    Processus p1, p2, p3, p4, p5, last, current;

    @Before
    public void setUp() throws ErreurSysteme {
        sys = new Systeme();
        p1 = new Processus("p1");
        p2 = new Processus("p2");
        p3 = new Processus("p3");
        p4 = new Processus("p4");
        p5 = new Processus("p5");
        sys.init();
        sys.add(p1);
        sys.add(p2);
        sys.swap();
        current = p2;
        last = p1;
        sys.add(p3);
    }

    @Test
    public void testSwap() throws ErreurSysteme {
        sys.swap();
        assertTrue(sys.isCurrent(p3));
        assertTrue(sys.isLast(p2));
        assertTrue(sys.getWaiting().contains(p1));
        assertTrue(sys.getWaiting().contains(p2));
    }

    @Test
    public void testDoubleSwap() throws ErreurSysteme {
        sys.swap();
        sys.swap();
        assertTrue(sys.isCurrent(p1));
        assertTrue(sys.isLast(p3));
        assertTrue(sys.getWaiting().contains(p2));
        assertTrue(sys.getWaiting().contains(p3));
    }

    @Test(expected = ErreurSysteme.class)
    public void testFalseAdd() throws ErreurSysteme {
        sys.add(null);
    }

    @Test(expected = ErreurSysteme.class)
    public void testFalseAdd2() throws ErreurSysteme {
        sys.add(new Processus(""));
    }

    @Test
    public void testFalseAddBis() {
        try {
            sys.add(null);
        } catch (ErreurSysteme e) {
            assertTrue(sys.isCurrent(current));
            assertTrue(sys.isLast(last));
            assertTrue(sys.getWaiting().contains(last));
            assertTrue(sys.getWaiting().contains(p3));
            assertEquals(sys.getWaiting().size(), 2);
        }
    }

    @Test
    public void testFalseAdd2Bis() {
        try {
            sys.add(new Processus(""));
        } catch (ErreurSysteme e) {
            assertTrue(sys.isCurrent(current));
            assertTrue(sys.isLast(last));
            assertTrue(sys.getWaiting().contains(last));
            assertTrue(sys.getWaiting().contains(p3));
            assertEquals(sys.getWaiting().size(), 2);
        }
    }

    @Test
    public void testAdd(){
        try {
            sys.add(p4);
            assertTrue(sys.isCurrent(current));
            assertTrue(sys.isLast(last));
            assertTrue(sys.getWaiting().contains(p4));
        }catch (ErreurSysteme e){
            fail();
        }
    }

    @Test(expected = ErreurSysteme.class)
    public void testExistingAdd() throws ErreurSysteme {
        sys.add(p3);
    }

    @Test
    public void testExistingAddBis() {
        try {
            sys.add(p3);
        } catch (ErreurSysteme e) {
            assertTrue(sys.isCurrent(current));
            assertTrue(sys.isLast(last));
            assertTrue(sys.getWaiting().contains(last));
            assertTrue(sys.getWaiting().contains(p3));
            assertEquals(sys.getWaiting().size(), 2);
        }
    }
}
