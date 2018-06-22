Feature: Afficher les informations sur le titulaire d'un compte
	
	@tag1	
	Scenario Outline: afficher le nom du titulaire d'un compte
		Given le gestionnaire consulte un compte bancaire client et appelle la methode getPersonne puis invokePersonne
		When le gestionnaire appelle la methode getNom
		Then le <nom> du titulaire du compte est affiche
		Examples:
		|nom   |
		|"SALL"|
		
	@tag2	
	Scenario Outline: afficher le prenom du titulaire d'un compte
		Given le gestionnaire appelle la methode invokePersonne
		When le gestionnaire appelle getPrenom
		Then le <prenom> du titulaire du compte est affiche
		Examples:
		|prenom|
		|"Nouf"|
	@tag3
	Scenario Outline: afficher le prenom du titulaire d'un compte
		Given le gestionnaire appelle getProprietaire et invokePersonne
		When le gestionnaire appelle getAge
		Then le <age> du titulaire du compte est affiche
		Examples:
		|age|
		|22 |