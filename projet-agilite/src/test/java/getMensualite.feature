Feature: Verifier la mensualité du pret
	
	@tag1	
	Scenario Outline: Consulter la mensualite d'un pretimmobilier de type pret habitat
		Given un client c de la banque KN existe avec MensualitePretHabitat de montant <montantPretHabitat> et duree <dureePH> veut consulter la mensualite
		When le client c appelle getMensualite
		Then la mensualite est <mensualitePH> 
		Examples:
		|montantPretHabitat|dureePH |mensualitePH|
		|500.0             |10      |175.0       |
		
	@tag2	
	Scenario Outline: Consulter la mensualite d'un pret immobilier de type epargne logement
		Given un client d de la banque KN existe avec MensualitePretEpargneLogement de montant <montantEL> et duree <dureeEL> veut consulter la mensualite
		When le client d appelle la methode getMensualite 
		Then la mensualite du pret est <mensualiteEL> 
		Examples:
		|montantEL|dureeEL |mensualiteEL     |
		|600.0    |12      |140.0|