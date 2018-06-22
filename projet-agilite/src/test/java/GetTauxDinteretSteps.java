
import static org.junit.Assert.assertEquals;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GetTauxDinteretSteps {
	private CreditImmobilierFactory PretHabitat;
	CreditImmobilierFactory PretEpargneLogement;
	private Mensualite mensualitePH;
	private Mensualite mensualiteEL;
	
	@Given("^un client c de la banque KN existe avec MensualitePretHabitat de montant (\\d+.\\d+) et duree (\\d+) veut consulter le taux du pret$")
	public void un_client_c_de_la_banque_KN_existe_avec_MensualitePretHabitat_de_montant_et_duree_veut_consulter_le_taux_du_pret(double arg1, Integer arg2) throws Throwable{ // Write code here that turns the phrase above into concrete actions
		PretHabitat = new PretHabitatFactory(arg1,arg2);
		mensualitePH = PretHabitat.creeMensualite();
	}

	@When("^le client c appelle getTauxDinteret$")
	public void le_client_c_appelle_getTauxDinteret() throws Throwable{
		mensualitePH = PretHabitat.creeMensualite();
	    }
	
	@Then("^le taux est (\\d+.\\d+)$")
	public void la_taux_est(double arg1) throws Throwable  {  
		assertEquals(arg1, mensualitePH.getTauxDinteret(), 0.1);
	}
	//Scenario 2 Pret Epargne Logement
	
	@Given("^un client d de la banque KN existe avec MensualitePretEpargneLogement de montant (\\d+.\\d+) et duree (\\d+) veut consulter le taux du pret$")
	public void un_client_d_de_la_banque_KN_existe_avec_MensualitePretEpargneLogement_de_montant_et_duree_veut_consulter_le_taux_du_pret(double arg1, Integer arg2) throws Throwable{ // Write code here that turns the phrase above into concrete actions
		PretEpargneLogement = new PretHabitatFactory(arg1,arg2);
		//mensualiteEL = PretHabitat.creeMensualite();
	}

	@When("^le client d appelle la methode getTauxDinteret$")
	public void le_client_d_appelle_la_methode_getTauxDinteret() throws Throwable{
		 mensualiteEL = PretEpargneLogement.creeMensualite();
	 }
	
	@Then("^le taux du pret epargne logement est (\\d+.\\d+)$")
	public void le_taux_du_pret_epargne_logement_est(double arg1) throws Throwable  {  
		assertEquals(arg1, mensualiteEL.getTauxDinteret(), 0.1);
	}
}
