Feature: Deposer de l'argent 
	
	@tag1	
	Scenario Outline: Deposer un montant d'un compte bancaire dont le solde le permet 
		Given un client c de la banque KN existe  avec un solde initial de <soldeInitialC> et veut faire un depot
		When le client c appelle la methode deposer avec en attribut le <montantC>
		Then le nouveau solde de son compte est <soldeFinalDepot> 
		Examples:
		|soldeInitialC|montantC |soldeFinalDepot|
		|50.0         |20.5     |70.5           |
		
	@tag2	
	Scenario Outline: Deposer un montant negatif ou nul
		Given un client d de la banque KN existe  avec un solde initial de <soldeInitialD> et veut faire un depot
		When le client d appelle la methode deposer avec en attribut un montant negatif <montantD>
		Then operation impossible msg error <msgError> le solde reste <soldeFinalD> 
		Examples:
		|soldeInitialD|montantD |soldeFinalD|msgError                                                                     |
		|50.0         |-20.5    |50.0       |"impossible de deposer : le montant n'est pas suffisant pour cette operation"|