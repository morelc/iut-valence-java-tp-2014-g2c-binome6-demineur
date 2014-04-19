package iutvalence.java.tp.a2014.g2c.binome6.demineur.IHM;

import iutvalence.java.tp.a2014.g2c.binome6.demineur.coeurDuJeu.Plateau;

/**
 *
 * @author MOREL Charles <charles.morel@iut-valence.fr>
 */
public interface IHMJoueur
{

    // Méthode d'interaction
    /**
     * Méthode d'interaction avec le joueur.
     *
     * Permet au joueur d'interagir avec le jeu: affiche le plateau, entre
     * l'action à effectuer ainsi que la case sur laquelle l'appliquer
     *
     * @param plateauAModifier plateau sur lequel interagir.
     */
    void interactionJoueur(Plateau plateauAModifier);

}
