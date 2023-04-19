	import org.junit.Test;
	import org.junit.Before;
	import static org.junit.Assert.fail;
	import static org.junit.Assert.assertTrue;
	import static org.junit.Assert.assertFalse;
	import static org.junit.Assert.assertEquals;
	import junit.framework.JUnit4TestAdapter;
	
	import java.util.Collection;
	
	public class TestFV { 
	
	    Systeme sys;
	    Processus p1, p2;
	
	    @Before
	    public void setUp () throws ErreurSysteme {
		sys = new Systeme();
		p1 = new Processus("p1");
		p2 = new Processus("p2");
		sys.init();
	    }
	
            boolean initOK() { // methode auxiliaire...
		return sys.getWaiting().isEmpty()
		    && sys.isCurrent(null) && sys.isLast(null);
	    }
	
	    @Test public void testInit1() { 
		assertTrue(initOK());
	    }

	    
	    @Test(expected=ErreurSysteme.class) // teste la levee d'exception
	    public void testInit2() throws ErreurSysteme {
		sys.swap();
	    }

	    
	    // teste que le swap n'a rien modifie en plus de lever l'exception.
	    @Test public void testInit2Bis() { 
	    	try { sys.swap(); }
	    	catch (ErreurSysteme e) { assertTrue(initOK()); }
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
		    fail();     // S'il ne lève rien spontanement on l'aide
		} catch (ErreurSysteme e)  { }
		// vérifie l'état après la levée d'exception
		assertTrue(sys.isLast(null));
		assertTrue(sys.isCurrent(p1));
		assertTrue(sys.getWaiting().isEmpty());
	    }
	    
	    // Il pourrait etre pratique d'avoir une fonction auxiliaire
	    // qui gere les ensembles de Processus en attente: le bon
	    // nombre et les bons éléments (attention au .equals de Collection)
	    
	    // Un peu plus long mais loin d'etre complet
	    @Test
	    public void testTwoa() throws ErreurSysteme {
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
	    

	    public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(TestFV.class);
	    }

	}
