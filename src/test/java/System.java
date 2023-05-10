import org.junit.*;

import static org.junit.Assert.*;

public class System {

    Systeme sys;
    Processus p1, p2, p3, p4, last, current;

    @Before
    public void setUp() throws ErreurSysteme {
        sys = new Systeme();
        p1 = new Processus("p1");
        p2 = new Processus("p2");
        p3 = new Processus("p3");
        p4 = new Processus("p4");
        sys.init();
        sys.add(p1);
        sys.add(p2);
        sys.swap();
        current = p2;
        last = p1;
        sys.add(p3);
    }

    @Test
    public void testisLast() throws ErreurSysteme {
        sys.swap();
        assertTrue(sys.isCurrent(p3));
        assertTrue(sys.isLast(p2));
        assertFalse(sys.isLast(p3));

    }


    @Test
    public void testisCurrent() throws ErreurSysteme {
        sys.swap();
        assertTrue(sys.isCurrent(p3));
        assertTrue(sys.isLast(p2));
        assertFalse(sys.isCurrent(p2));


    }
}
