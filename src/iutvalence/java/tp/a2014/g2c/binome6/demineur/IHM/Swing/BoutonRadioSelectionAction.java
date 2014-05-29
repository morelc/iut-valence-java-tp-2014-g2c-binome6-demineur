package iutvalence.java.tp.a2014.g2c.binome6.demineur.IHM.Swing;

import iutvalence.java.tp.a2014.g2c.binome6.demineur.annexes.StatutCase;
import iutvalence.java.tp.a2014.g2c.binome6.demineur.coeurDuJeu.Plateau;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import static javax.swing.SwingConstants.CENTER;

/**
 * Classe de sélection de l'action (marquer/démarquer - déminer).
 * Elle étends JPanel et se compose d'une grille de deux boutons radio.
 * Cette classe contiens également le timer et le nombre de bombes restantes.
 * 
 * @author MOREL Charles
 */
class BoutonRadioSelectionAction extends JPanel implements ActionListener {
    
    private boolean lActionSelectionneeEstLeDeminage;
    
    private JRadioButton boutonRadioMarquerDemarquer;
    private JLabel tempsEcoule;
    private JLabel nombreBombesRestantes;
    private Plateau refVersPlateau;
    
    public BoutonRadioSelectionAction(Plateau refVersPlateau)
    {
        // Définition des variables
        this.lActionSelectionneeEstLeDeminage = true;
        this.refVersPlateau = refVersPlateau;
        
        // Définition du layout
        this.setLayout(new GridLayout(2,2));
        
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
        // Ajout des labels contenant le nombre de bombes restantes et le timer
        this.tempsEcoule = new JLabel("");
        this.tempsEcoule.setHorizontalAlignment(CENTER);
        this.add(this.tempsEcoule);
        this.nombreBombesRestantes = new JLabel("");
        this.nombreBombesRestantes.setHorizontalAlignment(CENTER);
        this.add(this.nombreBombesRestantes);
        // Pemière mise à jour du nombre de bombes restantes:
        mettreAJourCompteurMineRestantes();
        
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
    
    public void mettreAJourLeTimer()
    {
        String nouveauTexteDuLabel = "Temps écoulé: ";
        nouveauTexteDuLabel += new SimpleDateFormat("mm:ss", Locale.FRANCE).format(new Date(System.currentTimeMillis() - this.refVersPlateau.getHeureDeDebutDuJeu()));
        this.tempsEcoule.setText(nouveauTexteDuLabel);
    }
    
    public void mettreAJourCompteurMineRestantes()
    {
        String nouveauTexteDuLabel = "Nombre de mines restantes: ";
        int nbBombesRestantes = this.refVersPlateau.getNombreBombesPlateau();
        for (int numColCaseATester = 0; numColCaseATester < this.refVersPlateau.getNombreColonnesPlateau(); numColCaseATester++)
            for (int numLigCaseATester = 0; numLigCaseATester < this.refVersPlateau.getNombreLignesPlateau(); numLigCaseATester++)
            {
                if (this.refVersPlateau.getPlateau()[numColCaseATester][numLigCaseATester].getStatutCase()==StatutCase.MARQUEE)
                    nbBombesRestantes--;
            }
        nouveauTexteDuLabel += nbBombesRestantes;
        this.nombreBombesRestantes.setText(nouveauTexteDuLabel);
    }
}
