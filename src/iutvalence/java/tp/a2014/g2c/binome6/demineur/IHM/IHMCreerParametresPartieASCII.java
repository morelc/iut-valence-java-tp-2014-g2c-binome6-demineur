package iutvalence.java.tp.a2014.g2c.binome6.demineur.IHM;

import iutvalence.java.tp.a2014.g2c.binome6.demineur.exceptions.SaisieDimensionTableauInvalideException;
import iutvalence.java.tp.a2014.g2c.binome6.demineur.exceptions.SaisieNbBombesPlateauInvalideException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe contenant les paramètres de la partie.
 * Elle permet de créer (en IHM-ASCII) les paramètres d'une partie.
 * 
 * @author BEGOT William <william.begot@iut-valence.fr>
 * @author MOREL Charles <charles.morel@iut-valence.fr>
 * @version 1.0
 */
public class IHMCreerParametresPartieASCII implements IHMCreerParametresPartie
{
    
    // Définition des variables
    /**
     * Variable définissant le nombre de bombes dans le plateau.
     */
    private int nombreBombesPlateau;

    /**
     * Variable définissant le nombre de colonnes du plateau.
     */
    private int nombreColonnesPlateau;

    /**
     * Variable définissant le nombre de lignes du plateau.
     */
    private int nombreLignesPlateau;
    
   /**
     * Scanner d'entrées du joueur.
     */
    Scanner scanner = new Scanner(System.in);
    /**
     * Variable définissant le nombre de bombes dans le plateau par défaut.
     */
    private final static int NOMBRE_BOMBES_PLATEAU_DEFAULT = 10;

    /**
     * Variable définissant le nombre de colonnes du plateau par défaut.
     */
    private final static int NOMBRE_COLONNES_PLATEAU_DEFAULT = 10;

    /**
     * Variable définissant le nombre de lignes du plateau par défaut.
     */
    private final static int NOMBRE_LIGNES_PLATEAU_DEFAULT = 10;
    
    /**
     * Définition du statut par défaut de la partie avec plateau lors de sa construction.
     */
    
    public IHMCreerParametresPartieASCII()
    {
        this.nombreBombesPlateau = NOMBRE_BOMBES_PLATEAU_DEFAULT;
        this.nombreColonnesPlateau = NOMBRE_COLONNES_PLATEAU_DEFAULT;
        this.nombreLignesPlateau = NOMBRE_LIGNES_PLATEAU_DEFAULT;
    }
    
    // Méthodes d'entrées de paramètres:

    /**
     * Méthode permettant de modifier les paramètres de la partie.
     */
    private void modifierparametres()
    {
        boolean entreeLargeurTableauValide = false;
        boolean entreeHauteurTableauValide = false;
        boolean entreeNbBombesTableauValide = false;
        
        while (entreeLargeurTableauValide == false)
        {
            try
            {
                saisirLargeurPlateau();
                entreeLargeurTableauValide = true;
            }
            catch (InputMismatchException e)
            {
                System.out.println("Erreur: vous n'avez pas entré de nombre!");
                scanner.nextLine();
            }
            catch (SaisieDimensionTableauInvalideException e)
            {
                System.out.println("Erreur: la largeur du tableau est invalide !");
                scanner.nextLine();
            }
        }

        while (entreeHauteurTableauValide == false)
        {
            try
            {
                saisirHauteurPlateau();
                entreeHauteurTableauValide = true;
            }
            catch (InputMismatchException e)
            {
                System.out.println("Erreur: vous n'avez pas entré de nombre!");
                scanner.nextLine();
            }
            catch (SaisieDimensionTableauInvalideException e)
            {
                System.out.println("Erreur: la hauteur du tableau est invalide !");
                scanner.nextLine();
            }
        }

        while (entreeNbBombesTableauValide == false)
        {
            try
            {
                saisirNbBombesPlateau();
                entreeNbBombesTableauValide = true;
            }
            catch (InputMismatchException e)
            {
                System.out.println("Erreur: vous n'avez pas entré de nombre!");
                scanner.nextLine();
            }
            catch (SaisieNbBombesPlateauInvalideException e)
            {
                System.out.println("Erreur: le nombre de bombes est invalide !");
                scanner.nextLine();
            }
        }


    }

    /**
     * Méthode de saisie de la largeur du tableau.
     */
    private void saisirLargeurPlateau() throws InputMismatchException, SaisieDimensionTableauInvalideException
    {
        System.out.println("Veuillez entrer la largeur du plateau: (entre 5 et 100)");
        this.nombreColonnesPlateau = 0;
        this.nombreColonnesPlateau = scanner.nextInt();
        if ((this.getNombreColonnesPlateau() >= 100) || (this.getNombreColonnesPlateau() < 5))
        {
            throw new SaisieDimensionTableauInvalideException();
        }
    }
    
        /**
     * Méthode de saisie de la hauteur du tableau.
     */
    private void saisirHauteurPlateau() throws InputMismatchException, SaisieDimensionTableauInvalideException
    {
        System.out.println("Veuillez entrer la hauteur du plateau: (entre 5 et 100)");
        this.nombreLignesPlateau = 0;
        this.nombreLignesPlateau = scanner.nextInt();
        if ((this.getNombreLignesPlateau() >= 100) || (this.getNombreLignesPlateau() < 5))
        {
            throw new SaisieDimensionTableauInvalideException();
        }
    }
    
          /**
     * Méthode de saisie du nombre de bombes sur le tableau.
     */
    private void saisirNbBombesPlateau() throws InputMismatchException, SaisieNbBombesPlateauInvalideException
    {
        System.out.println("Veuillez entrer le nombre de bombes du pateau: (entre 5 et 100)");
        this.nombreBombesPlateau = 0;
        this.nombreBombesPlateau = scanner.nextInt();
        if ((this.getNombreBombesPlateau() >= 100) || (this.getNombreBombesPlateau() < 5) ||(this.getNombreBombesPlateau() > (this.getNombreColonnesPlateau()*this.getNombreLignesPlateau())))
        {
            throw new SaisieNbBombesPlateauInvalideException();
        }
    }
    
    // Méthodes utilisables hors-classe:
    /**
     * Méthode de paramétrage de la partie (garder les paramètres par défaut ou les modifier).
     */
    @Override
    public void parametrerPartie(){
            char valeurDeLEntree;
        System.out.println("Voulez-vous garder les paramètres par défaut (10 bombes sur un plateau de 10*10 cases) ? o = oui / n = non ");
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
        while (valeurDeLEntree != 'o' && valeurDeLEntree != 'n');

        if(valeurDeLEntree=='n'){
            modifierparametres();
        }
    }

    // Getters
    /**
     * Obtenir le nombre de bombes à positionner sur le plateau.
     * @return le nombreBombesPlateau
     */
    @Override
    public int getNombreBombesPlateau()
    {
        return nombreBombesPlateau;
    }

    /**
     * Obtenir le de colonnes du plateau.
     * @return le nombreColonnesPlateau
     */
    @Override
    public int getNombreColonnesPlateau()
    {
        return nombreColonnesPlateau;
    }

    /**
     * Obtenir le de lignes du plateau.
     * @return le nombreLignesPlateau
     */
    @Override
    public int getNombreLignesPlateau()
    {
        return nombreLignesPlateau;
    }
}
