public class DureePretEpargneLogement extends Duree {

    private final int dureeMax = 500;
    private final int dur;


    public DureePretEpargneLogement(int du){
        this.dur = du;

    }


    @Override
    public int getDureeMax(){
        return this.dureeMax;

    }
    @Override
    public void verifieDuree(){
        if (this.dur > this.dureeMax)
            System.out.println("Durée non Acceptée");
        else
            System.out.println("Durée Acceptée");

    }
}
