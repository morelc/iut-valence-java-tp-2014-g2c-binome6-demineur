package demineur;

import demineur.annexes.StatutPossibleDeCase;

/**
 * Propriétés d'une case.
 *
 * @author BEGOT William <william.begot@iut-valence.fr>
 * @version 0.1
 */
public class Case
{

    // Définition des varaibles:
    /**
     * Présence d'une bombe.
     */
    private boolean aUneBombe;
    /**
     * Nombre de bombes adjacents à la case.
     * <p/>
     * Ce nombre est compris entre 0 et 8
     */
    private int aNBombesAdjacentes;
    /**
     * Etat de la case.
     * <p/>
     * La case peut etre sous 3 états: marquee, masquee ou decouvert
     */
    private StatutPossibleDeCase statutCase;

    // Définition des varaibles par défaut:
    /**
     * Valeur par défaut de la présence d'une bombe.
     */
    private static final boolean AUNEBOMBE_DEFAUT = false;
    /**
     * Nombre de bombes adjacents d'une case.
     */
    private static final int ANBOMBESADJACENTES_DEFAUT = 0;
    /**
     * Etat par défaut d'une case.
     */
    private static final StatutPossibleDeCase STATUTCASE_DEFAUT = StatutPossibleDeCase.masquee;

    // Définition des constructeurs:
    /**
     * Constructeur de base.
     */
    public Case()
    {
        this.aUneBombe = Case.AUNEBOMBE_DEFAUT;
        this.aNBombesAdjacentes = Case.ANBOMBESADJACENTES_DEFAUT;
        this.statutCase = Case.STATUTCASE_DEFAUT;
    }

    // Définition des getters
    /**
     * Lecture du statut de la case.
     *
     * @return Valeur de StatutCase
     */
    public StatutPossibleDeCase getStatutCase()
    {
        return statutCase;
    }

    /**
     * Lecture du contenu de la case: avec ou sans bombe.
     *
     * @return La valeur de aUneBombe
     */
    public boolean getaUneBombe()
    {
        return isaUneBombe();
    }

    /**
     * @return the aNBombesAdjacentes
     */
    public int getaNBombesAdjacentes()
    {
        return aNBombesAdjacentes;
    }

    // Définition des setters
    /**
     * Définition du statut de la case.
     *
     * @param statutCase Valeur de StatutCase à enregistrer
     */
    /* TODO Franglais ! */
    public void setStatutCase(StatutPossibleDeCase statutCase)
    {
        this.statutCase = statutCase;
    }

    /**
     * Lecture du contenu de la case: avec ou sans bombe.
     *
     * @return La valeur de aUneBombe
     */
    /* TODO Franglais ! */
    public void setaUneBombe(boolean aUneBombe)
    {
        this.aUneBombe = aUneBombe;
    }

    /**
     * @return the aUneBombe
     */
    public boolean isaUneBombe()
    {
        return aUneBombe;
    }

    /**
     * @param aNBombesAdjacentes the aNBombesAdjacentes to set
     */
    public void setaNBombesAdjacentes(int aNBombesAdjacentes)
    {
        this.aNBombesAdjacentes = aNBombesAdjacentes;
    }

}
