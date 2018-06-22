Feature: Retirer de l'argent 
	
	@tag1	
	Scenario Outline: Retirer un montant d'un compte bancaire dont le solde le permet 
		Given un client c de la banque KN existe  avec un solde initial de <soldeInitialC> et veut faire un retrait 
		When le client c appelle la methode retirer avec en attribut le <montantC>
		Then le nouveau solde est <soldeFinal> 
		Examples:
		|soldeInitialC  |montantC |soldeFinal|
		|50.0           |20.0     |30.0      |
		
	@tag2	
	Scenario Outline: Retirer un montant d'un compte bancaire dont le solde ne le permet pas  
		Given un client d de la banque KN existe avec un solde initial de <soldeInitialD> et veut faire un retrait 
		When le client c appelle la methode retirer avec en attribut le <montantD> 
		Then Afficher message d'eurreur <msgERROR> 
		Examples:
		|soldeInitialD |montantD  |msgERROR                                                                  |
		|30.0          |100.0     |"impossible de retirer : votre solde est insuffisant pour cette operation"|
	
	@tag3	
	Scenario Outline: Retirer zero d'un compte bancaire dont le solde est nul
		Given un client de la banque KN existe avec un solde initial par defaut nul
		When le client appelle la methode retirer avec attribut <zero>
		Then son solde reste egale a <soldeNul> 
		Examples:
		|zero  |soldeNul |
		|0.0   |0.0      |
