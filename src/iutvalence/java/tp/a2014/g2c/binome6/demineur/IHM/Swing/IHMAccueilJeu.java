package iutvalence.java.tp.a2014.g2c.binome6.demineur.IHM.Swing;

import iutvalence.java.tp.a2014.g2c.binome6.demineur.annexes.ProprietesEcran;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

/**
 * Classe utilisée pour afficher la fenêtre d'accueil du jeu.
 *
 * @author MOREL Charles <charles.morel@iut-valence.fr>
 */
public class IHMAccueilJeu implements Runnable, ActionListener {

    /**
     * JFrame (fenêtre) d'accueil du jeu.
     */
    private JFrame fenetreAccueil;

    /**
     * JButon correspondant au bouton "Démarrer la partie avec les paramètres
     * par défaut".
     */
    private JButton parametresDefaut;

    /**
     * Attribut représentant l'action d'utilisation des paramètres par défaut
     * pour la configuration du jeu.
     */
    private boolean utiliserLesParametresParDefaut;

    /**
     * Attribut correspondant à l'état de la fenêtre.
     * (true <=> la fenêtre a été fermée - false <=> la fenêtre est toujours
     * ouverte)
     */
    private boolean fenetreFermee;

    // Définition du constructeur
    public IHMAccueilJeu()
    {
        this.utiliserLesParametresParDefaut = true;
    }

    // Définition des méthodes:
    /**
     * Implémentation de Runnable.
     * Permet de lancer le fenêtre JFrame (composants compris)
     */
    @Override
    public void run()
    {
        // Initialisation de la varaibale d'etat de la fenetre
        this.fenetreFermee = false;

        // Initialisation de la JFrame
        this.fenetreAccueil = new JFrame();
        ImageIcon iconeDuJeu = new ImageIcon("./src/iutvalence/java/tp/a2014/g2c/binome6/demineur/IHM/Swing/iconeDuJeu.png");
        this.fenetreAccueil.setIconImage(iconeDuJeu.getImage());
        this.fenetreAccueil.setTitle("Bienvenue!!!");
        this.fenetreAccueil.setSize(500, 300);
        this.fenetreAccueil.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.fenetreAccueil.setResizable(false);
        this.fenetreAccueil.setLocation(ProprietesEcran.ObtenirLlePointXDAncrageOptimaleDeLaFenetre(500), ProprietesEcran.ObtenirLlePointYDAncrageOptimaleDeLaFenetre(300));

        // Layout de la JFrame
        JPanel panneauPrincipalAccueil = new JPanel();
        panneauPrincipalAccueil.setLayout(new GridLayout(6, 1));
        this.fenetreAccueil.setContentPane(panneauPrincipalAccueil);

        // Ajout des composants
        JLabel jlabelMessageAccueil = new JLabel("Bienvenue sur le démineur de MOREL Charles et BEGOT William", SwingConstants.CENTER);
        jlabelMessageAccueil.setIcon(new ImageIcon("./src/iutvalence/java/tp/a2014/g2c/binome6/demineur/IHM/Swing/demineurIconeAcc.png"));
        panneauPrincipalAccueil.add(jlabelMessageAccueil);
        panneauPrincipalAccueil.add(new JLabel(""));
        panneauPrincipalAccueil.add(new JLabel("Les paramètres par défaut sont: une grille 10*10 avec 10 bombes", SwingConstants.CENTER));
        panneauPrincipalAccueil.add(new JLabel("Que souhaitez-vous faire?", SwingConstants.CENTER));
        this.parametresDefaut = new JButton("Démarrer la partie avec les paramètres par défaut");
        this.parametresDefaut.setIcon(new ImageIcon("./src/iutvalence/java/tp/a2014/g2c/binome6/demineur/IHM/Swing/play_default.png"));
        this.parametresDefaut.setFocusable(false);
        parametresDefaut.addActionListener(this);
        panneauPrincipalAccueil.add(this.parametresDefaut);
        JButton parametresPersonalises = new JButton("Démarrer la partie avec les paramètres personalisés");
        parametresPersonalises.setIcon(new ImageIcon("./src/iutvalence/java/tp/a2014/g2c/binome6/demineur/IHM/Swing/play_custum.png"));
        parametresPersonalises.setFocusable(false);
        parametresPersonalises.addActionListener(this);
        panneauPrincipalAccueil.add(parametresPersonalises);

        // Affichage de la fenetre
        this.fenetreAccueil.setVisible(true);
    }

    /**
     * Implémentation de la classe ActionListener.
     * Permet de traiter l'appui sur l'un ou l'autre des boutons (ferme la
     * fenêtre et indique si les paramètres pour l'initialisation du jeu doivent
     * être personnalisés ou non)
     */
    @Override
    public void actionPerformed(ActionEvent actionSelectionnee)
    {
        JButton boutonSelectionne = (JButton) actionSelectionnee.getSource();

        if (boutonSelectionne != this.parametresDefaut)
        {
            this.utiliserLesParametresParDefaut = false;
        }
        this.fenetreFermee = true;
        this.fenetreAccueil.dispose();
    }


    // Getters:
    /**
     * Renvoie si le bouton utiliser les parametres par défaut a été cliqué.
     *
     * @return the utiliserLesParametresParDefaut
     */
    public boolean isUtiliserLesParametresParDefaut()
    {
        return utiliserLesParametresParDefaut;
    }

    /**
     * Renvoie l'état de la fenêtre.
     *
     * @return la fenêtre est-elle fermée?
     */
    public boolean isFenetreFermee()
    {
        return fenetreFermee;
    }


}
