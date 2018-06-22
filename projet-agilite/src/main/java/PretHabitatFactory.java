public class PretHabitatFactory extends CreditImmobilierFactory {

    private final double montant;
    private final int duree;

    public PretHabitatFactory(double montant, int duree){
        this.duree = duree;
        this.montant = montant;

    }

    @Override
    public Mensualite creeMensualite(){
        return new MensualitePretHabitat(this.montant,this.duree);
    }


    @Override
    public Duree creeDuree() {
        return new DureePretHabitat(this.duree);
    }

}
