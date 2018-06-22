Feature: Consulter le solde d'un compte
	
	@tag1	
	Scenario Outline: Consulter le solde d'un compte existant
		Given un client de la banque KN possede un compte bancaire avec un solde <mysolde>
		When le client appelle la methode getSolde
		Then le solde du compte du client est bien egale a <solde>
		Examples:
		|mysolde|solde|
		|20.0     |20.0   |
		|0.0      |0.0    |
		|9.5      |9.5    |