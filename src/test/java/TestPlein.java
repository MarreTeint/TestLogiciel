import org.junit.rules.ExpectedException;
import testEtat.*;
import org.junit.*;
import static org.junit.Assert.*;

public class TestPlein {

	private Conteneur C;

	@Before
	public void creerConteneurPlein() throws ErreurConteneur {
		C = new Conteneur(5);
		C.ajouter(1, 1);
		C.ajouter(2, 2);
		C.ajouter(3, 3);
		C.ajouter(4, 4);
		C.ajouter(5, 5);
	}

	@Test
	public void testTransition() throws ErreurConteneur {
		C.retirer(2);
		if(C.taille()==5){
			fail("Le conteneur est plein alors qu'il devrait être non plein");
		}
	}

	@Test(expected = ErreurConteneur.class)
	public void testAjouter() throws ErreurConteneur {
		C.ajouter(6, 6);
	}

}
