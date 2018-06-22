
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DepotSteps {
	private CompteBancaire compte;
	private CompteBancaire compte2;
	

	@Given("^un client c de la banque KN existe  avec un solde initial de (\\d+.\\d+) et veut faire un depot$")
	public void un_client_c_de_la_banque_KN_existe_avec_un_solde_initial_et_de_veut_faire_un_depot(double arg1) throws Throwable{
		compte = new CompteBancaire(arg1);
		
		// Write code here that turns the phrase above into concrete actions
	  //  throw new PendingException();
	}

	@When("^le client c appelle la methode deposer avec en attribut le (\\d+.\\d+)$")
	public void le_client_c_appelle_la_methode_deposer_avec_en_attribut_le (double arg1) throws Throwable{
			compte.deposer(arg1);

	}

	@Then("^le nouveau solde de son compte est (\\d+.\\d+)$")
	public void le_nouveau_solde_de_son_compte_est(double arg1) throws Throwable{
		assertEquals(arg1, compte.getSolde(), 0.1);
	}
	@Given("^un client d de la banque KN existe  avec un solde initial de (\\d+.\\d+) et veut faire un depot$")
	public void un_client_d_de_la_banque_KN_existe_avec_un_solde_initial_et_de_veut_faire_un_depot(double arg1) throws Throwable{
		compte = new CompteBancaire(arg1);
		
		// Write code here that turns the phrase above into concrete actions
	  //  throw new PendingException();
	}
	
	@When("^le client d appelle la methode deposer avec en attribut un montant negatif (-\\d+.\\d)$")
	public void le_client_d_appelle_la_methode_deposer_avec_en_attribut_un_montant_negatif(double arg1) throws Throwable{
		compte.deposer(arg1);
		
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
	}
	@Then("^operation impossible msg error \"([^\"]*)\" le solde reste (\\d+.\\d+)$")
	public void operation_impossible_msg_error_le_solde_reste( String arg1,double arg2) throws Throwable{
		assertNotNull(compte);
		String msg = "impossible de deposer : le montant n'est pas suffisant pour cette operation";
		msg.equals(arg1);
		assertEquals(arg2, compte.getSolde(), 0.1);
	}
	
}
