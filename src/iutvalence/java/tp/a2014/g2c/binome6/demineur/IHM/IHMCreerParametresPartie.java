package iutvalence.java.tp.a2014.g2c.binome6.demineur.IHM;

/**
 * Classe contenant les paramètres de la partie.
 *
 * @author MOREL Charles <charles.morel@iut-valence.fr>
 */
public interface IHMCreerParametresPartie
{

    // Getters
    /**
     * Obtenir le nombre de bombes à positionner sur le plateau.
     *
     * @return le nombreBombesPlateau
     */
    int getNombreBombesPlateau();

    /**
     * Obtenir le de colonnes du plateau.
     *
     * @return le nombreColonnesPlateau
     */
    int getNombreColonnesPlateau();

    /**
     * Obtenir le de lignes du plateau.
     *
     * @return le nombreLignesPlateau
     */
    int getNombreLignesPlateau();

    // Méthodes utilisables hors-classe:
    /**
     * Méthode de paramétrage de la partie (garder les paramètres par défaut ou
     * les modifier).
     */
    void parametrerPartie();

}
