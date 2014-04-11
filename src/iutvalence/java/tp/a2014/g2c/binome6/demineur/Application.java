package iutvalence.java.tp.a2014.g2c.binome6.demineur;

import iutvalence.java.tp.a2014.g2c.binome6.demineur.annexes.StatutPartie;

/**
 * TODO
 *
 * @author BEGOT William <william.begot@iut-valence.fr>
 * @author MOREL Charles <charles.morel@iut-valence.fr>
 * @version 0.1
 */
public class Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Commandes de test
        Plateau monplateau = new Plateau(10, 10, 10);
        IHM_Joueur_ASCII monJoueur = new IHM_Joueur_ASCII();
        
        while (monplateau.getStatutPartie() != StatutPartie.ESTPERDUE) {
            monJoueur.interactionJoueur(monplateau);
        }
        
    }
    
}
