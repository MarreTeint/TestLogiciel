import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import junit.framework.JUnit4TestAdapter;

import java.util.Collection;
public class TestTwo {

    Systeme sys;
    Processus p1, p2,p3;

    @Before
    public void setUp () throws ErreurSysteme {
        sys = new Systeme();
        p1 = new Processus("p1");
        p2 = new Processus("p2");
        p3 = new Processus("p3");
        sys.init();
    }


    @Test
    public void testTwo() throws ErreurSysteme {
        Collection<Processus> res;
        sys.add(p1);
        sys.add(p2);
        res = sys.getWaiting();
        assertTrue(sys.isCurrent(p1));
        assertTrue(res.contains(p2));
        assertEquals(res.size(), 1);
        sys.swap();
        res = sys.getWaiting();
        assertTrue(sys.isCurrent(p2));
        assertTrue(res.contains(p1));
        assertEquals(res.size(), 1);
        assertTrue(sys.isLast(p1));
    }

    @Test
    public void testTwoBis() throws ErreurSysteme {
        // L'état initial est l'objet d'autres tests.
        // Ici on suppose donc qu'au démarrage d'une méthode
        // de test on est bien ans l'état initial.
        sys.add(p1); // ne doit pas lever l'exception
        try {
            sys.add(p2); // ne doit pas lever l'exception
        } catch (ErreurSysteme e) {
            fail();
        }
        try {
            sys.swap(); // ne doit pas lever l'exception
        } catch (ErreurSysteme e) {
            fail();
        }
        // vérifie l'état après la levée d'exception
        assertTrue(sys.isLast(p1));
        assertTrue(sys.isCurrent(p2));
        assertTrue(sys.getWaiting().contains(p1));

    }

    @Test
    public void testTwoTer() throws ErreurSysteme {
        // L'état initial est l'objet d'autres tests.
        // Ici on suppose donc qu'au démarrage d'une méthode
        // de test on est bien ans l'état initial.
        sys.add(p1); // ne doit pas lever l'exception
        try {
            sys.add(p2); // ne doit pas lever l'exception
        } catch (ErreurSysteme e) {
            fail();
        }
        try {
            sys.swap(); // ne doit pas lever l'exception
        } catch (ErreurSysteme e) {
            fail();
        }
        try {
            sys.swap(); // ne doit pas lever l'exception
        } catch (ErreurSysteme e) {
            fail();
        }
        // vérifie l'état après la levée d'exception
        assertTrue(sys.isLast(p2));
        assertTrue(sys.isCurrent(p1));
        assertTrue(sys.getWaiting().contains(p2));

    }

    @Test
    public void testTwoQuater() throws ErreurSysteme {
        // L'état initial est l'objet d'autres tests.
        // Ici on suppose donc qu'au démarrage d'une méthode
        // de test on est bien ans l'état initial.
        sys.add(p1); // ne doit pas lever l'exception
        try {
            sys.add(p2); // ne doit pas lever l'exception
        } catch (ErreurSysteme e) {
            fail();
        }
        // vérifie l'état après la levée d'exception
        assertTrue(sys.isLast(null));
        assertTrue(sys.isCurrent(p1));
        assertTrue(sys.getWaiting().contains(p2));
        assertEquals(sys.getWaiting().size(),1);

    }

    @Test
    public void testTwoCinq() throws ErreurSysteme {
        // L'état initial est l'objet d'autres tests.
        // Ici on suppose donc qu'au démarrage d'une méthode
        // de test on est bien ans l'état initial.
        sys.add(p1); // ne doit pas lever l'exception
        try {
            sys.add(p2); // ne doit pas lever l'exception
        } catch (ErreurSysteme e) {
            fail();
        }
        try {
            sys.add(p3); // ne doit pas lever l'exception
        } catch (ErreurSysteme e) {
            fail();
        }
        assertTrue(sys.isLast(null));
        assertTrue(sys.isCurrent(p1));
        assertTrue(sys.getWaiting().contains(p2));
        assertTrue(sys.getWaiting().contains(p3));
        assertEquals(sys.getWaiting().size(),2);

    }

    @Test
    public void testTwoSix() throws ErreurSysteme {
        // L'état initial est l'objet d'autres tests.
        // Ici on suppose donc qu'au démarrage d'une méthode
        // de test on est bien ans l'état initial.
        sys.add(p1); // ne doit pas lever l'exception
        try {
            sys.add(p2); // ne doit pas lever l'exception
        } catch (ErreurSysteme e) {
            fail();
        }
        try {
            sys.add(null);
            fail();// ne doit pas lever l'exception
        } catch (ErreurSysteme e) {

        }
        assertTrue(sys.isLast(null));
        assertTrue(sys.isCurrent(p1));
        assertTrue(sys.getWaiting().contains(p2));
        assertFalse(sys.getWaiting().contains(null));
        assertEquals(sys.getWaiting().size(),1);




    }

    @Test
    public void testTwoSept() throws ErreurSysteme {
        // L'état initial est l'objet d'autres tests.
        // Ici on suppose donc qu'au démarrage d'une méthode
        // de test on est bien ans l'état initial.
        sys.add(p1); // ne doit pas lever l'exception
        try {
            sys.add(p2); // ne doit pas lever l'exception
        } catch (ErreurSysteme e) {
            fail();
        }
        try {
            sys.add(p1);
            fail();// doit lever l'exception
        } catch (ErreurSysteme e) {

        }
        assertTrue(sys.isLast(null));
        assertTrue(sys.isCurrent(p1));
        assertTrue(sys.getWaiting().contains(p2));
        assertFalse(sys.getWaiting().contains(p1));
        assertEquals(sys.getWaiting().size(),1);
    }

    @Test
    public void testTwoHuit() throws ErreurSysteme {
        // L'état initial est l'objet d'autres tests.
        // Ici on suppose donc qu'au démarrage d'une méthode
        // de test on est bien ans l'état initial.
        sys.add(p1); // ne doit pas lever l'exception
        try {
            sys.add(p2); // ne doit pas lever l'exception
        } catch (ErreurSysteme e) {
            fail();
        }
        try {
            sys.add(p1);
            sys.add(new Processus("p2"));
            fail();// ne doit pas lever l'exception
        } catch (ErreurSysteme e) {}

    }
}
