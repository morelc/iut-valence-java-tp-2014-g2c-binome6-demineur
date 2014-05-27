package iutvalence.java.tp.a2014.g2c.binome6.demineur.IHM.Swing;

import iutvalence.java.tp.a2014.g2c.binome6.demineur.IHM.IHMCreerParametresPartie;
import javax.swing.SwingUtilities;

/**
 * Classe contenant les paramètres de la partie. Elle permet de créer (en
 * IHM-SWING) les paramètres d'une partie.
 *
 * @author BEGOT William <william.begot@iut-valence.fr>
 * @author MOREL Charles <charles.morel@iut-valence.fr>
 * @version 1.0
 */
public class IHMCreerParametresPartieSWING implements IHMCreerParametresPartie
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
     * Panneau de paramètres.
     */
    private IHMFenetreParametresPartieSWING fenetreParametresPartie;

    /**
     * Fenetre d'accueil du jeu.
     */
    private IHMAccueilJeu fenetreAccueil;
    
    /**
     * Définition du statut par défaut de la partie avec plateau lors de sa
     * construction.
     */
    public IHMCreerParametresPartieSWING()
    {
        this.nombreBombesPlateau = NOMBRE_BOMBES_PLATEAU_DEFAULT;
        this.nombreColonnesPlateau = NOMBRE_COLONNES_PLATEAU_DEFAULT;
        this.nombreLignesPlateau = NOMBRE_LIGNES_PLATEAU_DEFAULT;
        this.fenetreParametresPartie = new IHMFenetreParametresPartieSWING(this);
        this.fenetreAccueil = new IHMAccueilJeu();
    }

    // Méthodes utilisables hors-classe:
    /**
     * Méthode de paramétrage de la partie (garder les paramètres par défaut ou
     * les modifier).
     */
    @Override
    public void parametrerPartie()
    {
        SwingUtilities.invokeLater(this.fenetreAccueil);
        while(this.fenetreAccueil.isFenetreOuverte())
        {
            System.out.print("");
        }
        if (!this.fenetreAccueil.isUtiliserLesParametresParDefaut())
        {
        SwingUtilities.invokeLater(this.fenetreParametresPartie);
        while(!this.fenetreParametresPartie.isTousLesDonnesSontEntrees())
        {
            System.out.print("");
        }
        }
    }

    // Getters
    /**
     * Obtenir le nombre de bombes à positionner sur le plateau.
     *
     * @return le nombreBombesPlateau
     */
    @Override
    public int getNombreBombesPlateau()
    {
        return nombreBombesPlateau;
    }

    /**
     * Obtenir le de colonnes du plateau.
     *
     * @return le nombreColonnesPlateau
     */
    @Override
    public int getNombreColonnesPlateau()
    {
        return nombreColonnesPlateau;
    }

    /**
     * Obtenir le de lignes du plateau.
     *
     * @return le nombreLignesPlateau
     */
    @Override
    public int getNombreLignesPlateau()
    {
        return nombreLignesPlateau;
    }

    /**
     * Paramétrer le nombre de Bombes.
     *
     * @param nombreBombesPlateau le nouveau nombre de bombes
     */
    public void setNombreBombesPlateau(int nombreBombesPlateau)
    {
        this.nombreBombesPlateau = nombreBombesPlateau;
    }

    /**
     * Paramétrer le nombre de Colonnes.
     *
     * @param nombreColonnesPlateau le nouveau nombre de colonnes
     */
    public void setNombreColonnesPlateau(int nombreColonnesPlateau)
    {
        this.nombreColonnesPlateau = nombreColonnesPlateau;
    }

    /**
     * Paramétrer le nombre de Lignes.      
     * @param nombreLignesPlateau le nouveau nombre de lignes.
     */
    public void setNombreLignesPlateau(int nombreLignesPlateau)
    {
        this.nombreLignesPlateau = nombreLignesPlateau;
    }
}
