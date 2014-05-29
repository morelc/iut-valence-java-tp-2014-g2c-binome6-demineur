package iutvalence.java.tp.a2014.g2c.binome6.demineur.lancementPartie;

import iutvalence.java.tp.a2014.g2c.binome6.demineur.coeurDuJeu.Partie;

/**
 * Lanceur de l'application.
 *
 * @author BEGOT William <william.begot@iut-valence.fr>
 * @author MOREL Charles <charles.morel@iut-valence.fr>
 * @version 1.0
 */
public class Application {

    /**
     * @param args les paramètres spécifiques de la VM
     */
    public static void main(String[] args)
    {
        // Initialisation d'une partie
        Partie maPartie = new Partie();
        // Lancement de la partie
        maPartie.lancerPartie();

    }

}
