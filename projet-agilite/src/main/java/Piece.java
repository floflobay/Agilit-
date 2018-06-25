
public class Piece
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private double surface;
    private String nomPiece;
    private AppartementPersonnel appMeContient;
    /**
     * Constructeur d'objets de classe Piece
     */
    public Piece()
    {
        // initialisation des variables d'instance
        surface = 0.0;
        nomPiece = "";
        
    }
     public Piece(String nom, double taille,AppartementPersonnel app)
    {
        // initialisation des variables d'instance
        surface = taille;
        nomPiece = nom;
        appMeContient = app;
    }
    public void setNomPiece(String nomPiece){
        this.nomPiece = nomPiece;
    }

    public void setSurface(double surface){
        this.surface = surface;
    }
    public double getSurface(){
        return surface;
    }
    public void setAppartement(AppartementPersonnel app){
    	appMeContient = app;
    }
    public String getNomPiece(){
        return nomPiece;
    }
    public AppartementPersonnel getAppartement(){
    	return appMeContient;
    }
    /**
     * un exemple de méthode qui te permet de calculer le prix d'une pièce
     */
 
    public double prixPiece(double prixM2)
    {
        return this.getSurface()*prixM2;
    }
    
    public boolean equals(Object obj){
        if(obj instanceof Piece){
            Piece p = (Piece)obj;
            return (p.getSurface()==surface && p.getNomPiece()==nomPiece);
        }
        return false; 
    }
     public String toString() {
		// TODO Auto-generated method stub
    	 return "La piece : "+ nomPiece +"fait :"+ surface +" m2 et coûte à elle seule " + this.prixPiece(appMeContient.prixM2);
		
	}
}
