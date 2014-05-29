package iutvalence.java.tp.a2014.g2c.binome6.demineur.IHM.Swing;

import iutvalence.java.tp.a2014.g2c.binome6.demineur.coeurDuJeu.Plateau;
import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 * Cette classe représente la grille de boutons du démineur.
 *
 * @author MOREL Charles
 */
public class GrilleDeDemineur extends JPanel {

    // Définition des attributs:
    /**
     * Référence vers la classe parent contenant (entre autres) la JFrame du
     * jeu.
     */
    private final IHMJoueurSWING refVersIHMJoueurSWING;

    /**
     * Référence vers le plateau du démineur.
     */
    private final Plateau refVersPlateau;

    /**
     * Tableau à double entrée représentant les références de tous les JButons
     * de la grille.
     */
    private final CaseDeDemineur[][] boutonsDeLaGrille;

    /**
     * Attribut correspondant à un ActionListener qui est utilisé pour écouter
     * les événements entrés (clic sur les boutons) de la grille.
     */
    private final EcouteBoutonsGrille ecouteurDesBoutonsDeLaGrille;

    /**
     * Attribut correspondant à un JPannel composé notement de deux boutons pour
     * sélectionner l'action à faire, ainsi qu'un timer et un compteur de bombes
     * restantes.
     */
    private final BoutonRadioSelectionAction refBoutonAction;

    // Définition du constructeur
    /**
     * Constructeur de la classe.
     *
     * @param refVersIHMJoueurSWING référence vers la classe parent contenant
     *                              (entre
     *                              autres) la JFrame du jeu.
     * @param refVersPlateau        référence vers le plateau du démineur.
     * @param refBoutonAction       référence vers la JPannel de sélection de
     *                              l'action à effectuer.
     */
    public GrilleDeDemineur(IHMJoueurSWING refVersIHMJoueurSWING, Plateau refVersPlateau, BoutonRadioSelectionAction refBoutonAction)
    {

        // Définition des attributs
        this.refVersIHMJoueurSWING = refVersIHMJoueurSWING;
        this.refVersPlateau = refVersPlateau;
        this.refBoutonAction = refBoutonAction;
        this.boutonsDeLaGrille = new CaseDeDemineur[this.refVersPlateau.getNombreColonnesPlateau()][this.refVersPlateau.getNombreLignesPlateau()];

        // Définition du layout
        this.setLayout(new GridLayout(this.refVersPlateau.getNombreLignesPlateau(), this.refVersPlateau.getNombreColonnesPlateau()));

        // Ajout des composants
        this.ecouteurDesBoutonsDeLaGrille = new EcouteBoutonsGrille(this);
        for (int ligneTraitement = 0; ligneTraitement < this.refVersPlateau.getNombreLignesPlateau(); ligneTraitement++)
        {
            for (int colonneTraitement = 0; colonneTraitement < this.refVersPlateau.getNombreColonnesPlateau(); colonneTraitement++)
            {
                this.boutonsDeLaGrille[colonneTraitement][ligneTraitement] = new CaseDeDemineur(this.refVersPlateau.getPlateau()[colonneTraitement][ligneTraitement]);
                this.boutonsDeLaGrille[colonneTraitement][ligneTraitement].addActionListener(this.ecouteurDesBoutonsDeLaGrille);
                this.boutonsDeLaGrille[colonneTraitement][ligneTraitement].setFocusable(false);
                this.add(this.boutonsDeLaGrille[colonneTraitement][ligneTraitement]);
            }
        }
    }

    // Définition des méthodes
    /**
     * Méthode de mise à jour des propriétés de tous les boutons de la grille en
     * fonction de la case qui leur correspond.
     */
    public void MettreAJourAffichageGrille()
    {
        for (int ligneTraitement = 0; ligneTraitement < this.refVersPlateau.getNombreLignesPlateau(); ligneTraitement++)
        {
            for (int colonneTraitement = 0; colonneTraitement < this.refVersPlateau.getNombreColonnesPlateau(); colonneTraitement++)
            {
                this.boutonsDeLaGrille[colonneTraitement][ligneTraitement].mettreAJourLeBouton();
            }
        }

    }

    // Getters:
    /**
     * Retourne le tableau à double entrés contenant les références mémoires des
     * JButons de la grille du plateau de démineur.
     *
     * @return tableau de CaseDeDemineur.
     */
    public CaseDeDemineur[][] getBoutonsDeLaGrille()
    {
        return boutonsDeLaGrille;
    }

    /**
     * Retourne la référence vers la classe parent contenant (entre autres) la
     * JFrame du jeu.
     *
     * @return Référence vers IHMJoueurSWING
     */
    public IHMJoueurSWING getRefVersIHMJoueurSWING()
    {
        return refVersIHMJoueurSWING;
    }

    /**
     * Retourne la référence vers le plateau.
     *
     * @return référence vers le plateau.
     */
    public Plateau getRefVersPlateau()
    {
        return refVersPlateau;
    }

    /**
     * Retourne la référence du JPannel des boutons d'action.
     *
     * @return référence du JPannel des boutons d'action.
     */
    public BoutonRadioSelectionAction getRefBoutonAction()
    {
        return refBoutonAction;
    }

}
