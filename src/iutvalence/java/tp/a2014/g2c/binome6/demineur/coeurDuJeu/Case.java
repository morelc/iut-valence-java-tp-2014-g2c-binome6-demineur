package iutvalence.java.tp.a2014.g2c.binome6.demineur.coeurDuJeu;

import iutvalence.java.tp.a2014.g2c.binome6.demineur.annexes.StatutCase;
import static iutvalence.java.tp.a2014.g2c.binome6.demineur.annexes.StatutCase.*;

/**
 * Propriétés d'une case.
 *
 * @author BEGOT William <william.begot@iut-valence.fr>
 * @author MOREL Charles <charles.morel@iut-valence.fr>
 * @version 1.0
 */
public class Case {

    // Définition des attributs:
    /**
     * Présence d'une bombe.
     */
    private boolean aUneBombe;

    /**
     * Nombre de bombes adjacents à la case.
     *
     * Ce nombre est compris entre 0 et 8
     */
    private int aNBombesAdjacentes;

    /**
     * Etat de la case.
     *
     * La case peut etre sous 3 états: MARQUEE, MASQUEE ou DECOUVERTE
     */
    private StatutCase statutCase;

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
    private static final StatutCase STATUTCASE_DEFAUT = StatutCase.MASQUEE;

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

    // Définition des getters:
    /**
     * Obtenir le statut de la case en cours.
     *
     * @return statut de la case en cours (marquée, masquée ou à découvert)
     */
    public StatutCase getStatutCase()
    {
        return statutCase;
    }

    /**
     * Obtenir le statut de la bombe de la case en cours.
     *
     * @return statut de la bombe
     *         (true <=> a une bombe / false <=> n'a pas de
     *         bombe)
     */
    public boolean getaUneBombe()
    {
        return this.aUneBombe;
    }

    /**
     * Obtenir le nombre de bombes adjacentes à la case en cours.
     *
     * @return nombre de bombes adjacentes [0..8]
     */
    public int getaNBombesAdjacentes()
    {
        return aNBombesAdjacentes;
    }

    // Défintion des setters:
    /**
     * Modifier le statut de la case en cours de traitement.
     *
     * @param statutCase le nouveau statut de la case [MARQUEE, MASQUEE,
     *                   DECOUVERTE]
     */
    public void setStatutCase(StatutCase statutCase)
    {
        this.statutCase = statutCase;
    }

    /**
     * Modifier le statut de la bombe dans la case en cours de traitement.
     *
     * @param aUneBombe le nouveau statut de la bombe [true, false]
     */
    public void setaUneBombe(boolean aUneBombe)
    {
        this.aUneBombe = aUneBombe;
    }

    /**
     * Modifier le nombre de bombes adjacentes à la case en cours de traitement.
     *
     * @param aNBombesAdjacentes le nouveau nombre de bombes adjacentes [0..8]
     */
    public void setaNBombesAdjacentes(int aNBombesAdjacentes)
    {
        this.aNBombesAdjacentes = aNBombesAdjacentes;
    }

    // Définition des méthodes divers
    /**
     * Incrémenter le nombre de bombes adjacentes à la case en cours de
     * traitement.
     */
    public void incrementerNBombesAdjacentes()
    {
        this.aNBombesAdjacentes++;
    }

    /**
     * Méthode de test de case pour dé-couverture récursive.
     *
     * @return true si la case n'a aucune bombe adjacente et qu'elle n'est pas
     *         découverte
     */
    public boolean bombesAdjacentesNulEtCaseCouverte()
    {
        return ((this.aNBombesAdjacentes == 0) && (this.statutCase != StatutCase.DECOUVERTE));
    }

    // Définition des méthodes objet:
    /**
     * Méthode toString. Permet d'afficher un aperçu visuel de la case en
     * ascii-art: -> avec un # si la case est masquée -> avec un M si la case
     * est marquée -> avec un nombre la case est découverte et sans bombe ->
     * avec un X si la case est découverte et a une bombe (ce cas ne se produit
     * qu'à la fin de la partie)
     *
     * @return aspect visuel de la case en ascii-art
     */
    @Override
    public String toString()
    {
        if (this.statutCase == MASQUEE)
        {
            return "#";
        }
        if (this.statutCase == MARQUEE)
        {
            return "M";
        }
        if (this.statutCase == DECOUVERTE)
        {
            if (this.aUneBombe == false)
            {
                return Integer.toString(this.aNBombesAdjacentes);
            }
            else
            {
                return "X";
            }
        }
        return "Erreur";

    }

}
