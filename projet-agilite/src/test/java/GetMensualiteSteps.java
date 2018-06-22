
import static org.junit.Assert.assertEquals;


import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GetMensualiteSteps {
	
	private CreditImmobilierFactory PretHabitat;
	CreditImmobilierFactory PretEpargneLogement;
	private Mensualite mensualitePH;
	private Mensualite mensualiteEL;
	
	@Given("^un client c de la banque KN existe avec MensualitePretHabitat de montant (\\d+.\\d+) et duree (\\d+) veut consulter la mensualite$")
	public void un_client_c_de_la_banque_KN_existe_avec_MensualitePretHabitat_de_montant_et_duree_veut_consulter_la_mensualite(double arg1, Integer arg2) throws Throwable{ // Write code here that turns the phrase above into concrete actions
		PretHabitat = new PretHabitatFactory(arg1,arg2);
		//mensualitePH = PretHabitat.creeMensualite();
	}

	@When("^le client c appelle getMensualite$")
	public void le_client_c_appelle_getMensualite() throws Throwable{
		mensualitePH = PretHabitat.creeMensualite();
	    }
	
	@Then("^la mensualite est (\\d+.\\d+)$")
	public void la_mensualite_est(double arg1) throws Throwable  {  
		assertEquals(arg1, mensualitePH.getMensualite(), 0.1);
	}
	//SCENARIO 2 PRET E L
	
	@Given("^un client d de la banque KN existe avec MensualitePretEpargneLogement de montant (\\d+.\\d+) et duree (\\d+) veut consulter la mensualite$")
	public void un_client_d_de_la_banque_KN_existe_avec_MensualitePretEpargneLogement_de_montant_et_duree_veut_consulter_la_mensualite(double arg1, Integer arg2) throws Throwable{ // Write code here that turns the phrase above into concrete actions
		PretEpargneLogement = new PretEpargneLogementFactory(arg1,arg2);
	}

	@When("^le client d appelle la methode getMensualite$")
	public void le_client_d_appelle_la_methode_getMensualite() throws Throwable{
		mensualiteEL = PretEpargneLogement.creeMensualite();
	    }
	
	@Then("^la mensualite du pret est (\\d+.\\d+)$")
	public void la_mensualite_du_pret_est(double arg1) throws Throwable  {  
		assertEquals(arg1, PretEpargneLogement.creeMensualite().getMensualite(), 0.1);
	}
}
