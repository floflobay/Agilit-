Feature: Verifier le taux d interet du pret
	
	@tag1	
	Scenario Outline: Consulter le taux d'interet d'un pretimmobilier de typepret habitat
		Given un client c de la banque KN existe avec MensualitePretHabitat de montant <montantPretHabitat> et duree <duretPH> veut consulter le taux du pret
		When le client c appelle getTauxDinteret 
		Then le taux est <tauxPH> 
		Examples:
		|montantPretHabitat|duretPH |tauxPH|
		|500                |10     |0.25  |
		
	@tag2	
	Scenario Outline: Consulter le taux d'interet d'un pretimmobilier de type epargne logement
		Given un client d de la banque KN existe avec MensualitePretEpargneLogement de montant <montantEL> et duree <duretEL> veut consulter le taux du pret
		When le client d appelle la methode getTauxDinteret 
		Then le taux du pret epargne logement est <tauxEL> 
		Examples:
		|montantEL|duretEL |tauxEL|
		|400      |12      |0.15  |