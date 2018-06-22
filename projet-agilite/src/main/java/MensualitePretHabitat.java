public class MensualitePretHabitat extends Mensualite {
    private final double montantEmprunt;
    private final double dureeEmprunt;
    final double tauxInteret = 0.25;

    public MensualitePretHabitat(double montant, int duree){
        this.dureeEmprunt = duree;
        this.montantEmprunt = montant;

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
