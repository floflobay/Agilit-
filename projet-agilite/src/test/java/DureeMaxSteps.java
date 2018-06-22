
import static org.junit.Assert.assertEquals;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DureeMaxSteps {

	
	private CreditImmobilierFactory PretHabitat;
	private CreditImmobilierFactory PretEpargneLogement;
	private Duree dureeH;
	private Duree dureeEL;
	
	@Given("^un client c de la banque KN existe avec pretHabitat de montant (\\d+.\\d+) et duree (\\d+) veut consulter la duree max$")
	public void un_client_c_de_la_banque_KN_existe_avec_pretHabitat_de_montant_et_duree_veut_consulter_la_duree_max(double arg1, Integer arg2) throws Throwable{ // Write code here that turns the phrase above into concrete actions
		PretHabitat = new PretHabitatFactory(arg1,arg2);
		//mensualitePH = PretHabitat.creeMensualite();
	}

	@When("^le client c appelle creeDuree$")
	public void le_client_c_appelle_creeDuree() throws Throwable{
		dureeH =  PretHabitat.creeDuree();
	}
	
	@Then("^la duree max est (\\d+.\\d+)$")
	public void la_duree_max_est(double arg1) throws Throwable  {  
		assertEquals(arg1, dureeH.getDureeMax(), 0.1);
	}
	//Scenario 2  E L 
	
	@Given("^un client d existe avec pretEpargneLogement de montant (\\d+.\\d+) et duree (\\d+) veut consulter la duree max$")
	public void un_client_d_existe_avec_pretEpargneLogement_de_montant_et_duree_veut_consulter_la_duree_max(double arg1, Integer arg2) throws Throwable{ // Write code here that turns the phrase above into concrete actions
		PretEpargneLogement = new PretEpargneLogementFactory(arg1,arg2);
		//mensualitePH = PretHabitat.creeMensualite();
	}

	@When("^le client appelle creeDuree$")
	public void le_client_appelle_creeDuree() throws Throwable{
		dureeEL =  PretEpargneLogement.creeDuree();
	}
	
	@Then("^la duree maximale permise est (\\d+.\\d+)$")
	public void la_duree_maximale_permise_est(double arg1) throws Throwable  {  
		assertEquals(arg1, dureeEL.getDureeMax(), 0.1);
	}
}
