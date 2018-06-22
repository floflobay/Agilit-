
import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VerifDureeSteps {

	private CreditImmobilierFactory PretHabitat;
	private CreditImmobilierFactory PretEpargneLogement;
	private Duree dureeH;
	private Duree dureeEL;
	
	@Given("^un client c de la banque KN existe avec pretHabitat de montant (\\d+.\\d+) et duree (\\d+)$")
	public void un_client_c_de_la_banque_KN_existe_avec_pretHabitat_de_montant_et_duree(double arg1, Integer arg2) throws Throwable{ // Write code here that turns the phrase above into concrete actions
		PretHabitat = new PretHabitatFactory(arg1,arg2);
		//mensualitePH = PretHabitat.creeMensualite();
	}

	@When("^il appelle creeDuree$")
	public void il_appelle_creeDuree() throws Throwable{
		dureeH =  PretHabitat.creeDuree();
	}
	
	@Then("^si la duree demandee (\\d+) est inferieure a duree max alors la demande est acceptee avec le message \"([^\"]*)\"$")
	public void si_la_duree_demandee_est_inferieure_a_duree_max_alors_la_demande_est_acceptee_avec_le_message (Integer arg1, String arg2) throws Throwable  {  
		if (arg1 < dureeH.getDureeMax() ) {
			arg2.equals("Durée Acceptée");
		}

	}
	//Scenario 2 pret habitat refusé
	
	@Given("^un client d veut un pretHabitat de montant (\\d+.\\d+) et duree (\\d+)$")
	public void un_client_d_veut_un_pretHabitat_de_montant_et_duree(double arg1, Integer arg2) throws Throwable{ // Write code here that turns the phrase above into concrete actions
		PretHabitat = new PretHabitatFactory(arg1,arg2);
		//mensualitePH = PretHabitat.creeMensualite();
	}

	@When("^il appelle la methode creeDuree$")
	public void il_appelle_la_methode_creeDuree() throws Throwable{
		dureeH =  PretHabitat.creeDuree();
	}
	
	@Then("^si la duree demandee (\\d+) est superieure a duree max alors la demande est refusee avec le message \"([^\"]*)\"$")
	public void si_la_duree_demandee_est_superieure_a_duree_max_alors_la_demande_est_refusee_avec_le_message(Integer arg1, String arg2) throws Throwable  {
		if (arg1 < dureeH.getDureeMax() ) {
			arg2.equals("Durée non Acceptée");
		}
	}
	// scenario 3 
	
	@Given("^un client claude de la banque KN existe avec pretEpargneLogement de montant (\\d+.\\d+) et duree (\\d+)$")
	public void un_client_claude_de_la_banque_KN_existe_avec_pretEpargneLogement_de_montant_et_duree(double arg1, Integer arg2) throws Throwable{ // Write code here that turns the phrase above into concrete actions
		PretEpargneLogement = new PretEpargneLogementFactory(arg1,arg2);
		//mensualitePH = PretHabitat.creeMensualite();
	}

	@When("^claude appelle creeDuree$")
	public void claude_appelle_creeDuree() throws Throwable{
		dureeEL =  PretEpargneLogement.creeDuree();
	}
	
	@Then("^si la duree demandee par claude (\\d+) est inferieure a duree max alors la demande est acceptee avec le message \"([^\"]*)\"$")
	public void si_la_duree_demandee_par_claude_est_inferieure_a_duree_max_alors_la_demande_est_acceptee_avec_le_message (Integer arg1, String arg2) throws Throwable  {  
		if (arg1 < dureeEL.getDureeMax() ) {
			arg2.equals("Durée Acceptée");
		}
	}
	// scenario 4
	
	@Given("^un client daniel veut un pretEpargneLogement de montant (\\d+.\\d+) et duree (\\d+)$")
	public void un_client_daniel_veut_un_pretEpargneLogement_de_montant_et_duree(double arg1, Integer arg2) throws Throwable{ // Write code here that turns the phrase above into concrete actions
		PretEpargneLogement = new PretEpargneLogementFactory(arg1,arg2);
		//mensualitePH = PretHabitat.creeMensualite();
	}

	@When("^daniel appelle la methode creeDuree$")
	public void daniel_appelle_la_methode_creeDuree() throws Throwable{
		dureeEL =  PretEpargneLogement.creeDuree();
	}
	
	@Then("^si la duree demandee par daniel (\\d+) est superieure a duree max alors la demande est refusee avec le message \"([^\"]*)\"$")
	public void si_la_duree_demandee_par_daniel_est_superieure_a_duree_max_alors_la_demande_est_refusee_avec_le_message(Integer arg1, String arg2) throws Throwable  {
		if (arg1 < dureeEL.getDureeMax() ) {
			arg2.equals("Durée non Acceptée");
		}
	}
}
