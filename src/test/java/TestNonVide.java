import testEtat.*;
import org.junit.*;
import static org.junit.Assert.*;

public class TestNonVide {

	private Conteneur C;

	@Before
	public void creerConteneurNonVide() throws ErreurConteneur {
		C = new Conteneur(3);
		C.ajouter(1,1);
		C.ajouter(2,7);
	}

	@Test
	public void testTransitionVide() {
		C.retirer(1);
		if(C.estVide()){
			fail("Le conteneur est vide alors qu'il devrait être non vide");
		}
		C.retirer(2);
		if(!C.estVide()){
			fail("Le conteneur est non vide alors qu'il devrait être vide");
		}
	}

	@Test
	public void testTransitionPlein() throws ErreurConteneur {
		C.ajouter(3, 3);

	}

	@Test
	public void testAjouterCleExistante() throws ErreurConteneur {
		C.ajouter(2, 7);
		if((int)C.valeur(2) != 7){
			fail("La valeur n'est pas correcte (Attendu: 7, Récupéré: "+C.valeur(2)+")");
		}
	}
	@Test
	public void testValeurExistante() throws ErreurConteneur {
		int i = (int) C.valeur(2);
		if(i != 7){
			fail("La valeur n'est pas correcte (Attendu: 7, Récupéré: "+C.valeur(2)+")");
		}
	}
	
}
