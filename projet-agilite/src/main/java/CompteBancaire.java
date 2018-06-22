
import java.util.*;

public class CompteBancaire implements IVisitable{
	private double solde;
	private Personne proprietaire;
	private int idCompte = 0;
	
	
	public CompteBancaire() {
		idCompte = idCompte + 1;
		solde = 0;
	}
	public CompteBancaire(double solde) {
		this.solde = solde;
		idCompte++;
	}
	public void invokPersonne(Personne p) {
		this.proprietaire = p;
	}
	public double getSolde() {
		return this.solde;
	}
	public int getIdCompte() {
		return this.idCompte;
	}
	public Personne getProprietaire() {
		return this.proprietaire;
	}
	public void deposer( double montant) {
		if (montant <=0 ) {
				System.out.println("impossible de deposer : le montant n'est pas suffisant pour cette operation");
		}else {
				this.solde = this.solde+montant;
				System.out.println("Vous venez de deposer le montant " + montant+ " sur votre compte");
		}
	}
	public void retirer(double montant){
		if (montant >=0 ) {
			if(solde <= 0 ) {
				System.out.println("impossible de retirer : votre solde est insuffisant pour cette operation");
			}else {
				this.solde = this.solde-montant;
				System.out.println("Vous venez de retirer le montant " + montant+ " de votre compte");
			}
		}else{
			System.out.println("impossible de retirer un montant négatif; opération refusée");
		}
	}
	public double accept(IVisiteur visitor) {
		// TODO Auto-generated method stub
		return visitor.visit(this);
	}
	
}
