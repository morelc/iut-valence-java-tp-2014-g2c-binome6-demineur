package demineur;

import demineur.annexes.StatutPossibleDePartie;

/**
 * plateau de jeu.
 * C'est une classe définissant un plateau de jeu composé de cases ainsi que le
 * statut de la partie.
 *
 * @author BEGOT William <william.begot@iut-valence.fr>
 * @version 0.1
 */
public class Plateau
{

    // Définition des varaibles
    /**
     * Variable définissant le statut de la partie. Une partie est soit en
     * cours, soit perdu, soit gagné.
     */
    private StatutPossibleDePartie statutPartie;

    /**
     * Variable définissant le tableau.
     */
    Case[][] plateau;

    // Définition du constructeur
    /* TODO C'est très difficilement lisible ! Réduisez la taille des noms de variable !
     * Certaines de vos lignes ont plus de 200 caractères de large ! */
    /**
     * Constructeur du plateau.
     *
     * @param nombreDeColonnesDuPlateau nombre de colonnes qui composent le
     * plateau
     * @param nombreDeLignesDuPlateau nombre de lignes qui composent le plateau
     * @param nombreDeBombesDuPlateau nombre de mines cachées dans le plateau
     */
    public Plateau(int nombreDeColonnesDuPlateau, int nombreDeLignesDuPlateau, int nombreDeBombesDuPlateau)
    {
        // Définition des dimensions du tableau
        this.plateau = new Case[nombreDeColonnesDuPlateau][nombreDeLignesDuPlateau];
        // Initialisation des cases du tableau avec les propriétés: pas de bombe, pas de bombe adjacente et case masquée
        for (int numeroColonne = 0; numeroColonne < nombreDeColonnesDuPlateau; numeroColonne++)
        {
            for (int numeroLigne = 0; numeroLigne < nombreDeLignesDuPlateau; numeroLigne++)
            {
                this.plateau[numeroColonne][numeroLigne] = new Case();
            }
        }
        // Positionnement aléatoire des bombes sur le plateau (simple)
        int colonneOuPlacerLaBombe = 0;
        int ligneOuPlacerLaBombe = 0;
        for (int nombreDeBombesRestantAPlacer = nombreDeBombesDuPlateau; nombreDeBombesRestantAPlacer != 0; nombreDeBombesRestantAPlacer--)
        {
            do
            {
                colonneOuPlacerLaBombe = (int) Math.round(Math.random() * (nombreDeColonnesDuPlateau - 1));
                ligneOuPlacerLaBombe = (int) Math.round(Math.random() * (nombreDeLignesDuPlateau - 1));
            }
            /* TODO !plateau[colonneOuPlacerLaBombe][ligneOuPlacerLaBombe].getaUneBombe() */
            while (this.plateau[colonneOuPlacerLaBombe][ligneOuPlacerLaBombe].getaUneBombe() != false);
            this.plateau[colonneOuPlacerLaBombe][ligneOuPlacerLaBombe].setaUneBombe(true);
        }
        // Calcul des bombes adjacentes aux différentes cases
        for (int numeroColonneCaseATraiter = 0; numeroColonneCaseATraiter < nombreDeColonnesDuPlateau; numeroColonneCaseATraiter++)
        {
            for (int numeroLigneCaseATraiter = 0; numeroLigneCaseATraiter < nombreDeLignesDuPlateau; numeroLigneCaseATraiter++)
            {
                if (numeroLigneCaseATraiter != 0)
                {
                    if (numeroColonneCaseATraiter != 0)
                    {
                        if (this.plateau[numeroColonneCaseATraiter - 1][numeroLigneCaseATraiter - 1].getaUneBombe() == true)
                        {
                            this.plateau[numeroColonneCaseATraiter][numeroLigneCaseATraiter].setaNBombesAdjacentes(this.plateau[numeroColonneCaseATraiter][numeroLigneCaseATraiter].getaNBombesAdjacentes() + 1);
                        }
                    }
                    if (this.plateau[numeroColonneCaseATraiter][numeroLigneCaseATraiter - 1].getaUneBombe() == true)
                    {
                        this.plateau[numeroColonneCaseATraiter][numeroLigneCaseATraiter].setaNBombesAdjacentes(this.plateau[numeroColonneCaseATraiter][numeroLigneCaseATraiter].getaNBombesAdjacentes() + 1);
                    }
                    if (numeroColonneCaseATraiter != nombreDeColonnesDuPlateau - 1)
                    {
                        if (this.plateau[numeroColonneCaseATraiter + 1][numeroLigneCaseATraiter - 1].getaUneBombe() == true)
                        {
                            this.plateau[numeroColonneCaseATraiter][numeroLigneCaseATraiter].setaNBombesAdjacentes(this.plateau[numeroColonneCaseATraiter][numeroLigneCaseATraiter].getaNBombesAdjacentes() + 1);
                        }
                    }
                }
                if (numeroLigneCaseATraiter != nombreDeLignesDuPlateau - 1)
                {
                    if (numeroColonneCaseATraiter != 0)
                    {
                        if (this.plateau[numeroColonneCaseATraiter - 1][numeroLigneCaseATraiter + 1].getaUneBombe() == true)
                        {
                            this.plateau[numeroColonneCaseATraiter][numeroLigneCaseATraiter].setaNBombesAdjacentes(this.plateau[numeroColonneCaseATraiter][numeroLigneCaseATraiter].getaNBombesAdjacentes() + 1);
                        }
                    }
                    if (this.plateau[numeroColonneCaseATraiter][numeroLigneCaseATraiter + 1].getaUneBombe() == true)
                    {
                        this.plateau[numeroColonneCaseATraiter][numeroLigneCaseATraiter].setaNBombesAdjacentes(this.plateau[numeroColonneCaseATraiter][numeroLigneCaseATraiter].getaNBombesAdjacentes() + 1);
                    }
                    if (numeroColonneCaseATraiter != nombreDeColonnesDuPlateau - 1)
                    {
                        if (this.plateau[numeroColonneCaseATraiter + 1][numeroLigneCaseATraiter + 1].getaUneBombe() == true)
                        {
                            this.plateau[numeroColonneCaseATraiter][numeroLigneCaseATraiter].setaNBombesAdjacentes(this.plateau[numeroColonneCaseATraiter][numeroLigneCaseATraiter].getaNBombesAdjacentes() + 1);
                        }
                    }
                }
                if (numeroColonneCaseATraiter != 0)
                {
                    if (this.plateau[numeroColonneCaseATraiter - 1][numeroLigneCaseATraiter].getaUneBombe() == true)
                    {
                        this.plateau[numeroColonneCaseATraiter][numeroLigneCaseATraiter].setaNBombesAdjacentes(this.plateau[numeroColonneCaseATraiter][numeroLigneCaseATraiter].getaNBombesAdjacentes() + 1);
                    }
                }
                if (numeroColonneCaseATraiter != nombreDeColonnesDuPlateau - 1)
                {
                    if (this.plateau[numeroColonneCaseATraiter + 1][numeroLigneCaseATraiter].getaUneBombe() == true)
                    {
                        this.plateau[numeroColonneCaseATraiter][numeroLigneCaseATraiter].setaNBombesAdjacentes(this.plateau[numeroColonneCaseATraiter][numeroLigneCaseATraiter].getaNBombesAdjacentes() + 1);
                    }
                }

            }
        }

    }

}
