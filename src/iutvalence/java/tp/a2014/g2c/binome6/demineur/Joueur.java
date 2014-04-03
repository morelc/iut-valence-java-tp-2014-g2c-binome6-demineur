package iutvalence.java.tp.a2014.g2c.binome6.demineur;

import iutvalence.java.tp.a2014.g2c.binome6.demineur.annexes.StatutCase;
import java.util.Scanner;

/**
 * Classe des méthodes d'entrées et de sorties pour le joueur.
 *
 * @author BEGOT William <william.begot@iut-valence.fr>
 * @author MOREL Charles <charles.morel@iut-valence.fr>
 * @version 0.1
 */
public class Joueur
{
    // Définition des variables:

    /**
     * Scanner d'entrées du joueur.
     */
    Scanner scanner = new Scanner(System.in);

    /**
     * Dernière ligne entrée par le joueur.
     */
    private int derniereLigneEntree;

    /**
     * Dernière colonne entrée par le joueur.
     */
    private int derniereColonneEntree;

    /**
     * Valeur par défaut de la dernière ligne entrée.
     */
    private final static int DERNIERE_LIGNE_ENTREE_DEFAULT = 0;

    /**
     * Valeur par défaut de la dernière colonne entrée.
     */
    private final static int DERNIERE_COLONNE_ENTREE_DEFAULT = 0;

    // Constructeur
    public Joueur() {
        this.derniereLigneEntree = DERNIERE_LIGNE_ENTREE_DEFAULT;
        this.derniereColonneEntree = DERNIERE_COLONNE_ENTREE_DEFAULT;
    }

    // Méthodes d'entrées
    /**
     * Méthode d'entrée du numéro d'une ligne.
     */
    private void entrerLigne() {
        System.out.println("Veuillez entrer le numéro de la ligne: ");
        this.derniereLigneEntree = scanner.nextInt();
    }

    /**
     * Méthode d'entrée du numéro d'une colonne.
     */
    private void entrerColonne() {
        System.out.println("Veuillez entrer le numéro de la colonne: ");
        this.derniereColonneEntree = scanner.nextInt();
    }

    /**
     * Méthode d'entrée des coordonnées d'une case du plateau.
     */
    public void entrerCoordonneesCase() {
        entrerLigne();
        entrerColonne();
    }

    // Méthodes d'affichages
    /**
     * Affichage de la case du plateau aux dernières coordonnées entrées.
     * (temporaire car inutile dans le futur!)
     *
     * @param plateauAModifier le plateau contenant la case à modifier.
     * @deprecated
     */
    public void affihcerCase(Plateau plateauAModifier) {
        plateauAModifier.plateau[this.derniereColonneEntree][this.derniereLigneEntree].setStatutCase(StatutCase.DECOUVERTE);
    }
}
