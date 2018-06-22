import java.util.ArrayList;
import java.util.List;

/**
 * Décrivez votre classe Proprietaire ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class AppartementPersonnel implements IVisitable
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private String adresse ; 
    private ArrayList<Piece> mesPieces =  new ArrayList<Piece>();
    double prixM2 = 1.0;
    /**
     * Constructeur d'objets de classe Proprietaire
     */
    public AppartementPersonnel()
    {
         adresse = "";
    }
    public AppartementPersonnel(String adresse)
    {
         this.adresse = adresse;
    }
    public AppartementPersonnel(String adresse,double prixM)
    {
         this.adresse = adresse;
         this.prixM2 = prixM;
    }
    public String getAdresse(){
        return adresse;
    }
    public List<Piece> getPiece(){
        return mesPieces;
    }
    public Piece getPiece(int i){
        return mesPieces.get(i);
    }
    public void setAdresse(String a){
        adresse = a;
    }
    public void addPiece(Piece p){
        mesPieces.add(p);
        p.setAppartement(this);
    }
    /**
     * methode permettant d afficher le prix et une adresse pour notre appartement en donnant
     * le prix au m2
     * 
     */
    public double prixAppart(double prix)
    { double somme = 0.0;
        // Insérez votre code ici
    	for(Piece p : mesPieces){
    		somme +=p.prixPiece(prix) ;
    	}
       return somme;
    }
	public double accept(IVisiteur visitor) {
		// TODO doubleAuto-generated method stub
		return visitor.visit(this,prixM2);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return " Votre appartement de " +  mesPieces.size() + " pieces au " + adresse + " vaut : " + this.prixAppart(prixM2);
	}
}
