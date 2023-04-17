import org.junit.rules.ExpectedException;
import testEtat.*;
import org.junit.*;
import static org.junit.Assert.*;

public class TestVide {

    private Conteneur C;
    
	@Before
	public void creerConteneurVide() throws ErreurConteneur {
		C = new Conteneur(5);
	}

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	@Test
	public void testTransition() throws ErreurConteneur {
		C.ajouter(2,2);
		if(C.estVide()){
			fail("Le conteneur est vide alors qu'il devrait être non vide");
		}
	}
	
	@Test
	public void testRetirer(){
		C.retirer(2);
	}

	@Test
	public void testGetValeurNull() throws ErreurConteneur {
		exceptionRule.expect(ErreurConteneur.class);
		C.valeur(2);
	}

}
