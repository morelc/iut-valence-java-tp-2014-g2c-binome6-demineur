/* TODO Convention du java : les noms de package ne comportent pas de majuscules. */
/* TODO Que fait cette classe ? */
package Demineur;

/**
 * Classe du plateau de jeu. C'est une classe définissant un plateau de jeu
 * composé de cases ainsi que le statut de la partie.
 *
 * @author begotw
 */
public class Plateau {

    // Définition des types:

    /**
     * Définition du type pour la définition du statut de la partie.
     */
    public enum statutPossibleDePartie {

        enCours,
        estGagnee,
        estPerdue;
    }

    // Définition des variables
    /**
     * Variable définissant le statut de la partie. Une partie est soit en
     * cours, soit perdu, soit gagné.
     */
    private statutPossibleDePartie statutPartie;

    Case[][] Plateau = null;

}
