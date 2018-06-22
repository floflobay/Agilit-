public class DureePretHabitat extends Duree {

    private final int dureeMax = 300;
    private final int duree;


    public DureePretHabitat(int duree){
        this.duree = duree;


    }


    @Override
    public int getDureeMax(){
        return this.dureeMax;

    }
    @Override
    public void verifieDuree(){
        if (this.duree > this.dureeMax)
            System.out.println("Durée non Acceptée");
        else
            System.out.println("Durée Acceptée");

    }
}
