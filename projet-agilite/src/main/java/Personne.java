

import java.util.*;
public class Personne implements IVisitable{

	private String nom;
	private String prenom;
	private int age;
	private CompteBancaire compte;

	public Personne() {

	}
	public Personne(String nom, String prenom,int age) {
		this.nom = nom;
		this.age =age;
		this.prenom = prenom;
	}
	public void invokCompteBancaire(CompteBancaire c) {
		this.compte = c;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public CompteBancaire getCompte() {
		return compte;
	}
	public void setCompte(CompteBancaire compte) {
		this.compte = compte;
	}
	public double accept(IVisiteur visitor) {
		// TODO Auto-generated method stub
		return visitor.visit(this);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nom + " " + prenom + " " + age +" solde du compte : " +  compte.getSolde();
	}
	
}
