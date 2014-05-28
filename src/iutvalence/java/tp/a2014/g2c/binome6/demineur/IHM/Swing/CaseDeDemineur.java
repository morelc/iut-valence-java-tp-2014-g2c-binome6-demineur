package iutvalence.java.tp.a2014.g2c.binome6.demineur.IHM.Swing;

import iutvalence.java.tp.a2014.g2c.binome6.demineur.annexes.StatutCase;
import iutvalence.java.tp.a2014.g2c.binome6.demineur.coeurDuJeu.Case;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * Classe représentant un bouton correspondant à une case de démineur.
 *
 * @author MOREL Charles
 */
public class CaseDeDemineur extends JButton {

    private final int ligneDuBouton;

    private final int colonneDuBouton;

    private final Case refVerscaseCorrespondante;

    public CaseDeDemineur(int ligneDuBouton, int colonneDuBouton, Case caseCorrespondante) {
        this.refVerscaseCorrespondante = caseCorrespondante;
        this.ligneDuBouton = ligneDuBouton;
        this.colonneDuBouton = colonneDuBouton;
        this.setBackground(Color.BLUE);
        this.setVerticalAlignment(CENTER);
        this.setHorizontalAlignment(CENTER);
    }

    public void mettreAJourLeBouton() {
        if (this.refVerscaseCorrespondante.getStatutCase() == StatutCase.DECOUVERTE) {

            this.setEnabled(false);
            if (this.refVerscaseCorrespondante.getaUneBombe()) {
                this.setBackground(Color.RED);
                JLabel contenuBouton = new JLabel("");
                this.setIcon(new ImageIcon("./src/iutvalence/java/tp/a2014/g2c/binome6/demineur/IHM/Swing/bombeExplosee.png"));
                this.add(contenuBouton);
            } else {
                this.setIcon(null);
                this.setOpaque(false);
                this.setBackground(null);
                if (this.refVerscaseCorrespondante.getaNBombesAdjacentes() != 0) {
                    this.setText(String.valueOf(this.refVerscaseCorrespondante.getaNBombesAdjacentes()));
                }
                
                
            }
            
            
        }

        if (this.refVerscaseCorrespondante.getStatutCase() == StatutCase.MARQUEE) {
            this.setIcon(new ImageIcon("./src/iutvalence/java/tp/a2014/g2c/binome6/demineur/IHM/Swing/drapeau_case_marquee.png"));
        }

        if (this.refVerscaseCorrespondante.getStatutCase() == StatutCase.MASQUEE) {
            this.setIcon(null);
        }
    }

    public int getLigneDuBouton() {
        return ligneDuBouton;
    }

    public int getColonneDuBouton() {
        return colonneDuBouton;
    }

}
