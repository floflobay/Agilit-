
import static org.junit.Assert.*;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="")
public class AppartementTest2 {
	 Piece chambre = new Piece();
	 Piece salon;
	 AppartementPersonnel monAppart = new AppartementPersonnel();
	 Piece p = new Piece();
	 
/*	@Before
	public void setUp() throws Exception {
		p = new Piece();
		chambre = new Piece("chambre", 12.0,monAppart);
		salon = new Piece("salon", 27.0,monAppart);
		monAppart = new AppartementPersonnel("22 rue de washington 75008");
		monAppart.addPiece(chambre);
		monAppart.addPiece(salon);
	}

	@Test
	public void test() {
		
		assertEquals(monAppart.getPiece(0),chambre);
		assertEquals(monAppart.prixAppart(10.0),390.0,0.1);
		verifierAssociation();
	}*/

	public void construireNomPieceTest(String nom){
		p.setNomPiece(nom);
	}

	public String RetournerNomPiece(){
		return p.getNomPiece();
	}
	
	private void verifierAssociation() {
		assertEquals(chambre.getAppartement().getAdresse(),monAppart.getAdresse());
	}

}
