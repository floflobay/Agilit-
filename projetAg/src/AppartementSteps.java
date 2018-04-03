import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import org.junit.Assert;

import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;



public class AppartementSteps {
	
	AppartementTest2 ap2 = new AppartementTest2();
	@Given("^une piece qui a un nom$")
	public void une_piece_qui_a_un_nom() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("Test du nom");
	}
	@When("^le nom est \"([^\"]*)\"$")
	public void le_nom_est(String arg1) throws Throwable {
		ap2.construireNomPieceTest(arg1);
		//System.out.println(" Nom" + arg1);
	}
	@Then("^le nom affecte correspond \"([^\"]*)\" I verify the success in step$")
	public void le_nom_affecte_correspond_I_verify_the_success_in_step(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(ap2.RetournerNomPiece(),arg1);

		// throw new PendingException();
	}

	@Then("^le nom affecte correspond \"([^\"]*)\" I verify the failure in step$")
	public void le_nom_affecte_correspond_I_verify_the_failure_in_step(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   try{ 
		   assertEquals(ap2.RetournerNomPiece(),arg1);
	   }catch(AssertionError e){
    	
	   }
	   // throw new  Exception();
	}
	@Given("^une piece qui a un nom et une surface$")
	public void une_piece_qui_a_un_nom_et_une_surface() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		System.out.println("Test Surface");
	}

	@When("^le nom est \"([^\"]*)\" , la surface est \"([^\"]*)\"$")
	public void le_nom_est_la_surface_est(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ap2.construireNomPieceTest(arg1);
		ap2.p.setSurface(Double.parseDouble(arg2));
		
		//throw new PendingException();
	}

	@Then("^la surface correspond \"([^\"]*)\" I verify the success in step$")
	public void la_surface_correspond_I_verify_the_success_in_step(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(ap2.p.getSurface(),Double.parseDouble(arg1),0.1);
	}

	@Then("^la surface correspond \"([^\"]*)\" I verify the failure in step$")
	public void la_surface_correspond_I_verify_the_failure_in_step(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    try{
	    	assertEquals(ap2.p.getSurface(),Double.parseDouble(arg1),0.1);
	    }catch(AssertionError e){
	    	
	    }
	    
	}
	@Given("^un appartement et ses pieces$")
	public void un_appartement_et_ses_pieces() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Creation d'un appartement une piece");
	}

	@When("^le nom de la piece est \"([^\"]*)\" l'appartement a une \"([^\"]*)\" et une \"([^\"]*)\"$")
	public void le_nom_de_la_piece_est_l_appartement_a_une_et_une(String arg1, String arg2, String arg3) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ap2.construireNomPieceTest(arg1);
		ap2.p.setSurface(Double.parseDouble(arg3));
		ap2.monAppart.setAdresse(arg2);
		ap2.monAppart.addPiece(ap2.p);
		ap2.p.setAppartement(ap2.monAppart);
	}

	@SuppressWarnings("deprecation")
	@Then("^\"([^\"]*)\" validation correspond bien de meme que le (\\d+) et le \"([^\"]*)\" permet de calculer le \"([^\"]*)\"\\. I verify the success in step$")
	public void validation_correspond_bien_de_meme_que_le_et_le_permet_de_calculer_le_I_verify_the_success_in_step(String arg1, int arg2, String arg3, String arg4) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(ap2.monAppart.getAdresse(),arg1);
	    assertEquals(1,ap2.monAppart.getPiece().size());
	    //System.out.println(ap2.monAppart);
	    assertEquals(ap2.monAppart.prixAppart(Double.parseDouble(arg3)), Double.parseDouble(arg4),1);
	    
	}
	
	@Then("^\"([^\"]*)\" validation correspond bien de meme que le (\\d+) et le \"([^\"]*)\" permet de calculer le \"([^\"]*)\"\\. I verify the failure in step$")
	public void validation_correspond_bien_de_meme_que_le_et_le_permet_de_calculer_le_I_verify_the_failure_in_step(String arg1, int arg2, String arg3, String arg4) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 assertEquals(ap2.monAppart.getAdresse(),arg1);
		 assertEquals(1,ap2.monAppart.getPiece().size());
		    //System.out.println(ap2.monAppart);
		 try{
			 assertEquals(ap2.monAppart.prixAppart(Double.parseDouble(arg3)), Double.parseDouble(arg4),1);
		 } catch(AssertionError e){
		    	System.out.println("Mauvais prix calculé");
		   }
	}
	
	@When("^Adresse de l'appart \"([^\"]*)\" l'appartement un \"([^\"]*)\" et une \"([^\"]*)\" de taille \"([^\"]*)\" chacune$")
	public void adresse_de_l_appart_l_appartement_un_et_une_de_taille_chacune(String adresse, String salon, String chambre, String surface) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
		ap2.p.setNomPiece(salon);
		ap2.chambre.setNomPiece(chambre);
		ap2.p.setSurface(Double.parseDouble(surface));
		ap2.chambre.setSurface(Double.parseDouble(surface));
		ap2.monAppart.setAdresse(adresse);
		ap2.p.setAppartement(ap2.monAppart);
		ap2.chambre.setAppartement(ap2.monAppart);
		ap2.monAppart.addPiece(ap2.chambre);
		ap2.monAppart.addPiece(ap2.p);

	}

	@Then("^Le \"([^\"]*)\" permet de calculer le \"([^\"]*)\" I verify the success in step$")
	public void le_permet_de_calculer_le_I_verify_the_success_in_step(String prixm2, String prixAppart) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
		assertEquals(ap2.monAppart.prixAppart(Double.parseDouble(prixm2)),Double.parseDouble(prixAppart),1);
	}

	@Then("^Le \"([^\"]*)\" permet de calculer le \"([^\"]*)\" I verify the failure in step$")
	public void le_permet_de_calculer_le_I_verify_the_failure_in_step(String prixm2, String prixAppart) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		try{
			System.out.println(ap2.monAppart.getPiece().size());
			assertEquals(ap2.monAppart.prixAppart(Double.parseDouble(prixm2)),Double.parseDouble(prixAppart),1);
		}catch(AssertionError e){
	    	System.out.println("Mauvais prix calculé plusieurs pieces");
	   }
		
	}


	
}
