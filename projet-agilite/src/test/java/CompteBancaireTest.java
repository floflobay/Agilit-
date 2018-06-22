
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
public class CompteBancaireTest {
	
	@Test
	public void testGetSolde() {
		CompteBancaire c = new CompteBancaire(30.0);
		assertEquals(30.0, c.getSolde(), 0.1);
	}
	@Test
	public void testDeposer() {
		CompteBancaire c = new CompteBancaire();
		c.deposer(20.5);
		assertEquals(20.5, c.getSolde(), 0.1);
	}
	@Test
	public void testRetirer() {
		CompteBancaire c = new CompteBancaire(50.0);
		c.retirer(15.0);
		assertEquals(35.0, c.getSolde(), 0.1);
		//assertArrayEquals("impossible de retirer un montant négatif; opération refusée", expecteds, actuals, delta);
	}
	@Test
	public void test () {
		CompteBancaire compte = new CompteBancaire(30.0);
		this.testDeposer();
		this.testRetirer();
		this.testGetSolde();
		
	}
	

}
