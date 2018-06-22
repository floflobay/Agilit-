Feature: Creer un compte bancaire
	
	@tag1
	Scenario Outline: Creer un compte bancaire vide  avec le constructeur par defaut
		Given le gestionnaire veut creer un compte et la banque KN peut utiliser un constructeur de compte"
		When j appelle la methode CompteBancaire
		Then un compte est cree avec le <soldei> .
		
		Examples:
		|soldei |
		|20.0     |
	@tag2	
	Scenario Outline: Creer un compte bancaire avec un solde initial
		Given le gestionnaire veut creer un compte avec le solde desire positif
		When j appelle la methode CompteBancaire avec montant initial <montant>
		Then le nouveau compte a un solde <solde> euros.
		
		Examples:
		|montant |solde |
		|20.0	 |20.0    |
		|30.0 	 |30.0    |
			
	@tag3	
	Scenario Outline: Creer un compte bancaire avec un solde initial negatif
		Given le gestionnaire veut creer un compte avec un solde negatif
		When j appelle la methode CompteBancaire avec montant negatif <montant>
		Then le compte ne peut pas etre cree ERROR <msgError>
		
		Examples:
		|montant |msgError                                             |
		|-20.0	 |"impossible de creer un compte avec un solde neagtif"|