package iutvalence.java.tp.a2014.g2c.binome6.demineur.IHM.Swing;

import iutvalence.java.tp.a2014.g2c.binome6.demineur.IHM.ASCII.*;
import iutvalence.java.tp.a2014.g2c.binome6.demineur.IHM.IHMJoueur;
import iutvalence.java.tp.a2014.g2c.binome6.demineur.annexes.InteractionCase;
import iutvalence.java.tp.a2014.g2c.binome6.demineur.annexes.StatutCase;
import iutvalence.java.tp.a2014.g2c.binome6.demineur.annexes.StatutPartie;
import iutvalence.java.tp.a2014.g2c.binome6.demineur.coeurDuJeu.Case;
import iutvalence.java.tp.a2014.g2c.binome6.demineur.coeurDuJeu.Plateau;

import iutvalence.java.tp.a2014.g2c.binome6.demineur.exceptions.NumColonneIncompatibleAvecLePlateauException;
import iutvalence.java.tp.a2014.g2c.binome6.demineur.exceptions.NumLigneIncompatibleAvecLePlateauException;
import java.util.InputMismatchException;

import java.util.Scanner;

/**
 * Classe des méthodes d'entrées et de sorties pour le joueur.
 *
 * @author BEGOT William <william.begot@iut-valence.fr>
 * @author MOREL Charles <charles.morel@iut-valence.fr>
 * @version 1.0
 */
