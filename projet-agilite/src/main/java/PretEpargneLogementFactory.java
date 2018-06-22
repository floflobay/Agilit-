public class PretEpargneLogementFactory extends CreditImmobilierFactory{

    private final double montant;
    private final int duree;

    public PretEpargneLogementFactory(double montant, int duree){
        this.duree = duree;
        this.montant = montant;

    }
    @Override
    public Mensualite creeMensualite(){
        return new MensualitePretEpargneLogement(this.montant,this.duree);
    }

    @Override
    public Duree creeDuree() {
        return (Duree) new DureePretEpargneLogement(this.duree);
    }

}
