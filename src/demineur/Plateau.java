package demineur;

/**
 * Classe du plateau de jeu. C'est une classe définissant un plateau de jeu
 * composé de cases ainsi que le statut de la partie.
 *
 * @author begotw
 */
public class Plateau
{

    // Définition des types:
    /**
     * Définition du type pour la définition du statut de la partie.
     */
    public enum statutPossibleDePartie
    {

        enCours,
        estGagnee,
        estPerdue;
    }

    // Définition des varaibles
    /**
     * Variable définissant le statut de la partie. Une partie est soit en
     * cours, soit perdu, soit gagné.
     */
    private statutPossibleDePartie statutPartie;

    /**
     * Variable définissant le tableau.
     */
    Case[][] Plateau;

    // Définition du constructeur
    /**
     * Constructeur du plateau.
     *
     * @param nombreDeColonnesDuPlateau nombre de colonnes qui composent le
     * plateau
     * @param nombreDeLignesDuPlateau nombre de lignes qui composent le plateau
     * @param nombreDeBombesDuPlateau nombre de mines cachées dans le plateau
     */
    public Plateau(int nombreDeColonnesDuPlateau, int nombreDeLignesDuPlateau, int nombreDeBombesDuPlateau) {
        // Définition des dimensions du tableau
        this.Plateau = new Case[nombreDeColonnesDuPlateau][nombreDeLignesDuPlateau];
        // Initialisation des cases du tableau avec les propriétés: pas de bombe, pas de bombe adjacente et case masquée
        for (int numeroColonne = 0; numeroColonne < nombreDeColonnesDuPlateau; numeroColonne++) {
            for (int numeroLigne = 0; numeroLigne < nombreDeLignesDuPlateau; numeroLigne++) {
                this.Plateau[numeroColonne][numeroLigne] = new Case();
            }
        }
        // Positionnement aléatoire des bombes sur le plateau (simple)
        int colonneOuPlacerLaBombe = 0;
        int ligneOuPlacerLaBombe = 0;
        for (int nombreDeBombesRestantAPlacer = nombreDeBombesDuPlateau; nombreDeBombesRestantAPlacer != 0; nombreDeBombesRestantAPlacer--) {
            do {
                colonneOuPlacerLaBombe = (int) Math.round(Math.random() * (nombreDeColonnesDuPlateau - 1));
                ligneOuPlacerLaBombe = (int) Math.round(Math.random() * (nombreDeLignesDuPlateau - 1));
            }
            while (this.Plateau[colonneOuPlacerLaBombe][ligneOuPlacerLaBombe].getaUneBombe() != false);
            this.Plateau[colonneOuPlacerLaBombe][ligneOuPlacerLaBombe].setaUneBombe(true);
        }
        // Calcul des bombes adjacentes aux différentes cases

        //                       ENCORE A FAIRE!
    }

}
