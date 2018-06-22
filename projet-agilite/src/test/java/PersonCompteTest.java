
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
public class PersonCompteTest {
	@Test
	public void test() {
		Personne p = new Personne("kakama","Bencherif", 22);
		CompteBancaire c = new CompteBancaire();
		c.invokPersonne(p);
		p.invokCompteBancaire(c);
		assertSame(p,c.getProprietaire());
		assertSame(c,p.getCompte());
		
		
	}
}
