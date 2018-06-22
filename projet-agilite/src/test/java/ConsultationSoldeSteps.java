import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;

/**
 * @author Kakama & Noufissa
 *
 */

public class ConsultationSoldeSteps {


	private CompteBancaire compte;
	
	

	@Given("^un client de la banque KN possede un compte bancaire avec un solde (\\d+.\\d+)$")
	public void un_client_de_la_banque_KN_possede_un_compte_bancaire_avec_un_solde(double arg1) throws Throwable{
		compte = new CompteBancaire(arg1);
	
	}

	@When("^le client appelle la methode getSolde$")
	public void le_client_appelle_la_methode_getSolde () throws Throwable{
		assertNotNull(compte);
		compte.getSolde();
	
	}

	@Then("^le solde du compte du client est bien egale a (\\d+.\\d+)$")
	public void le_solde_du_compte_du_client_est_bien_egale_a(double arg1) throws Throwable{
		assertEquals(arg1, compte.getSolde(), 0.1);
	}
	
}
