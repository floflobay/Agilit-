public class MensualitePretEpargneLogement extends Mensualite{

    private final double montantEmprunt;
    private final double dureeEmprunt;
    final double tauxInteret = 0.025;

    public MensualitePretEpargneLogement(double montant, int duree){
        this.dureeEmprunt = duree;
        this.montantEmprunt = montant;

    }
    public double getDureeEmprunt() {
		return dureeEmprunt;
	}
    public double getMontantEmprunt() {
		return montantEmprunt;
	}  


    @Override
    public double getTauxDinteret(){
        return this.tauxInteret;

    }
    @Override
	public double getMensualite(){
        return ((this.montantEmprunt *(1+(this.tauxInteret*this.dureeEmprunt)))/this.dureeEmprunt);
        
    }

}
