package iutvalence.java.tp.a2014.g2c.binome6.demineur;

import iutvalence.java.tp.a2014.g2c.binome6.demineur.annexes.StatutPartie;

/**
 * Plateau de jeu. C'est une classe définissant un plateau de jeu composé de
 * cases ainsi que le statut de la partie.
 *
 * @author BEGOT William <william.begot@iut-valence.fr>
 * @author MOREL Charles <charles.morel@iut-valence.fr>
 * @version 0.1
 */
public class Plateau {

    // Définition des varaibles
    /**
     * Variable définissant le statut de la partie. Une partie est soit en
     * cours, soit perdu, soit gagné.
     */
    private StatutPartie statutPartie;

    /**
     * Variable définissant le tableau.
     */
    Case[][] plateau;

    /**
     * Variable définissant le nombre de bombes dans le plateau.
     */
    private final int nombreBombesPlateau;

    /**
     * Variable définissant le nombre de colonnes du plateau.
     */
    private final int nombreColonnesPlateau;

    /**
     * Variable définissant le nombre de lignes du plateau.
     */
    private final int nombreLignesPlateau;

    // Définition du constructeur
    /* TODO Toujours aussi peu lisible!!! */
    /**
     * Constructeur du plateau.
     *
     * @param nombreDeColonnesDuPlateau nombre de colonnes qui composent le
     * plateau
     * @param nombreDeLignesDuPlateau nombre de lignes qui composent le plateau
     * @param nombreDeBombesDuPlateau nombre de mines cachées dans le plateau
     */
    public Plateau(int nombreDeColonnesDuPlateau, int nombreDeLignesDuPlateau, int nombreDeBombesDuPlateau) {

        // Définition des variables du plateau
        this.nombreBombesPlateau = nombreDeBombesDuPlateau;
        this.nombreColonnesPlateau = nombreDeColonnesDuPlateau;
        this.nombreLignesPlateau = nombreDeLignesDuPlateau;

        // Définition des dimensions du tableau
        this.plateau = new Case[this.nombreColonnesPlateau][this.nombreLignesPlateau];

        // Initialisation des cases du tableau avec les propriétés: pas de bombe, pas de bombe adjacente et case masquée
        for (int numeroColonne = 0; numeroColonne < this.nombreColonnesPlateau; numeroColonne++) {
            for (int numeroLigne = 0; numeroLigne < this.nombreLignesPlateau; numeroLigne++) {
                this.plateau[numeroColonne][numeroLigne] = new Case();
            }
        }

        // Placement des mines dans le plateau (méthode simple)
        PlacerLesBombesSurLePlateau();

        // Calcul des bombes adjacentes aux différentes cases
        CalculDesBombesAdjacentes();

    }

    // Méthodes d'initialisation du plateau:
    /**
     * Méthode d'initialisation: positionnement des bombes sur le plateau
     * (méthode simple).
     */
    private void PlacerLesBombesSurLePlateau() {
        int colonneOuPlacerLaBombe = 0;
        int ligneOuPlacerLaBombe = 0;
        for (int nombreDeBombesRestantAPlacer = this.nombreBombesPlateau; nombreDeBombesRestantAPlacer != 0; nombreDeBombesRestantAPlacer--) {
            do {
                /* TODO utilisez SecureRandom.*/
                /* TODO Implémentation extremement peu efficace. A discuter en TP. */
                colonneOuPlacerLaBombe = (int) Math.round(Math.random() * (this.nombreColonnesPlateau - 1));
                ligneOuPlacerLaBombe = (int) Math.round(Math.random() * (this.nombreLignesPlateau - 1));
            } while (this.plateau[colonneOuPlacerLaBombe][ligneOuPlacerLaBombe].getaUneBombe() != false);
            this.plateau[colonneOuPlacerLaBombe][ligneOuPlacerLaBombe].setaUneBombe(true);
        }
    }

