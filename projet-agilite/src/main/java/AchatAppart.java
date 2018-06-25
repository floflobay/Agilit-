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
		public static void achatAppart(AppartementPersonnel ap,Personne p, int dureeH, int dureePEL){
			System.out.println("Vous voulez acheter l'apprtement suivant sur " + dureeH +" mensualités pour un prêt Habitat\n et "+ dureePEL + " mensualités pour un prêt épargne logement\n");
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
			CreditImmobilierFactory PretEpargneLogement = new PretEpargneLogementFactory(mpret,dureePEL);
		    CreditImmobilierFactory PretHabitat = new PretHabitatFactory(mpret,dureeH);

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
			System.out.println(" Votre pret sera de "+  mpret + " euros" );

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
			Personne p = new Personne("Martin","Martinez",35);
			CompteBancaire c = new CompteBancaire();
			p.setCompte(c);
			c.invokPersonne(p);
			System.out.println(p);
			c.deposer(800000.0);
			System.out.println(p);
			AppartementPersonnel ap = new AppartementPersonnel("1 rue du bonheur 75016" , 10000.0);
			Piece p1 = new Piece("chambreJaune", 25.0, ap);
			Piece p2 = new Piece("chmabreRose", 25.0, ap);
			Piece p3 = new Piece("chambreBleue", 25.0, ap);
			Piece p4 = new Piece("chambreRouge", 25.0, ap);
			ap.addPiece(p1);
			ap.addPiece(p2);
			ap.addPiece(p3);
			ap.addPiece(p4);
			System.out.println(ap);
			achatAppart(ap,p,300,500);
		}
}