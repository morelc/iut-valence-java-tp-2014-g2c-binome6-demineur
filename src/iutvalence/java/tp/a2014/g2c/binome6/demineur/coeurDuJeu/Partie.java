package iutvalence.java.tp.a2014.g2c.binome6.demineur.coeurDuJeu;

import iutvalence.java.tp.a2014.g2c.binome6.demineur.IHM.IHMCreerParametresPartie;
import iutvalence.java.tp.a2014.g2c.binome6.demineur.IHM.IHMCreerParametresPartieASCII;
import iutvalence.java.tp.a2014.g2c.binome6.demineur.IHM.IHMJoueur;
import iutvalence.java.tp.a2014.g2c.binome6.demineur.IHM.IHMJoueurASCII;
import iutvalence.java.tp.a2014.g2c.binome6.demineur.annexes.StatutPartie;

/**
 * Déroulement de le partie.
 *
 * @author BEGOT William <william.begot@iut-valence.fr>
 * @author MOREL Charles <charles.morel@iut-valence.fr>
 * @version 1.0
 */
public class Partie
{
    // Définition des variables:

    /**
     * Initialisation de l'IHM du Joueur
     */
    private final IHMJoueur MonJoueurEnASCII;

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
        // initialisation d'une IHM de joueur en ASCII
        this.MonJoueurEnASCII = new IHMJoueurASCII();
        // Initialisation d'une IHM pour paramétrer une partie en ASCII
        this.parametresPartie = new IHMCreerParametresPartieASCII();
    }

    // Définition des méthodes:
    private void initialisaerPartie()
    {
        // Création des parametres de partie
        this.parametresPartie.parametrerPartie();

        // Création du plateau
        /**
         * Plateau de jeu.
         */
        this.monplateau = new Plateau(this.parametresPartie.getNombreColonnesPlateau(), this.parametresPartie.getNombreLignesPlateau(), this.parametresPartie.getNombreBombesPlateau());
    }

    public void lancerPartie()
    {
        System.out.println("Bienvenue sur le démineur de MOREL Charles et BEGOT William (V.1.0)");
        initialisaerPartie();
        while (this.monplateau.getStatutPartie() == StatutPartie.ENCOURS)
        {
            MonJoueurEnASCII.interactionJoueur(monplateau);
        }
    }
}
