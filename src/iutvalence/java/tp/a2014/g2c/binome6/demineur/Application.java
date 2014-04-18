package iutvalence.java.tp.a2014.g2c.binome6.demineur;

import iutvalence.java.tp.a2014.g2c.binome6.demineur.annexes.StatutPartie;

/**
 * Lanceur de l'application.
 *
 * @author BEGOT William <william.begot@iut-valence.fr>
 * @author MOREL Charles <charles.morel@iut-valence.fr>
 * @version 1.0
 */
public class Application
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // Commandes de test
        Plateau monplateau = new Plateau(10, 10, 10);
        IHMJoueurASCII MonJoueurEnASCII = new IHMJoueurASCII();

        while (monplateau.getStatutPartie() == StatutPartie.ENCOURS)
        {
            MonJoueurEnASCII.interactionJoueur(monplateau);
        }

    }

}
