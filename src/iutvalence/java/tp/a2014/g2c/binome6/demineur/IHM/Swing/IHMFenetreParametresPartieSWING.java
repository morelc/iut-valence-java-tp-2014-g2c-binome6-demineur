package iutvalence.java.tp.a2014.g2c.binome6.demineur.IHM.Swing;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * Classe utilisée pour créer une fenetre afin de modifier les parametres de la partie.
 * 
 * @author MOREL Charles <charles.morel@iut-valence.fr>
 */
public class IHMFenetreParametresPartieSWING implements Runnable, ActionListener
{

    private boolean tousLesDonnesSontEntrees;
    
    IHMCreerParametresPartieSWING refVersParametresPartie;
    private JTextField nombreDeColonnes;
    private JTextField nombreDeLignes;
    private JTextField nombreDeBombes;
    private JButton demarrerPartie;
    private JFrame fenetreParametres;

    public IHMFenetreParametresPartieSWING(IHMCreerParametresPartieSWING refVersParametresPartie)
    {
        this.tousLesDonnesSontEntrees = false;
        this.refVersParametresPartie = refVersParametresPartie;
    }

    @Override
    public void run()
    {
        // Initialisation de la JFrame
        this.fenetreParametres = new JFrame();
        this.fenetreParametres.setTitle("Parametres de jeu");
        this.fenetreParametres.setSize(800, 250);
        this.fenetreParametres.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.fenetreParametres.setResizable(false);

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
        this.demarrerPartie = new JButton("Démarrer la partie!");
        this.demarrerPartie.addActionListener(this);
        panneauPrincipalParametres.add(this.demarrerPartie);
        
        // Affichage de la fenetre
        this.fenetreParametres.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionSelectionnee)
    {
        int nombreDeColonnesEntree = Integer.parseInt(this.nombreDeColonnes.getText());
        int nombreDeLignesEntree = Integer.parseInt(this.nombreDeLignes.getText());
        int nombreDeBombeEntree = Integer.parseInt(this.nombreDeBombes.getText());

        System.out.println(nombreDeColonnesEntree);
        System.out.println(nombreDeLignesEntree);
        System.out.println(nombreDeBombeEntree);

        if ((nombreDeColonnesEntree < 5) || (nombreDeColonnesEntree > 100)) {
            JOptionPane.showMessageDialog(this.fenetreParametres, "Erreur: le nombre de colonnes entré est invalide!", "Attention!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if ((nombreDeLignesEntree < 5) || (nombreDeLignesEntree > 100)) {
            JOptionPane.showMessageDialog(this.fenetreParametres, "Erreur: le nombre de lignes entré est invalide!", "Attention!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if ((nombreDeBombeEntree < 5) || (nombreDeBombeEntree > 100)) {
            JOptionPane.showMessageDialog(this.fenetreParametres, "Erreur: le nombre de bombes entré est invalide!", "Attention!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (nombreDeBombeEntree > ((nombreDeColonnesEntree * nombreDeLignesEntree) / 2)) {
            JOptionPane.showMessageDialog(this.fenetreParametres, "Attention: le nombre de bombes entré est supérieur  à (nbCol*nbLig)/2!", "Attention!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        this.refVersParametresPartie.setNombreBombesPlateau(nombreDeBombeEntree);
        this.refVersParametresPartie.setNombreColonnesPlateau(nombreDeColonnesEntree);
        this.refVersParametresPartie.setNombreLignesPlateau(nombreDeLignesEntree);
        this.fenetreParametres.dispose();
        this.tousLesDonnesSontEntrees = true;

    }

    public boolean isTousLesDonnesSontEntrees()
    {
        return tousLesDonnesSontEntrees;
    }
   

}
