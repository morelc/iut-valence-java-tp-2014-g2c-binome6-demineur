package iutvalence.java.tp.a2014.g2c.binome6.demineur;

import iutvalence.java.tp.a2014.g2c.binome6.demineur.annexes.InteractionCase;
import iutvalence.java.tp.a2014.g2c.binome6.demineur.annexes.StatutCase;
import iutvalence.java.tp.a2014.g2c.binome6.demineur.annexes.StatutPartie;

import java.util.Scanner;

/**
 * Classe des méthodes d'entrées et de sorties pour le joueur.
 *
 * @author BEGOT William <william.begot@iut-valence.fr>
 * @author MOREL Charles <charles.morel@iut-valence.fr>
 * @version 0.1
 */
public class IHM_Joueur_ASCII {
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
     * Dernière interaction entrée par le joueur.
     */
    private InteractionCase derniereActionEntree;

    /**
     * Valeur par défaut de la dernière ligne entrée.
     */
    private final static int DERNIERE_LIGNE_ENTREE_DEFAULT = 0;

    /**
     * Valeur par défaut de la dernière colonne entrée.
     */
    private final static int DERNIERE_COLONNE_ENTREE_DEFAULT = 0;

    // Constructeur
    public IHM_Joueur_ASCII() {
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
    private void entrerCoordonneesCase() {
        entrerLigne();
        entrerColonne();
    }

    /**
     * Méthode d'entrée d'une action.
     */
    private void entrerUneAction() {
        char valeurDeLEntree;
        System.out.println("Veuillez entrer l'action à effectuer (m = Marquer, e = Enlever le marquage, d = Déminer) : ");
        do {
            String lecture = scanner.nextLine();
            if (lecture != null && lecture.length() > 0) {
                valeurDeLEntree = lecture.charAt(0);
            } else {
                valeurDeLEntree = 'x';
            }
        } while (valeurDeLEntree != 'm' && valeurDeLEntree != 'e' && valeurDeLEntree != 'd');

        switch (valeurDeLEntree) {
            case 'm':
                this.derniereActionEntree = InteractionCase.MARQUER;
                break;
            case 'e':
                this.derniereActionEntree = InteractionCase.ENLEVER_MARQUAGE;
                break;
            case 'd':
                this.derniereActionEntree = InteractionCase.DEMINER;
                break;

        }
    }

    // Méthodes d'application de modification
    /**
     * Application de l'interaction sur la case.
     *
     * Permet d'effectuer l'action demandée sur le plateau avec les dernières
     * coordonnées entrées par la méthode entrerCoordonneesCase et avec la
     * dernière action entrée avec la méthode entrerUneAction().
     *
     * @param plateauAModifier est le plateau sur laquelle on interagis avec la
     * case
     */
    private void appliquerActionSurCase(Plateau plateauAModifier) {
        Case CaseCourrante = plateauAModifier.plateau[this.derniereColonneEntree][this.derniereLigneEntree];

        // Traitement du cas où la case à modifier est déjà démasquée (donc aucune action n'est possible)
        if (CaseCourrante.getStatutCase() == StatutCase.DECOUVERTE) {
            System.out.println("Désolé mais la case entrée est déjà démasquée...");
        } else {
            // Traitement du cas où on veut marquer la case
            if (this.derniereActionEntree == InteractionCase.MARQUER) {
                CaseCourrante.setStatutCase(StatutCase.MARQUEE);
            }
            // Traitement du cas où on veut enlever le marquage de la case (retour au statut marquée)
            if (this.derniereActionEntree == InteractionCase.ENLEVER_MARQUAGE) {
                CaseCourrante.setStatutCase(StatutCase.MASQUEE);
            }
            // Tritaent du cas où on veut déminer la case
            if (this.derniereActionEntree == InteractionCase.DEMINER) {
                deminerCase(plateauAModifier, this.derniereColonneEntree, this.derniereLigneEntree);
            }
        }
    }

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

    /**
     * Méthode de déminage d'une case.
     *
     * Permet de déminer récursivement une case.
     *
     * @param plateauAModifier plateau où déminer la case
     */
    private void deminerCase(Plateau plateauAModifier, int numLigneColonne, int numLigneCase) {
        Case caseCourrante = plateauAModifier.plateau[this.derniereColonneEntree][this.derniereLigneEntree];

        caseCourrante.setStatutCase(StatutCase.DECOUVERTE);
        // traitement du cas où la case a une bombe
        if (caseCourrante.getaUneBombe()) {
            plateauAModifier.setStatutPartie(StatutPartie.ESTPERDUE);
        }
        System.out.println("Vous avez perdu!");
        // traitement du cas où la case n'a pas de bombe
//        else
//        {
//             // à finir...
//        }
//        
    }

    // Méthode d'interaction 
    /**
     * Méthode d'interaction avec le joueur.
     *
     * Permet au joueur d'interagir avec le jeu: affiche le plateau, entre
     * l'action à effectuer ainsi que la case sur laquelle l'appliquer
     *
     * @param plateauAModifier plateau sur lequel interagir.
     */
    public void interactionJoueur(Plateau plateauAModifier) {
        System.out.println(plateauAModifier.toString());
        entrerUneAction();
        entrerCoordonneesCase();
        appliquerActionSurCase(plateauAModifier);
    }

}
