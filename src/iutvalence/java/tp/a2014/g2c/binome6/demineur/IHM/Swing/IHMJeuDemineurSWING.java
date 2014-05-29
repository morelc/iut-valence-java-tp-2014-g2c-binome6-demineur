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
     * JFrame contenant les divers composants du jeu (JMenu, grille, JPanel de
     * choix d'action/minuteur/compteur mines restantes).
     */
    private JFrame fenetrePrincipaleDuJeu;

    /**
     * JPanel de choix d'action/minuteur/compteur mines restantes
     */
    private BoutonRadioSelectionAction boutonAction;

    // Définition du constructeur:
    public IHMJeuDemineurSWING(IHMJoueurSWING refVersIHMJoueurSWING, Plateau refVersPlateau)
    {
        this.refVersIHMJoueurSWING = refVersIHMJoueurSWING;
        this.refVersPlateau = refVersPlateau;
        this.boutonAction = new BoutonRadioSelectionAction(this.refVersPlateau);

    }
    // Définition des méthodes:
    /**
     * Implémentation de Runnable.
     * Permet de lancer le fenêtre JFrame principale du jeu (composants compris)
     */
    @Override
    public void run()
    {
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
        GrilleDeDemineur grille = new GrilleDeDemineur(this.refVersIHMJoueurSWING, this.refVersPlateau, this.boutonAction);
        JSplitPane splitGrilleRadioAction = new JSplitPane(JSplitPane.VERTICAL_SPLIT, grille, this.boutonAction);
        splitGrilleRadioAction.setEnabled(false);
        splitGrilleRadioAction.setBorder(null);
        splitGrilleRadioAction.setDividerSize(0);
        splitGrilleRadioAction.setResizeWeight(1);
        this.fenetrePrincipaleDuJeu.add(splitGrilleRadioAction);

        // Affichage de la fenetre
        this.fenetrePrincipaleDuJeu.setVisible(true);
    }

    // Getters
    public JFrame getFenetrePrincipaleDuJeu()
    {
        return fenetrePrincipaleDuJeu;
    }

    public BoutonRadioSelectionAction getBoutonAction()
    {
        return boutonAction;
    }

}
