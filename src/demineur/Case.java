package demineur;

/**
 * Propriétés d'une case.
 *
 * @author TODO
 * @version TODO
 */
public class Case
{

    // Définition des types:

    /** Statut d'une case. */
    /* TODO Private ??? Avec un return et des parametres de ce type dans les méthodes ? */
    private enum statutPossibleDeCase
    {

        marquee,
        masquee,
        decouvert;
    }

    // Définition des varaibles:
    /** Présence d'une bombe. */
    private boolean              aUneBombe;
    /**
     * Nombre de bombes adjacents à la case.
     * <p/>
     * Ce nombre est compris entre 0 et 8
     */
    private int                  aNBombesAdjacentes;
    /**
     * Etat de la case.
     * <p/>
     * La case peut etre sous 3 états: marquee, masquee ou decouvert
     */
    private statutPossibleDeCase statutCase;

    // Définition des varaibles par défaut:
    /** Valeur par défaut de la présence d'une bombe. */
    private static final boolean              AUNEBOMBE_DEFAUT          = false;
    /** Nombre de bombes adjacents d'une case. */
    private static final int                  ANBOMBESADJACENTES_DEFAUT = 0;
    /** Etat par défaut d'une case. */
    private static final statutPossibleDeCase STATUTCASE_DEFAUT         = statutPossibleDeCase.masquee;

    // Définition des constructeurs:

    /** Constructeur de base. */
    public Case() {
        this.aUneBombe = Case.AUNEBOMBE_DEFAUT;
        this.aNBombesAdjacentes = Case.ANBOMBESADJACENTES_DEFAUT;
        this.statutCase = Case.STATUTCASE_DEFAUT;
    }

    // Définition des accesseurs

    /**
     * Lecture du statut de la case.
     *
     * @return Valeur de StatutCase
     */
    /* TODO Franglais ! */
    public statutPossibleDeCase getStatutCase() {
        return statutCase;
    }

    /**
     * Définition du statut de la case.
     *
     * @param statutCase Valeur de StatutCase à enregistrer
     */
    /* TODO Franglais ! */
    public void setStatutCase(statutPossibleDeCase statutCase) {
        this.statutCase = statutCase;
    }

    /**
     * Lecture du contenu de la case: avec ou sans bombe.
     *
     * @return La valeur de aUneBombe
     */
    /* TODO Franglais ! */
    public boolean getaUneBombe() {
        return aUneBombe;
    }

    /**
     * Lecture du contenu de la case: avec ou sans bombe.
     *
     * @return La valeur de aUneBombe
     */
    /* TODO Franglais ! */
    public void setaUneBombe(boolean aUneBombe) {
        this.aUneBombe = aUneBombe;
    }
}
