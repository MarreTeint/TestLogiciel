import org.junit.rules.ExpectedException;
import testEtat.*;
import org.junit.*;
import static org.junit.Assert.*;

public class TestInit {

	private Conteneur C;

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
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
	@Test
	public void testTransitionVide() throws ErreurConteneur {
		exceptionRule.expect(ErreurConteneur.class);
		C = new Conteneur(-5);
	}

}
