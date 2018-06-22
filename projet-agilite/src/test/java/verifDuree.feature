Feature: tester la methode de vérificvation de durée demandée pour le pret immobilier 
	
	@tag1	
	Scenario Outline:  Verifier que toute duree inferieure duree max est acceptée
		Given un client c de la banque KN existe avec pretHabitat de montant <montantPretHabitat> et duree <dureeH> 
		When il appelle creeDuree
		Then si la duree demandee <dureeH> est inferieure a duree max alors la demande est acceptee avec le message <messageOui> 
		Examples:
		|montantPretHabitat|dureeH |messageOui       |
		|500.0             |10     |"Dur�e Acceptée"|
		
	@tag2	
	Scenario Outline:  Verifier que toute duree superieure a duree max est refusée
		Given un client d veut un pretHabitat de montant <montantPH> et duree <dureePH> 
		When il appelle la methode creeDuree
		Then si la duree demandee <dureePH> est superieure a duree max alors la demande est refusee avec le message <messageNon> 
		Examples:
		|montantPH|dureePH |messageNon       |
		|500.0    |455     |"Durée non Acceptée" |
		
	@tag3	
	Scenario Outline:  Verifier que toute duree inferieure duree max est acceptée pour un pretEpargneLogement
		Given un client claude de la banque KN existe avec pretEpargneLogement de montant <montantPretEpargneLogement> et duree <dureeE> 
		When claude appelle creeDuree
		Then si la duree demandee par claude <dureeE> est inferieure a duree max alors la demande est acceptee avec le message <messageA> 
		Examples:
		|montantPretEpargneLogement|dureeE |messageA       |
		|500.0                     |10     |"Dur�e Acceptée"|
		
	@tag2	
	Scenario Outline:  Verifier que toute duree superieure a duree max est refusée
		Given un client daniel veut un pretEpargneLogement de montant <montantEL> et duree <dureeEL> 
		When daniel appelle la methode creeDuree
		Then si la duree demandee par daniel <dureeEL> est superieure a duree max alors la demande est refusee avec le message <messageR> 
		Examples:
		|montantEL|dureeEL |messageR              | 
		|500.0    |455     |"Durée non Acceptée"|