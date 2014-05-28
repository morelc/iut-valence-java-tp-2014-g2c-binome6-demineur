package iutvalence.java.tp.a2014.g2c.binome6.demineur.IHM.Swing;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import static javax.swing.SwingConstants.CENTER;

/**
 * Classe de sélection de l'action (marquer/démarquer - déminer).
 * Elle étends JPanel et se compose d'une grille de deux boutons radio.
 * 
 * @author MOREL Charles
 */
class BoutonRadioSelectionAction extends JPanel implements ActionListener {
    
    private boolean lActionSelectionneeEstLeDeminage;
    
    private JRadioButton boutonRadioMarquerDemarquer;
    
    public BoutonRadioSelectionAction()
    {
        // Définition des variables
        this.lActionSelectionneeEstLeDeminage = true;
        
        // Définition du layout
        this.setLayout(new GridLayout(1,2));
        
        // Ajout des boutons et création du groupe
        this.boutonRadioMarquerDemarquer = new JRadioButton("Marquer/Démarquer une case");
        this.boutonRadioMarquerDemarquer.addActionListener(this);
        this.boutonRadioMarquerDemarquer.setHorizontalAlignment(CENTER);
        this.boutonRadioMarquerDemarquer.setFocusable(false);
        this.boutonRadioMarquerDemarquer.setSelected(false);
        this.add(this.boutonRadioMarquerDemarquer);
        JRadioButton boutonRadioDeminer = new JRadioButton("Déminer une case");
        boutonRadioDeminer.addActionListener(this);
        boutonRadioDeminer.setHorizontalAlignment(CENTER);
        boutonRadioDeminer.setFocusable(false);
        boutonRadioDeminer.setSelected(true);
        this.add(boutonRadioDeminer);
        ButtonGroup groupeDeBoutonsRadio = new ButtonGroup();
        groupeDeBoutonsRadio.add(this.boutonRadioMarquerDemarquer);
        groupeDeBoutonsRadio.add(boutonRadioDeminer);
        
    }

    @Override
    public void actionPerformed(ActionEvent evenement) {
        
        JRadioButton boutonSelectionne = (JRadioButton) evenement.getSource();
        
        if (boutonSelectionne == this.boutonRadioMarquerDemarquer)
        {
            this.lActionSelectionneeEstLeDeminage = false;
        }
        else
        {
            this.lActionSelectionneeEstLeDeminage = true;
        }
        
        boutonSelectionne.setSelected(true);
    }

    public boolean islActionSelectionneeEstLeDeminage() {
        return lActionSelectionneeEstLeDeminage;
    }
    
}
