package iutvalence.java.tp.a2014.g2c.binome6.demineur.IHM.Swing;

import iutvalence.java.tp.a2014.g2c.binome6.demineur.annexes.InteractionCase;
import iutvalence.java.tp.a2014.g2c.binome6.demineur.annexes.StatutCase;
import iutvalence.java.tp.a2014.g2c.binome6.demineur.annexes.StatutPartie;
import iutvalence.java.tp.a2014.g2c.binome6.demineur.coeurDuJeu.Plateau;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * Classe écoutant les interactions avec les boutons cases de la grille de
 * démineur.
 *
 * @author MOREL Charles
 */
class EcouteBoutonsGrille implements ActionListener {

    private final IHMJoueurSWING refVersIHMJoueurSWING;

    private final CaseDeDemineur[][] refVersBoutonsDeLaGrille;

    private final Plateau refVersPlateau;
    
    private final GrilleDeDemineur refVersGrilleDuDemineur;
    
    private final BoutonRadioSelectionAction refVersActionSelectionnee;

    EcouteBoutonsGrille(GrilleDeDemineur refVersGrilleDeDemineur) {
        this.refVersGrilleDuDemineur = refVersGrilleDeDemineur;
        this.refVersIHMJoueurSWING = refVersGrilleDeDemineur.getRefVersIHMJoueurSWING();
        this.refVersBoutonsDeLaGrille = refVersGrilleDeDemineur.getBoutonsDeLaGrille();
        this.refVersPlateau = refVersGrilleDeDemineur.getRefVersPlateau();
        this.refVersActionSelectionnee = refVersGrilleDeDemineur.getRefBoutonAction();
    }

    @Override
    public void actionPerformed(ActionEvent evenement) {

        JButton boutonSelectionne = (JButton) evenement.getSource();
        
        
        for (int colonneCaseATraiter = 0; colonneCaseATraiter < this.refVersPlateau.getNombreColonnesPlateau(); colonneCaseATraiter++) {
            for(int ligneCaseATraiter = 0; ligneCaseATraiter < this.refVersPlateau.getNombreLignesPlateau(); ligneCaseATraiter++ )
            {
                if (boutonSelectionne == this.refVersBoutonsDeLaGrille[colonneCaseATraiter][ligneCaseATraiter])
                {
                    if (!this.refVersActionSelectionnee.islActionSelectionneeEstLeDeminage())
                    {
                        if(this.refVersPlateau.getPlateau()[colonneCaseATraiter][ligneCaseATraiter].getStatutCase()==StatutCase.MARQUEE)
                            this.refVersIHMJoueurSWING.appliquerActionSurCase(this.refVersPlateau, colonneCaseATraiter, ligneCaseATraiter, InteractionCase.ENLEVER_MARQUAGE);
                        else
                            this.refVersIHMJoueurSWING.appliquerActionSurCase(this.refVersPlateau, colonneCaseATraiter, ligneCaseATraiter, InteractionCase.MARQUER);
                    }
                    else
                    {
                        this.refVersIHMJoueurSWING.appliquerActionSurCase(this.refVersPlateau, colonneCaseATraiter, ligneCaseATraiter, InteractionCase.DEMINER);
                    }
                    
                    this.refVersGrilleDuDemineur.MettreAJourAffichageGrille();
                    if(this.refVersIHMJoueurSWING.verifierStatutPartie(this.refVersPlateau))
                    {
                        this.refVersGrilleDuDemineur.MettreAJourAffichageGrille();
                        finDuJeu();
                    }
                        
                }
            }

        }
        this.refVersPlateau.getHeureDeDebutDuJeu();

    }

    private void finDuJeu() {
        JLabel messageDeFinDeJeu = new JLabel("");
        UIManager managerUI = new UIManager();
        if (this.refVersPlateau.getStatutPartie()==StatutPartie.ESTGAGNEE)
        {
                        managerUI.put("OptionPane.background", Color.WHITE);
            managerUI.put("Panel.background", Color.WHITE);
            messageDeFinDeJeu.setIcon(new ImageIcon("./src/iutvalence/java/tp/a2014/g2c/binome6/demineur/IHM/Swing/partie_gagnee.png"));
           messageDeFinDeJeu.setText("Félicatation! Vous venez de gagné en "+ new SimpleDateFormat("mm:ss", Locale.FRANCE).format(new Date(System.currentTimeMillis() - this.refVersPlateau.getHeureDeDebutDuJeu())));
        }
        else
        {
            messageDeFinDeJeu.setIcon(new ImageIcon("./src/iutvalence/java/tp/a2014/g2c/binome6/demineur/IHM/Swing/partie_perdue.png"));
            managerUI.put("OptionPane.background", Color.BLACK);
            managerUI.put("Panel.background", Color.BLACK);
            messageDeFinDeJeu.setBackground(Color.BLACK);
            messageDeFinDeJeu.setForeground(Color.WHITE);
            messageDeFinDeJeu.setText("Dommage... Vous avez perdu! :'(");
        }
        JOptionPane.showMessageDialog(this.refVersIHMJoueurSWING.getEcranDeJeu().getFenetrePrincipaleDuJeu(), messageDeFinDeJeu, "Fin du jeu...", JOptionPane.INFORMATION_MESSAGE);
        this.refVersIHMJoueurSWING.getEcranDeJeu().getFenetrePrincipaleDuJeu().dispose();
    }
}
