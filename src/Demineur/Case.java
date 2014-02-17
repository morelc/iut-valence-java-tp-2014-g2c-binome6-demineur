package Demineur;

/**
 *C'est une classe définissant les propriétés d'une case lambda.
 * @author begotw
 */
public class Case {
    
    // Définition des types:
    
    /**
     * Définition du type pour la définition du statut d'une case.
     */
    public enum statutPossibleDeCase{
        enCours,
        estGagnee,
        estPerdue;
    }

    // Définition des varaibles
 
    /**
     * Variable définissant si la case contient ou non une bombe.
     */
    private boolean aUneBombe;
    /**
     * Variable définissant le nombre de bombes adjacents à la case.
     * Ce nombre est compris entre 0 et 8
     */
    private int aNBombesAdjacentes;
    /**
     * Variable définissant l'état de la case.
     * La case peut etre sous 3 états: marquee, masquee ou decouvert  
     */
    private statutPossibleDeCase statutCase;
    
    
    
}
