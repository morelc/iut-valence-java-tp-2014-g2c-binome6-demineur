package iutvalence.java.tp.a2014.g2c.binome6.demineur.coeurDuJeu;

import iutvalence.java.tp.a2014.g2c.binome6.demineur.IHM.IHMCreerParametresPartie;
import iutvalence.java.tp.a2014.g2c.binome6.demineur.IHM.IHMJoueur;
import iutvalence.java.tp.a2014.g2c.binome6.demineur.IHM.Swing.IHMCreerParametresPartieSWING;
import iutvalence.java.tp.a2014.g2c.binome6.demineur.IHM.Swing.IHMJoueurSWING;
import iutvalence.java.tp.a2014.g2c.binome6.demineur.annexes.StatutPartie;

/**
 * Déroulement de le partie.
 *
 * @author BEGOT William <william.begot@iut-valence.fr>
 * @author MOREL Charles <charles.morel@iut-valence.fr>
 * @version 1.0
 */
public class Partie {
    // Définition des attributs:

    /**
     * Initialisation de l'IHM du Joueur
     */
    private final IHMJoueur monJoueurSWING;

    /**
     * Paramètres de la partie
     */
    private final IHMCreerParametresPartie parametresPartie;

    /**
     * Plateau de jeu.
     */
    private Plateau monplateau;

    // Définition du constructeur
    public Partie()
    {
        // création d'une partie en ascii:
        // initialisation d'une IHM de joueur en SWING
        this.monJoueurSWING = new IHMJoueurSWING();
        // Initialisation d'une IHM pour paramétrer une partie en SWING
        this.parametresPartie = new IHMCreerParametresPartieSWING();
    }

    // Définition des méthodes:
    /**
     * Méthode permettant d'initialiser une partie.
     * Elle permet entre autres d'obtenir les paramètres et d'instancier les
     * principales classes du jeu.
     */
    private void initialiserPartie()
    {
        // Création des parametres de partie
        this.parametresPartie.parametrerPartie();

        // Création du plateau
        /**
         * Plateau de jeu.
         */
        this.monplateau = new Plateau(this.parametresPartie.getNombreColonnesPlateau(), this.parametresPartie.getNombreLignesPlateau(), this.parametresPartie.getNombreBombesPlateau());
    }

    /**
     * Méthode permettant de lancer une partie.
     * Cette méthode initialise la partie, puis la lance.
     */
    public void lancerPartie()
    {
        initialiserPartie();
        while (this.monplateau.getStatutPartie() == StatutPartie.ENCOURS)
        {
            monJoueurSWING.interactionJoueur(monplateau);
        }
    }

}
