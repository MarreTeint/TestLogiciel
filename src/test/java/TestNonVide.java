import testEtat.*;
import org.junit.*;
import static org.junit.Assert.*;

public class TestNonVide {

	private Conteneur C;

	@Before
	public void creerConteneurNonVide() throws ErreurConteneur {
		C = new Conteneur(5);
		C.ajouter(2,2);
	}

	@Test
	public void testTransition() {
		C.retirer(2);
		if(!C.estVide()){
			fail("Le conteneur est non vide alors qu'il devrait être vide");
		}
	}
	
	// a completer	
	
}
