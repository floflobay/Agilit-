import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;  
import cucumber.api.java.en.Then;  
import cucumber.api.java.en.When;
import gherkin.lexer.En;
import gherkin.lexer.Listener; 

/**
 * @author Kakama & Noufissa
 *
 */

public class RetraitSteps {

	private CompteBancaire compte;
	private CompteBancaire compte2;
	

	@Given("^un client c de la banque KN existe  avec un solde initial de (\\d+.\\d) et veut faire un retrait$")
	public void un_client_c_de_la_banque_KN_existe_avec_un_solde_initial_et_de_veut_faire_un_retrait(double arg1) throws Throwable{
		compte = new CompteBancaire(arg1);
		
		// Write code here that turns the phrase above into concrete actions
	  //  throw new PendingException();
	}

	@When("^le client c appelle la methode retirer avec en attribut le (\\d+.\\d)$")
	public void le_client_c_appelle_la_methode_retirer_avec_en_attribut_le (double arg1) throws Throwable{
		compte.retirer(arg1);
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
	}

	@Then("^le nouveau solde est (\\d+.\\d+)$")
	public void le_nouveau_solde_est(double arg1) throws Throwable{
		assertEquals(arg1, compte.getSolde(), 0.1);
	}
	@Given("^un client d de la banque KN existe avec un solde initial de (\\d+.\\d) et veut faire un retrait$")
	public void un_client_d_de_la_banque_KN_existe_avec_un_solde_initial_de_et_de_veut_faire_un_retrait(double arg1) throws Throwable{
		compte = new CompteBancaire(arg1);
		// Write code here that turns the phrase above into concrete actions
	  //  throw new PendingException();
	}

	@When("^le client d appelle la methode retirer avec en attribut le (\\d+.\\d)$")
	public void le_client_d_appelle_la_methode_retirer_avec_en_attribut_le (double arg1) throws Throwable{
		compte.retirer(arg1);
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
	}

	@Then("^Afficher message d'eurreur \"([^\"]*)\"$")
	public void un_compte_est_cree_avec_le_solde(String arg1) throws Throwable{
		assertNotNull(compte);
		String msg = "impossible de retirer : votre solde est insuffisant pour cette operation";
		msg.equals(arg1);
	}
	@Given("^un client de la banque KN existe avec un solde initial par defaut nul$")
	public void un_client_de_la_banque_KN_existe_avec_un_solde_initial_par_defaut_nul() throws Throwable{
		compte = new CompteBancaire();
	}

	@When("^le client appelle la methode retirer avec attribut (\\d+.\\d)$")
	public void le_client_appelle_la_methode_retirer_avec_attribut (double arg1) throws Throwable{
		compte.retirer(arg1);
	}

	@Then("^son solde reste egale a (\\d+.\\d)$")
	public void son_solde_reste_egale_a(double arg1) throws Throwable{
		assertNotNull(compte);
		assertEquals(arg1, 0.0, 0.1);
		assertEquals(compte.getSolde(), 0.0, 0.1);
	}
}