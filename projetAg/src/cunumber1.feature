#pour le US :
#1 création de pièce avec son nom
#vérification que le nom est bon
#2 création de pièce avec son nom et sa surface en positif
#vérification de que la surface est la bonne
#2 bis création d une pièce et sa surface négative
#vérification que la surface est à 0 retour d erreur (ca ca générera un échec)
#3 création d'un appartement avec une pièce
#calcul du prix
#5 création d'un appartement avec plusieurs pièces : vérification du prix
@tagTest1
Feature: US_OO1 Visiter un appartement
  En tant qu'acheteur
  Je veux visiter un appartement, avec son adresse, le nom de ses pieces, je veux connaitre la surface des pièces,je veux connaitre le prix de l'appartement
  Afin de m'assurer que l'appartement correspond bien a mes besoins
  
  @tag1
  Scenario Outline: verification du nom
    Given une piece qui a un nom
    When le nom est <nomAppart>
    Then le nom affecte correspond <answer> I verify the <validation> in step

    Examples: 
      | nomAppart | answer  | validation |
      | "piece1"  | "piece1"| success |
      | "piece2"  | "piece3"| failure |
  @tag2
  Scenario Outline: verification de la surface
    Given une piece qui a un nom et une surface
    When le nom est <nomAppart> , la surface est <surface>
    Then la surface correspond <answer> I verify the <validation> in step

    Examples: 
      | nomAppart |surface | answer  | validation |
      | "piece1"  | "5.0" |"5.0"| success |
      | "piece2"  | "-1.0"|"0.0"| failure |
   
  @tag3
  Scenario Outline: verification de l'affection d'une pièce a un appartement et donc du prix 
    Given un appartement et ses pieces
    When le nom de la piece est <nomAppart> l'appartement a une <adresse> et une <surface>
    Then <adresse validation> validation correspond bien de meme que le <nombre de pieces> et le <prixm2> permet de calculer le <prix Appart>. I verify the <validation> in step

    Examples: 
      | nomAppart | adresse 		 |surface| adresse validation  |nombre de pieces| prixm2|prix Appart|validation |
      | "studio" |"55 av mozart" |"5.0"  | "55 av mozart"			 | 1							| "1000"| "5000"	   |success 	 |
      |   ""		 |"22 rue de washington"|"0.0"|"22 rue de washington"|0			    |"0"    |"0"         |success 	 |
   		|  "studio"|"22 rue de washington"|"50.0"|"22 rue de washington"|1			    |"10"    |"0"      |failure 	 |
   
  @tag4
  Scenario Outline: creation d'un appartement de plusieurs piece et verification de son prix
    Given un appartement et ses pieces
    When Adresse de l'appart <adresse> l'appartement un <salon> et une <chambre> de taille <surface> chacune
    Then Le <prixm2> permet de calculer le <prixAppart> I verify the <validation> in step

    Examples: 
      | adresse | salon 		 |chambre|surface|prixm2|prixAppart|validation |
      |"55 av mozart" |"salon"  | "chambre"			 | "10.0"							| "1000"| "20000.0"	   |success 	 |
      |"22 av mozart" |"salon principal"  | "SDB et chambre"| "15.0"	| "1000"| "20000.0"	   |failure 	 |
