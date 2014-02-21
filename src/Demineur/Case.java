/* TODO Convention du java : les noms de package ne comportent pas de majuscules. */
package Demineur;

/**
 * C'est une classe définissant les propriétés d'une case lambda.
 *
 * @author begotw
 */
public class Case {
    /* TODO Convention du Java : les noms de classes commencent par des majuscules. */
    /* TODO Convention du Java : les valeurs des enum comme les constantes (ce qu'ils sont) ont des noms en majuscule */
    /**
     * Définition du type pour la définition du statut d'une case.
     */
    private enum statutPossibleDeCase {

        marquee,
        masquee,
        decouvert;
    }

    /**
     * Variable définissant si la case contient ou non une bombe.
     */
    private boolean              aUneBombe;
    /**
     * Variable définissant le nombre de bombes adjacents à la case. Ce nombre
     * est compris entre 0 et 8
     */
    private int                  aNBombesAdjacentes;
    /**
     * Variable définissant l'état de la case. La case peut etre sous 3 états:
     * marquee, masquee ou decouvert
     */
    private statutPossibleDeCase statutCase;

    // Définition des varaibles par défaut:
    /**
     * Variable définissant la valeur par défaut si la case a une bombe ou non.
     */
    private static final boolean              AUNEBOMBE_DEFAUT          = false;
    /**
     * Variable définissant la valeur par défaut du nombre de bombes adjacents
     * d'une case.
     */
    private static final int                  ANBOMBESADJACENTES_DEFAUT = 0;
    /**
     * Variable définissant l'état par défaut d'une case.
     */
    private static final statutPossibleDeCase STATUTCASE_DEFAUT         = statutPossibleDeCase.masquee;

    // Définition des constructeurs:

    /**
     * Définition du constructeur de base.
     */
    public Case() {
        this.aUneBombe = Case.AUNEBOMBE_DEFAUT;
        this.aNBombesAdjacentes = Case.ANBOMBESADJACENTES_DEFAUT;
        this.statutCase = Case.STATUTCASE_DEFAUT;
    }

}
