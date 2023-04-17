import org.junit.rules.ExpectedException;
import testEtat.*;
import org.junit.*;
import static org.junit.Assert.*;

public class TestInit {

	private Conteneur C;

	@Test
	public void testTransition() throws ErreurConteneur {
		C = new Conteneur(5);
		if(!C.estVide()){
			fail("Le conteneur n'est pas vide à l'initialisation");
		}
		if(C.capacite() != 5){
			fail("La capacité du conteneur n'est pas correcte");
		}
	}
	@Test(expected=ErreurConteneur.class)
	public void testTransitionVide() throws ErreurConteneur {
		C = new Conteneur(-5);
	}

}
