package iutvalence.java.tp.a2014.g2c.binome6.demineur.IHM.Swing;

import iutvalence.java.tp.a2014.g2c.binome6.demineur.annexes.ProprietesEcran;
import iutvalence.java.tp.a2014.g2c.binome6.demineur.coeurDuJeu.Plateau;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JSplitPane;

/**
 * Classe utilisée pour afficher la fenêtre SWING du jeu.
 *
 * @author MOREL Charles
 */
class IHMJeuDemineurSWING implements Runnable {

    private final IHMJoueurSWING refVersIHMJoueurSWING;

    private final Plateau refVersPlateau;

    private JFrame fenetrePrincipaleDuJeu;

    public IHMJeuDemineurSWING(IHMJoueurSWING refVersIHMJoueurSWING, Plateau refVersPlateau) {
        this.refVersIHMJoueurSWING = refVersIHMJoueurSWING;
        this.refVersPlateau = refVersPlateau;
    }

    @Override
    public void run() {
        // Initialisation de la JFrame
        this.fenetrePrincipaleDuJeu = new JFrame();
        ImageIcon iconeDuJeu = new ImageIcon("./src/iutvalence/java/tp/a2014/g2c/binome6/demineur/IHM/Swing/iconeDuJeu.png");
        this.fenetrePrincipaleDuJeu.setIconImage(iconeDuJeu.getImage());
        this.fenetrePrincipaleDuJeu.setTitle("Démineur");
        this.fenetrePrincipaleDuJeu.setSize(this.refVersPlateau.getNombreColonnesPlateau() * 45, (this.refVersPlateau.getNombreLignesPlateau() * 45) + 60);
        this.fenetrePrincipaleDuJeu.setMinimumSize(new Dimension(200, 200));
        this.fenetrePrincipaleDuJeu.setMaximumSize(new Dimension(ProprietesEcran.ObtenirLaLargeurMaximaleDeLaFenetre(), ProprietesEcran.ObtenirLaHauteurMaximaleDeLaFenetre()));
        this.fenetrePrincipaleDuJeu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.fenetrePrincipaleDuJeu.setResizable(true);
        this.fenetrePrincipaleDuJeu.setLocation(ProprietesEcran.ObtenirLlePointXDAncrageOptimaleDeLaFenetre(this.refVersPlateau.getNombreColonnesPlateau() * 45), ProprietesEcran.ObtenirLlePointYDAncrageOptimaleDeLaFenetre(this.refVersPlateau.getNombreLignesPlateau() * 45));

        // Barre de menu de la JFrame:
        this.fenetrePrincipaleDuJeu.setJMenuBar(new BarreDeMenuFenetre(this));

        // Contenu de la JFrame
        BoutonRadioSelectionAction boutonAction = new BoutonRadioSelectionAction();
        GrilleDeDemineur grille = new GrilleDeDemineur(this.refVersIHMJoueurSWING, this.refVersPlateau, boutonAction);
        JSplitPane splitGrilleRadioAction = new JSplitPane(JSplitPane.VERTICAL_SPLIT, grille, boutonAction);
        splitGrilleRadioAction.setEnabled(false);
        splitGrilleRadioAction.setBorder(null);
        splitGrilleRadioAction.setDividerSize(0);
        splitGrilleRadioAction.setResizeWeight(1);
        this.fenetrePrincipaleDuJeu.add(splitGrilleRadioAction);

        // Affichage de la fenetre
        this.fenetrePrincipaleDuJeu.setVisible(true);
    }

    public JFrame getFenetrePrincipaleDuJeu() {
        return fenetrePrincipaleDuJeu;
    }

}
