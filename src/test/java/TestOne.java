import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import junit.framework.JUnit4TestAdapter;

import java.util.Collection;

public class TestOne {

    Systeme sys;
    Processus p1, p2;

    @Before
    public void setUp () throws ErreurSysteme {
        sys = new Systeme();
        p1 = new Processus("p1");
        p2 = new Processus("p2");
        sys.init();
    }


    @Test public void testOne() throws ErreurSysteme {
        sys.add(p1);
        assertTrue(sys.isCurrent(p1));
        assertTrue(sys.getWaiting().isEmpty());
        assertTrue(sys.isLast(null));
    }


    @Test
    public void testOneBis() throws ErreurSysteme {
        // L'état initial est l'objet d'autres tests.
        // Ici on suppose donc qu'au démarrage d'une méthode
        // de test on est bien ans l'état initial.
        sys.add(p1); // ne doit pas lever l'exception
        try {
            sys.swap(); // doit lever l'exception
            fail();     // S'il ne lève rien spontanément on l'aide
        } catch (ErreurSysteme e)  { }
        // vérifie l'état après la levée d'exception
        assertTrue(sys.isLast(null));
        assertTrue(sys.isCurrent(p1));
        assertTrue(sys.getWaiting().isEmpty());
    }

    @Test
    public void testOneTer() throws ErreurSysteme {
        // L'état initial est l'objet d'autres tests.
        // Ici on suppose donc qu'au démarrage d'une méthode
        // de test on est bien ans l'état initial.
        sys.add(p1); // ne doit pas lever l'exception
        try {
            sys.add(p1); // doit lever l'exception
            fail();     // S'il ne lève rien spontanément on l'aide
        } catch (ErreurSysteme e)  { }
        // vérifie l'état après la levée d'exception
        assertTrue(sys.isLast(null));
        assertTrue(sys.isCurrent(p1));
        assertTrue(sys.getWaiting().isEmpty());

    }

    @Test
    public void testOneQuater() throws ErreurSysteme {
        // L'état initial est l'objet d'autres tests.
        // Ici on suppose donc qu'au démarrage d'une méthode
        // de test on est bien ans l'état initial.
        sys.add(p1); // ne doit pas lever l'exception
        try {
            sys.add(null); // doit lever l'exception
            fail();     // S'il ne lève rien spontanément on l'aide
        } catch (ErreurSysteme e)  { }
        // vérifie l'état après la levée d'exception
        assertTrue(sys.isLast(null));
        assertTrue(sys.isCurrent(p1));
        assertTrue(sys.getWaiting().isEmpty());

    }

    @Test
    public void testOneCinq() throws ErreurSysteme {
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

    }



}
