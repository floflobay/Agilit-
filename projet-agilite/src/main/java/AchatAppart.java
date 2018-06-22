class AchatAppart implements IVisiteur
{
        public double visit(AppartementPersonnel o,double prixM2) 
        {      
               return o.prixAppart(prixM2);
        }
 
        public double visit(Personne o) 
        {
               return visit(o.getCompte());
        }

        public double visit(CompteBancaire o) 
        {
                return o.getSolde() ;
        }

		public double visit(IVisitable o) {
			// TODO Auto-generated method stub
			return 0;
		}
		public static void achatAppart(AppartementPersonnel ap,Personne p, int duree){
			System.out.println("Vous voulez acheter l'apprtement suivant sur " + duree +" mensualités");
			System.out.println(ap);
			System.out.println("Vous etes : " + p);
			
			/*
			 * va nous donner les différentes mensualités d'un pret pour l'achat d'un appartement 
			 */
			AchatAppart visitor = new AchatAppart();
			double montantAppart =  ap.accept(visitor);
			double SoldeCompte =  p.accept(visitor);
			/*
			 * simulation de crédits
			 * 
			 */
			double mpret = montantAppart - SoldeCompte;
			System.out.println(" Votre pret sera de "+  mpret + " euros" );
			CreditImmobilierFactory PretEpargneLogement = new PretEpargneLogementFactory(mpret,duree);
		    CreditImmobilierFactory PretHabitat = new PretHabitatFactory(mpret,duree);

		    Mensualite mensualite;
		    Mensualite mensualite2;
		    Duree d;
		    Duree d2;
		    double tarifMensualite;
		    double tarifMensualite2;

		    System.out.println("Simulation pour un credit Pret Habitat");

		    mensualite = PretHabitat.creeMensualite();
		    d = PretHabitat.creeDuree();
		    d.verifieDuree();
		    System.out.println(" votre taux d'interet est de "  +mensualite.getTauxDinteret());
		    tarifMensualite = mensualite.getMensualite();
		    System.out.println("Le tarif de votre mensualite sera de :" + tarifMensualite);

		    System.out.println("Simulation pour un credit Epargne Logement");

		    mensualite2 = PretEpargneLogement.creeMensualite();
		    d2 = PretEpargneLogement.creeDuree();
		    d2.verifieDuree();
		    System.out.println(" votre taux d'interet est de " + mensualite2.getTauxDinteret());
		    tarifMensualite2 = mensualite2.getMensualite();
		    System.out.println("Le tarif de votre mensualite sera de :" +PretEpargneLogement.creeMensualite().getMensualite());
		}
		/*Dans le main : 
		 * AchatAppart visitor = new AchatAppart();
    	 * Personnne p = new Personne();
    	 * CompteBancaire c = new CompteBancaire()
    	 * associer le compte a la personne
    	 * AppartementPersonnel ap = new AppartementPersonnel();
    	 *  if( p.accept(visitor) > ap.accept(visitor)){
    	 *  Achat de l'appartement car on a assez d'argent 
    	 *  }else{
    	 *  sysout(" Argent manquant , faites un pret") 
    	 *  }
		 * /
		 */
		public static void main(String[] args) {
			Personne p = new Personne("jean","seguin",30);
			CompteBancaire c = new CompteBancaire();
			p.setCompte(c);
			c.invokPersonne(p);
			System.out.println(p);
			c.deposer(1000.0);
			System.out.println(p);
			AppartementPersonnel ap = new AppartementPersonnel("55 av mozart 75016" , 100.0);
			Piece studio = new Piece("studio", 15.0, ap);
			ap.addPiece(studio);
			System.out.println(ap);
			achatAppart(ap,p,10);
		}
}