package demineur;

/**
 * C'est une classe définissant les propriétés d'une case lambda.
 *
 * @author begotw
 */
public class Case
{

    // Définition des types:
    /**
     * Définition du type pour la définition du statut d'une case.
     */
    private enum statutPossibleDeCase
    {

        marquee,
        masquee,
        decouvert;
    }

    // Définition des varaibles:
    /**
     * Variable définissant si la case contient ou non une bombe.
     */
    private boolean aUneBombe;
    /**
     * Variable définissant le nombre de bombes adjacents à la case. Ce nombre
     * est compris entre 0 et 8
     */
    private int aNBombesAdjacentes;
    /**
     * Variable définissant l'état de la case. La case peut etre sous 3 états:
     * marquee, masquee ou decouvert
     */
    private statutPossibleDeCase statutCase;

    // Définition des varaibles par défaut:
    /**
     * Variable définissant la valeur par défaut si la case a une bombe ou non.
     */
    private static final boolean AUNEBOMBE_DEFAUT = false;
    /**
     * Variable définissant la valeur par défaut du nombre de bombes adjacents
     * d'une case.
     */
    private static final int ANBOMBESADJACENTES_DEFAUT = 0;
    /**
     * Variable définissant l'état par défaut d'une case.
     */
    private static final statutPossibleDeCase STATUTCASE_DEFAUT = statutPossibleDeCase.masquee;

    // Définition des constructeurs:
    /**
     * Définition du constructeur de base.
     */
    public Case() {
        this.aUneBombe = Case.AUNEBOMBE_DEFAUT;
        this.aNBombesAdjacentes = Case.ANBOMBESADJACENTES_DEFAUT;
        this.statutCase = Case.STATUTCASE_DEFAUT;
    }

    // Définition des accesseurs
    /**
     * Methode de lecteure du statut de la case.
     *
     * @return la valeur de StatutCase
     */
    public statutPossibleDeCase getStatutCase() {
        return statutCase;
    }

    /**
     * Méthode de définition du Statut de la case.
     *
     * @param statutCase la valeur de StatutCase à enregistrer
     */
    public void setStatutCase(statutPossibleDeCase statutCase) {
        this.statutCase = statutCase;
    }

    /**
     * Méthode de lecture du contenu de la case: avec ou sans bombe.
     *
     * @return La valeur de aUneBombe
     */
    public boolean getaUneBombe() {
        return aUneBombe;
    }

    /**
     * @param aUneBombe La valeur de aUneBombe à enregistrer
     */
    public void setaUneBombe(boolean aUneBombe) {
        this.aUneBombe = aUneBombe;
    }
}