    /**
     * Méthode d'initialisation: calcul des bombes adjacentes à chaque cases
     * (méthode simple).
     */
    private void CalculDesBombesAdjacentes() {

        for (int numColCaseATraiter = 0; numColCaseATraiter < this.nombreColonnesPlateau; numColCaseATraiter++) {
            for (int numLigCaseATraiter = 0; numLigCaseATraiter < this.nombreLignesPlateau; numLigCaseATraiter++) {
                Case caseCourante = this.plateau[numColCaseATraiter][numLigCaseATraiter];
                if (numLigCaseATraiter != 0) {
                    if (numColCaseATraiter != 0) {
                        if (this.plateau[numColCaseATraiter - 1][numLigCaseATraiter - 1].getaUneBombe()) {
                            caseCourante.incrementerNBombesAdjacentes();
                        }
                    }
                    if (this.plateau[numColCaseATraiter][numLigCaseATraiter - 1].getaUneBombe()) {
                        caseCourante.incrementerNBombesAdjacentes();
                    }
                    if (numColCaseATraiter != this.nombreColonnesPlateau - 1) {
                        if (this.plateau[numColCaseATraiter + 1][numLigCaseATraiter - 1].getaUneBombe()) {
                            caseCourante.incrementerNBombesAdjacentes();
                        }
                    }
                }
                if (numLigCaseATraiter != this.nombreLignesPlateau - 1) {
                    if (numColCaseATraiter != 0) {
                        if (this.plateau[numColCaseATraiter - 1][numLigCaseATraiter + 1].getaUneBombe()) {
                            caseCourante.incrementerNBombesAdjacentes();
                        }
                    }
                    if (this.plateau[numColCaseATraiter][numLigCaseATraiter + 1].getaUneBombe()) {
                        caseCourante.incrementerNBombesAdjacentes();
                    }
                    if (numColCaseATraiter != this.nombreColonnesPlateau - 1) {
                        if (this.plateau[numColCaseATraiter + 1][numLigCaseATraiter + 1].getaUneBombe()) {
                            caseCourante.incrementerNBombesAdjacentes();
                        }
                    }
                }
                if (numColCaseATraiter != 0) {
                    if (this.plateau[numColCaseATraiter - 1][numLigCaseATraiter].getaUneBombe()) {
                        caseCourante.incrementerNBombesAdjacentes();
                    }
                }
                if (numColCaseATraiter != this.nombreColonnesPlateau - 1) {
                    if (this.plateau[numColCaseATraiter + 1][numLigCaseATraiter].getaUneBombe()) {
                        caseCourante.incrementerNBombesAdjacentes();
                    }
                }

            }
        }
    }

    // Getters et Setters:
    /**
     * Définition du statut de la partie.
     *
     * @param statutPartie nouveau statut
     */
    public void setStatutPartie(StatutPartie statutPartie) {
        this.statutPartie = statutPartie;
    }

    /**
     * Renvoie du statut de la partie.
     *
     * @return statutPartie, le statut de la partie.
     */
    public StatutPartie getStatutPartie() {
        return statutPartie;
    }

    // Méthodes génériques:
    /**
     * Méthode toString. Permet l'affichage en ascii-art du plateau Attention:
     * cette méthode ne peut afficher un plateau de dimensions supereurs à
     * 100*100
     *
     * @return aspect visuel du plateau en Ascii-art
     */
    @Override
    public String toString() {
        String plateauEnAsciiArt = "   ";
        int numeroLigneAAfficher = 0;
        // Génération de la première ligne (dizaines des colonnes)
        for (int parcoursDesColonnes = 0; parcoursDesColonnes < this.nombreColonnesPlateau; parcoursDesColonnes++) {
            plateauEnAsciiArt += Math.round(parcoursDesColonnes / 10);
            plateauEnAsciiArt += " ";
        }
        plateauEnAsciiArt += "\n   ";

        // Génération de la seconde ligne (unités des colonnes)
        for (int parcoursDesLignes = 0; parcoursDesLignes < this.nombreColonnesPlateau; parcoursDesLignes++) {
            plateauEnAsciiArt += parcoursDesLignes % 10;
            plateauEnAsciiArt += " ";
        }
        plateauEnAsciiArt += "\n";

        // Génération des lignes suivantes (dizaines et unités des lignes, suivi de la ligne de démineur)
        for (int parcoursDesLignes = 0; parcoursDesLignes < this.nombreLignesPlateau; parcoursDesLignes++) {
            if (parcoursDesLignes < 10) // traitement du cas où le numéro de la ligne à afficher est inférieur à 10: on ajoute un 0 afin de conserver l'alignement des dizaines
            {
                plateauEnAsciiArt += "0";
            }
            plateauEnAsciiArt += parcoursDesLignes;
            plateauEnAsciiArt += " ";
            for (int numeroCaseDeLaLigne = 0; numeroCaseDeLaLigne < this.nombreColonnesPlateau; numeroCaseDeLaLigne++) {
                plateauEnAsciiArt += this.plateau[numeroCaseDeLaLigne][parcoursDesLignes].toString();
                plateauEnAsciiArt += " ";
            }
            plateauEnAsciiArt += "\n";
        }

        return plateauEnAsciiArt;
    }

}
