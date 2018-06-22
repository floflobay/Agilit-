import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;

/**
 * @author I83977
 *
 */
public class CompteCreationSteps {
	private CompteBancaire compte;
	private CompteBancaire compte2;
	private Personne proprietaire;
	private boolean sucess;
	

//	public CompteCreationSteps(Listener listener) {
//		super(listener);
//		// TODO Auto-generated constructor stub
//	}

	@Given("^le gestionnaire veut creer un compte et la banque KN peut utiliser un constructeur de compte\"$")
	public void le_gestionnaire_veut_creer_un_compte_et_la_banque_KN_peut_utiliser_un_constructeur_de_compte() throws Throwable{
	}

	@When("^j appelle la methode CompteBancaire$")
	public void j_appelle_la_methode_CompteBancaire () throws Throwable{
		compte = new CompteBancaire();
	}

	@Then("^un compte est cree avec le (\\d+.\\d) \\.$")
	public void un_compte_est_cree_avec_le_solde(double arg1) throws Throwable{
		assertNotNull(compte);
	}

	@Given("^le gestionnaire veut creer un compte avec le solde desire positif$")
	public void le_gestionnaire_veut_creer_un_compte_avec_le_solde_desire_positif() throws Throwable {
	    
	}

	@When("^j appelle la methode CompteBancaire avec montant initial (\\d+.\\d)$")
	public void j_appelle_la_methode_CompteBancaire_avec_montant_initial(double arg1) throws Throwable{
		compte = new CompteBancaire(arg1);
	}

	@Then("^le nouveau compte a un solde (\\d+.\\d) euros\\.$")
	public void le_nouveau_compte_a_un_solde(double arg1) throws Throwable{
		assertEquals(arg1, compte.getSolde(), 0.1);
	
	}
	@Given("^le gestionnaire veut creer un compte avec un solde negatif$")
	public void le_gestionnaire_veut_creer_un_compte_avec_un_solde_negatif() throws Throwable {
	    	
	}

	@When("^j appelle la methode CompteBancaire avec montant negatif (-\\d+.\\d)$")
	public void j_appelle_la_methode_CompteBancaire_avec_montant_negatif (double arg1) throws Throwable{
		compte = new CompteBancaire(arg1);
	
	}

	@Then("^le compte ne peut pas etre cree ERROR \"([^\"]*)\"$")
	public void le_compte_ne_peut_pas_etre_cree_ERROR (String arg1) throws Throwable{
		String msg = "impossible de creer un compte avec un solde neagtif";
		msg.equals(arg1);
	}

}
