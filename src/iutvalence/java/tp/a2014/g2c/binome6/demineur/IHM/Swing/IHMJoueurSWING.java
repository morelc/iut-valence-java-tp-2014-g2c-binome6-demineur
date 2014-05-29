package iutvalence.java.tp.a2014.g2c.binome6.demineur.IHM.Swing;

import iutvalence.java.tp.a2014.g2c.binome6.demineur.IHM.IHMJoueur;
import iutvalence.java.tp.a2014.g2c.binome6.demineur.annexes.InteractionCase;
import iutvalence.java.tp.a2014.g2c.binome6.demineur.annexes.StatutCase;
import iutvalence.java.tp.a2014.g2c.binome6.demineur.annexes.StatutPartie;
import iutvalence.java.tp.a2014.g2c.binome6.demineur.coeurDuJeu.Case;
import iutvalence.java.tp.a2014.g2c.binome6.demineur.coeurDuJeu.Plateau;
import javax.swing.SwingUtilities;

/**
 * Classe des méthodes d'entrées et de sorties pour le joueur.
 *
 * @author BEGOT William <william.begot@iut-valence.fr>
 * @author MOREL Charles <charles.morel@iut-valence.fr>
 * @version 1.0
 */
public class IHMJoueurSWING implements IHMJoueur {

    // Définition des variables:
    private IHMJeuDemineurSWING ecranDeJeu;

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
    public void appliquerActionSurCase(Plateau plateauAModifier, int colonneCaseSelectionnee, int ligneCaseSelectionnee, InteractionCase actionSelectionnee) {
        Case CaseCourrante = plateauAModifier.getPlateau()[colonneCaseSelectionnee][ligneCaseSelectionnee];

        // Traitement du cas où on veut marquer la case
        if (actionSelectionnee == InteractionCase.MARQUER) {
            CaseCourrante.setStatutCase(StatutCase.MARQUEE);
        }
        // Traitement du cas où on veut enlever le marquage de la case (retour au statut marquée)
        if (actionSelectionnee == InteractionCase.ENLEVER_MARQUAGE) {
            CaseCourrante.setStatutCase(StatutCase.MASQUEE);
        }
        // Traitaent du cas où on veut déminer la case
        if (actionSelectionnee == InteractionCase.DEMINER) {
            deminerCase(plateauAModifier, colonneCaseSelectionnee, ligneCaseSelectionnee);
        }

    }

    /**
     * Méthode de déminage d'une case.
     *
     * Permet de déminer une case.
     *
     * @param plateauAModifier plateau où déminer la case
     * @param colonneCase la colonne de la case à déminer
     * @param ligneCase la ligne de la case à déminer
     */
    private void deminerCase(Plateau plateauAModifier, int colonneCase, int ligneCase) {
        Case caseCourrante = plateauAModifier.getPlateau()[colonneCase][ligneCase];
        // traitement du cas où la case a une bombe
        if (caseCourrante.getaUneBombe()) {
            plateauAModifier.setStatutPartie(StatutPartie.ESTPERDUE);
            caseCourrante.setStatutCase(StatutCase.DECOUVERTE);
        }
        // traitement du cas où la case n'a pas de bombe
        if (!caseCourrante.getaUneBombe()) {
            // traitement du cas où la case n'a pas de bombe adjacente (appelle la fonction qui découvre récursivement toutes les cases adjacentes qui n'ont pas de bombe ajacente)
            if (caseCourrante.bombesAdjacentesNulEtCaseCouverte()) {
                plateauAModifier.traitementRecursifCasesSansMineAdjacentesPlateau(colonneCase, ligneCase);
            } // traitemenu du cas où la case a à partir d'une bombe adjacente 
            else {
                caseCourrante.setStatutCase(StatutCase.DECOUVERTE);
            }
        }

    }

    public boolean verifierStatutPartie(Plateau plateauAModifier) {
        plateauAModifier.mettreAJourStatutPartie();
        if (plateauAModifier.getStatutPartie() != StatutPartie.ENCOURS) {
            for (int numColCaseADecouvrir = 0; numColCaseADecouvrir < plateauAModifier.getNombreColonnesPlateau(); numColCaseADecouvrir++) {
                for (int numLigCaseADecouvrir = 0; numLigCaseADecouvrir < plateauAModifier.getNombreLignesPlateau(); numLigCaseADecouvrir++) {
                    if (plateauAModifier.getPlateau()[numColCaseADecouvrir][numLigCaseADecouvrir].getaUneBombe())
                        plateauAModifier.getPlateau()[numColCaseADecouvrir][numLigCaseADecouvrir].setStatutCase(StatutCase.DECOUVERTE);
                }
            }
            return true;
        }
        return false;
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
    @Override
    public void interactionJoueur(Plateau plateauAModifier) {
        this.ecranDeJeu = new IHMJeuDemineurSWING(this, plateauAModifier);
        SwingUtilities.invokeLater(this.ecranDeJeu);
        while (plateauAModifier.getStatutPartie() == StatutPartie.ENCOURS)
        {
            this.ecranDeJeu.getBoutonAction().mettreAJourLeTimer();
        }
        System.out.println("");
    }

    // Getters:
    public IHMJeuDemineurSWING getEcranDeJeu() {
        return ecranDeJeu;
    }

}
