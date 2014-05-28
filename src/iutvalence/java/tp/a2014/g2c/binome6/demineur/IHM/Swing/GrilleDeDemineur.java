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

    private final IHMJoueurSWING refVersIHMJoueurSWING;

    private final Plateau refVersPlateau;

    private final CaseDeDemineur[][] boutonsDeLaGrille;

    private final EcouteBoutonsGrille ecouteurDesBoutonsDeLaGrille;
    
    private final BoutonRadioSelectionAction refBoutonAction;

    public GrilleDeDemineur(IHMJoueurSWING refVersIHMJoueurSWING, Plateau refVersPlateau, BoutonRadioSelectionAction refBoutonAction) {
        
        // Définition des variables
        this.refVersIHMJoueurSWING = refVersIHMJoueurSWING;
        this.refVersPlateau = refVersPlateau;
        this.refBoutonAction = refBoutonAction;
        this.boutonsDeLaGrille = new CaseDeDemineur[this.refVersPlateau.getNombreColonnesPlateau()][this.refVersPlateau.getNombreLignesPlateau()];

        // Définition du layout
        this.setLayout(new GridLayout(this.refVersPlateau.getNombreLignesPlateau(), this.refVersPlateau.getNombreColonnesPlateau()));
        
        // Ajout des composants
        this.ecouteurDesBoutonsDeLaGrille = new EcouteBoutonsGrille(this);
        for (int ligneTraitement = 0; ligneTraitement < this.refVersPlateau.getNombreLignesPlateau(); ligneTraitement++) {
            for (int colonneTraitement = 0; colonneTraitement < this.refVersPlateau.getNombreColonnesPlateau(); colonneTraitement++) {
                this.boutonsDeLaGrille[colonneTraitement][ligneTraitement] = new CaseDeDemineur(colonneTraitement, ligneTraitement, this.refVersPlateau.getPlateau()[colonneTraitement][ligneTraitement]);
                this.boutonsDeLaGrille[colonneTraitement][ligneTraitement].addActionListener(this.ecouteurDesBoutonsDeLaGrille);
                this.boutonsDeLaGrille[colonneTraitement][ligneTraitement].setFocusable(false);
                this.add(this.boutonsDeLaGrille[colonneTraitement][ligneTraitement]);
            }
        }
    }

    public void MettreAJourAffichageGrille() {
        for (int ligneTraitement = 0; ligneTraitement < this.refVersPlateau.getNombreLignesPlateau(); ligneTraitement++) {
            for (int colonneTraitement = 0; colonneTraitement < this.refVersPlateau.getNombreColonnesPlateau(); colonneTraitement++) {
                this.boutonsDeLaGrille[colonneTraitement][ligneTraitement].mettreAJourLeBouton();
            }
        }

    }

    public CaseDeDemineur[][] getBoutonsDeLaGrille() {
        return boutonsDeLaGrille;
    }

    public IHMJoueurSWING getRefVersIHMJoueurSWING() {
        return refVersIHMJoueurSWING;
    }

    public Plateau getRefVersPlateau() {
        return refVersPlateau;
    }

    public BoutonRadioSelectionAction getRefBoutonAction() {
        return refBoutonAction;
    }
}
