package iutvalence.java.tp.a2014.g2c.binome6.demineur.IHM.Swing;

import iutvalence.java.tp.a2014.g2c.binome6.demineur.annexes.ProprietesEcran;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * Classe utilisée pour créer une fenêtre afin de modifier les paramètres de la
 * partie.
 *
 * @author MOREL Charles <charles.morel@iut-valence.fr>
 */
public class IHMFenetreParametresPartieSWING implements Runnable, ActionListener {

    // Définition des attributs.
    /**
     * Attribut permettant de savoir si tous les paramètres personnalisés sont
     * entrés.
     */
    private boolean tousLesDonnesSontEntrees;

    /**
     * Référence vers la classe parente contenant les paramètres de la partie.
     */
    IHMCreerParametresPartieSWING refVersParametresPartie;

    /**
     * Champ d'entrée du nombre de colonnes.
     */
    private JTextField nombreDeColonnes;

    /**
     * Champ d'entrée du nombre de lignes.
     */
    private JTextField nombreDeLignes;

    /**
     * Champ d'entrée du nombre de bombes.
     */
    private JTextField nombreDeBombes;

    /**
     * Fenêtre d'entrée de paramètres.
     */
    private JFrame fenetreParametres;

    // Définition du constructeur
    public IHMFenetreParametresPartieSWING(IHMCreerParametresPartieSWING refVersParametresPartie)
    {
        this.tousLesDonnesSontEntrees = false;
        this.refVersParametresPartie = refVersParametresPartie;
    }

    // Définition des méthodes
    /**
     * Implémentation de Runnable.
     * Permet de lancer le fenêtre JFrame (composants compris)
     */
    @Override
    public void run()
    {
        // Initialisation de la JFrame
        this.fenetreParametres = new JFrame();
        ImageIcon iconeDuJeu = new ImageIcon("./src/iutvalence/java/tp/a2014/g2c/binome6/demineur/IHM/Swing/iconeDuJeu.png");
        this.fenetreParametres.setIconImage(iconeDuJeu.getImage());
        this.fenetreParametres.setTitle("Parametres de jeu");
        this.fenetreParametres.setSize(800, 250);
        this.fenetreParametres.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.fenetreParametres.setResizable(false);
        this.fenetreParametres.setLocation(ProprietesEcran.ObtenirLlePointXDAncrageOptimaleDeLaFenetre(800), ProprietesEcran.ObtenirLlePointYDAncrageOptimaleDeLaFenetre(250));

        // Layout de la JFrame
        JPanel panneauPrincipalParametres = new JPanel();
        panneauPrincipalParametres.setLayout(new GridLayout(4, 2));
        this.fenetreParametres.setContentPane(panneauPrincipalParametres);

        // Ajout des composants
        panneauPrincipalParametres.add(new JLabel("Entrer le nombre de colonnes (entre 5 et 100):"));
        this.nombreDeColonnes = new JTextField(String.valueOf(this.refVersParametresPartie.getNombreColonnesPlateau()));
        panneauPrincipalParametres.add(this.nombreDeColonnes);
        panneauPrincipalParametres.add(new JLabel("Entrer le nombre de lignes (entre 5 et 100):"));
        this.nombreDeLignes = new JTextField(String.valueOf(this.refVersParametresPartie.getNombreLignesPlateau()));
        panneauPrincipalParametres.add(this.nombreDeLignes);
        panneauPrincipalParametres.add(new JLabel("Entrer le nombre de bombes (entre 5 et 100)"));
        nombreDeBombes = new JTextField(String.valueOf(this.refVersParametresPartie.getNombreBombesPlateau()));
        panneauPrincipalParametres.add(this.nombreDeBombes);
        panneauPrincipalParametres.add(new JLabel(""));
        JButton demarrerPartie = new JButton("Démarrer la partie!");
        demarrerPartie.setIcon(new ImageIcon("./src/iutvalence/java/tp/a2014/g2c/binome6/demineur/IHM/Swing/play_custum.png"));
        demarrerPartie.setFocusable(false);
        demarrerPartie.addActionListener(this);
        panneauPrincipalParametres.add(demarrerPartie);

        // Affichage de la fenetre
        this.fenetreParametres.setVisible(true);
    }

    /**
     * Implémentation de la classe ActionListener.
     * Permet de lancer la vérification des données entrés, puis de notifier la
     * fin de saisie ainsi que fermer la fenêtre si tous les paramètres sont
     * valides.
     *
     * @param actionSelectionnee
     */
    @Override
    public void actionPerformed(ActionEvent actionSelectionnee)
    {

        int nombreDeColonnesEntree;
        int nombreDeLignesEntree;
        int nombreDeBombeEntree;

        try
        {
            nombreDeColonnesEntree = Integer.parseInt(this.nombreDeColonnes.getText());
        }
        catch (NumberFormatException e)
        {
            nombreDeColonnesEntree = 0;
        }

        try
        {
            nombreDeLignesEntree = Integer.parseInt(this.nombreDeLignes.getText());
        }
        catch (NumberFormatException e)
        {
            nombreDeLignesEntree = 0;
        }

        try
        {
            nombreDeBombeEntree = Integer.parseInt(this.nombreDeBombes.getText());
        }
        catch (NumberFormatException e)
        {
            nombreDeBombeEntree = 0;
        }

        if ((nombreDeColonnesEntree < 5) || (nombreDeColonnesEntree > 100))
        {
            JOptionPane.showMessageDialog(this.fenetreParametres, "Erreur: le nombre de colonnes entré est invalide!", "Attention!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if ((nombreDeLignesEntree < 5) || (nombreDeLignesEntree > 100))
        {
            JOptionPane.showMessageDialog(this.fenetreParametres, "Erreur: le nombre de lignes entré est invalide!", "Attention!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if ((nombreDeBombeEntree < 5) || (nombreDeBombeEntree > 100))
        {
            JOptionPane.showMessageDialog(this.fenetreParametres, "Erreur: le nombre de bombes entré est invalide!", "Attention!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (nombreDeBombeEntree > ((nombreDeColonnesEntree * nombreDeLignesEntree) / 2))
        {
            JOptionPane.showMessageDialog(this.fenetreParametres, "Attention: le nombre de bombes entré est supérieur  à (nbCol*nbLig)/2!", "Attention!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        this.refVersParametresPartie.setNombreBombesPlateau(nombreDeBombeEntree);
        this.refVersParametresPartie.setNombreColonnesPlateau(nombreDeColonnesEntree);
        this.refVersParametresPartie.setNombreLignesPlateau(nombreDeLignesEntree);
        this.fenetreParametres.dispose();
        this.tousLesDonnesSontEntrees = true;

    }

    // Getters:
    public boolean isTousLesDonnesSontEntrees()
    {
        return tousLesDonnesSontEntrees;
    }

}