public class IHMJoueurSWING implements IHMJoueur
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
    public IHMJoueurSWING()
    {
        this.derniereLigneEntree = DERNIERE_LIGNE_ENTREE_DEFAULT;
        this.derniereColonneEntree = DERNIERE_COLONNE_ENTREE_DEFAULT;
    }

    // Méthodes d'entrées
    /**
     * Méthode d'entrée du numéro d'une ligne.
     */
    private void entrerLigne(int nombreDeLignesDuPlateau) throws InputMismatchException, NumLigneIncompatibleAvecLePlateauException
    {
        System.out.println("Veuillez entrer le numéro de la ligne: ");
        this.derniereLigneEntree = 0;
        this.derniereLigneEntree = scanner.nextInt();
        if ((this.derniereLigneEntree >= nombreDeLignesDuPlateau) || (this.derniereLigneEntree < 0))
        {
            throw new NumLigneIncompatibleAvecLePlateauException();
        }
    }

    /**
     * Méthode d'entrée du numéro d'une colonne.
     */
    private void entrerColonne(int nombreDeColonnessDuPlateau) throws InputMismatchException, NumColonneIncompatibleAvecLePlateauException
    {
        System.out.println("Veuillez entrer le numéro de la colonne: ");
        this.derniereColonneEntree = 0;
        this.derniereColonneEntree = scanner.nextInt();
        if ((this.derniereColonneEntree >= nombreDeColonnessDuPlateau) || (this.derniereColonneEntree < 0))
        {
            throw new NumColonneIncompatibleAvecLePlateauException();
        }
    }

    /**
     * Méthode d'entrée des coordonnées d'une case du plateau.
     */
    private void entrerCoordonneesCase(Plateau plateauAModifier)
    {
        boolean entreeLigneValide = false;
        boolean entreeColonneValide = false;

        while (entreeLigneValide == false)
        {
            try
            {
                entrerLigne(plateauAModifier.getNombreLignesPlateau());
                entreeLigneValide = true;
            }
            catch (InputMismatchException e)
            {
                System.out.println("Erreur: vous n'avez pas entré de nombre!");
                scanner.nextLine();
            }
            catch (NumLigneIncompatibleAvecLePlateauException e)
            {
                System.out.println("Erreur: le numero de la ligne est invalide !");
                scanner.nextLine();
            }
        }

        while (entreeColonneValide == false)
        {
            try
            {
                entrerColonne(plateauAModifier.getNombreColonnesPlateau());
                entreeColonneValide = true;
            }
            catch (InputMismatchException e)
            {
                System.out.println("Erreur: vous n'avez pas entré de nombre!");
                scanner.nextLine();
            }
            catch (NumColonneIncompatibleAvecLePlateauException e)
            {
                System.out.println("Erreur: le numero de la colonne est invalide !");
                scanner.nextLine();
            }
        }
    }

    /**
     * Méthode d'entrée d'une action.
     */
    private void entrerUneAction()
    {
        char valeurDeLEntree;
        System.out.println("Veuillez entrer l'action à effectuer (m = Marquer, e = Enlever le marquage, d = Déminer) : ");
        do
        {
            String lecture = scanner.nextLine();
            if (lecture != null && lecture.length() > 0)
            {
                valeurDeLEntree = lecture.charAt(0);
            }
            else
            {
                valeurDeLEntree = 'x';
            }
        }
        while (valeurDeLEntree != 'm' && valeurDeLEntree != 'e' && valeurDeLEntree != 'd');

        switch (valeurDeLEntree)
        {
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
    private void appliquerActionSurCase(Plateau plateauAModifier)
    {
        Case CaseCourrante = plateauAModifier.plateau[this.derniereColonneEntree][this.derniereLigneEntree];

        // Traitement du cas où la case à modifier est déjà démasquée (donc aucune action n'est possible)
        if (CaseCourrante.getStatutCase() == StatutCase.DECOUVERTE)
        {
            System.out.println("Désolé mais la case entrée est déjà démasquée...");
        }
        else
        {
            // Traitement du cas où on veut marquer la case
            if (this.derniereActionEntree == InteractionCase.MARQUER)
            {
                CaseCourrante.setStatutCase(StatutCase.MARQUEE);
            }
            // Traitement du cas où on veut enlever le marquage de la case (retour au statut marquée)
            if (this.derniereActionEntree == InteractionCase.ENLEVER_MARQUAGE)
            {
                CaseCourrante.setStatutCase(StatutCase.MASQUEE);
            }
            // Traitaent du cas où on veut déminer la case
            if (this.derniereActionEntree == InteractionCase.DEMINER)
            {
                deminerCase(plateauAModifier);
            }
        }
    }

    /**
     * Méthode de déminage d'une case.
     *
     * Permet de déminer une case.
     *
     * @param plateauAModifier plateau où déminer la case
     */
    private void deminerCase(Plateau plateauAModifier)
    {
        Case caseCourrante = plateauAModifier.plateau[this.derniereColonneEntree][this.derniereLigneEntree];
        // traitement du cas où la case a une bombe
        if (caseCourrante.getaUneBombe())
        {
            plateauAModifier.setStatutPartie(StatutPartie.ESTPERDUE);
            caseCourrante.setStatutCase(StatutCase.DECOUVERTE);
        }
        // traitement du cas où la case n'a pas de bombe
        if (!caseCourrante.getaUneBombe())
        {
            // traitement du cas où la case n'a pas de bombe adjacente (appelle la fonction qui découvre récursivement toutes les cases adjacentes qui n'ont pas de bombe ajacente)
            if (caseCourrante.bombesAdjacentesNulEtCaseCouverte())
            {
                plateauAModifier.traitementRecursifCasesSansMineAdjacentesPlateau(this.derniereColonneEntree, this.derniereLigneEntree);
            }
            // traitemenu du cas où la case a à partir d'une bombe adjacente 
            else
            {
                caseCourrante.setStatutCase(StatutCase.DECOUVERTE);
            }
        }

    }

    private void verifierStatutPartie(Plateau plateauAModifier)
    {
        plateauAModifier.mettreAJourStatutPartie();
        if ((plateauAModifier.getStatutPartie() == StatutPartie.ESTPERDUE) || (plateauAModifier.getStatutPartie() == StatutPartie.ESTGAGNEE))
        {
            for (int numColCaseADecouvrir = 0; numColCaseADecouvrir < plateauAModifier.getNombreColonnesPlateau(); numColCaseADecouvrir++)
            {
                for (int numLigCaseADecouvrir = 0; numLigCaseADecouvrir < plateauAModifier.getNombreLignesPlateau(); numLigCaseADecouvrir++)
                {
                    plateauAModifier.plateau[numColCaseADecouvrir][numLigCaseADecouvrir].setStatutCase(StatutCase.DECOUVERTE);
                }
            }
            System.out.println(plateauAModifier.toString());
            if (plateauAModifier.getStatutPartie() == StatutPartie.ESTPERDUE)
            {
                System.out.println("Vous avez perdu!");
            }
            else
            {
                System.out.println("Bravo! Vous avez gagné!");
            }
        }
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
    public void interactionJoueur(Plateau plateauAModifier)
    {
        System.out.println(plateauAModifier.toString());
        entrerUneAction();
        entrerCoordonneesCase(plateauAModifier);
        appliquerActionSurCase(plateauAModifier);
        verifierStatutPartie(plateauAModifier);
    }

}
