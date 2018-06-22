import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;  
import cucumber.api.java.en.Then;  
import cucumber.api.java.en.When;
import gherkin.lexer.En;
import gherkin.lexer.Listener; 

/**
 * @author Kakama & noufissa
 *
 */
public class InfoTitulaireCompteSteps {
	private CompteBancaire compte;
	private Personne proprietaire;
	private String nom;
	private String prenom;
	private int age;
	
	@Given("^le gestionnaire consulte un compte bancaire client et appelle la methode getPersonne puis invokePersonne$")
	public void le_gestionnaire_consulte_un_compte_bancaire_client_et_appelle_la_methode_getPersonne_puis_invokePersonne() throws Throwable{
		compte= new CompteBancaire();
		compte.invokPersonne(new Personne("SALL","sall",22));
		proprietaire = compte.getProprietaire();
	}

	@When("^le gestionnaire appelle la methode getNom$")
	public void le_gestionnaire_appelle_la_methode_getNom () throws Throwable{
		nom = proprietaire.getNom();//compte = new CompteBancaire();
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
	}

	@Then("^le \"([^\"]*)\" du titulaire du compte est affiche$")
	public void le_du_titulaire_du_compte_est_affiche (String arg1) throws Throwable{
		arg1.equals(nom);
		// Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}
	
	@Given("^le gestionnaire appelle la methode invokePersonne$")
	public void le_gestionnaire_appelle_la_methode_invokePersonne() throws Throwable{
		compte= new CompteBancaire();
		compte.invokPersonne(new Personne("Bencherif","Nouf",22));
		proprietaire = compte.getProprietaire();
	}

	@When("^le gestionnaire appelle getPrenom$")
	public void  le_gestionnaire_appelle_getPrenom() throws Throwable{
		prenom = proprietaire.getPrenom();//arg1= 20;
		//compte = new CompteBancaire(arg1);
		//compte2 = new CompteBancaire(arg2);
		
		// Write code here that turns the phrase above into concrete actions
	}
	
	@Then("^le \"([^\"]*)\" du titulaire du compte est affiche maintenant$")
	public void le_du_titulaire_du_compte_est_affiche_maintenant(String arg1) throws Throwable{
		arg1.equals(prenom);

	}
	@Given("^le gestionnaire appelle getProprietaire et invokePersonne$")
	public void le_gestionnaire_appelle_getProprietaire_et_invokePersonne() throws Throwable{
		compte= new CompteBancaire();
		compte.invokPersonne(new Personne("Bencherif","Nouf",22));
		proprietaire = compte.getProprietaire();
	}

	@When("^le gestionnaire appelle getAge$")
	public void  le_gestionnaire_appelle_getAge() throws Throwable{
		age = proprietaire.getAge();//arg1= 20;
		//compte = new CompteBancaire(arg1);
		//compte2 = new CompteBancaire(arg2);
		
		// Write code here that turns the phrase above into concrete actions
	}
	
	@Then("^le (\\d+) du titulaire du compte est affiche$")
	public void le_du_titulaire_du_compte_est_affichee(int arg1) throws Throwable{
		assertEquals(arg1, age);
		//assertEquals(arg1, compte.getSolde(), 0.1);
		//assertEquals(arg2, compte.getSolde(), 0.1);
		
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}
	
	
}
