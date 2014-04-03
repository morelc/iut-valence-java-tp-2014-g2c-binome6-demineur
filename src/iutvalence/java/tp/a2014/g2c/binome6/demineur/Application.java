package iutvalence.java.tp.a2014.g2c.binome6.demineur;

/**
 * TODO
 *
 * @author BEGOT William <william.begot@iut-valence.fr>
 * @author MOREL Charles <charles.morel@iut-valence.fr>
 * @version 0.1
 */
public class Application
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Commandes de test
        Plateau monplateau = new Plateau(10, 10, 10);
        Joueur monJoueur = new Joueur();
        int nbCoupsAJouer = 1000;

        while (nbCoupsAJouer == 1000) {
            System.out.println(monplateau.toString());
            monJoueur.entrerCoordonneesCase();
            monJoueur.affihcerCase(monplateau);

        }

    }

}
