Feature: Verifier la duree max d'un pret immobilier 
	
	@tag1	
	Scenario Outline:  Verifier la duree max pret habitat
		Given un client c de la banque KN existe avec pretHabitat de montant <montantPretHabitat> et duree <dureePH> veut consulter la duree max 
		When le client c appelle creeDuree
		Then la duree max est <dureeMaxPH> 
		Examples:
		|montantPretHabitat|dureePH |dureeMaxPH |
		|500.0             |10      |300        |
	
	@tag2
	Scenario Outline:  Verifier la duree max pret epargne logement
		Given un client d existe avec pretEpargneLogement de montant <montantPretHabitat> et duree <dureePH> veut consulter la duree max 
		When le client appelle creeDuree
		Then la duree maximale permise est <dureeMaxEL> 
		Examples:
		|montantPretHabitat|dureePH |dureeMaxEL |
		|200.0             |111      |500       |