package iutvalence.java.tp.a2014.g2c.binome6.demineur.IHM.Swing;

import iutvalence.java.tp.a2014.g2c.binome6.demineur.annexes.StatutCase;
import iutvalence.java.tp.a2014.g2c.binome6.demineur.coeurDuJeu.Case;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * Classe représentant un bouton correspondant à une case du plateau de
 * démineur.
 *
 * @author MOREL Charles
 */
public class CaseDeDemineur extends JButton {
    // Définition des attributs:
    /**
     * Référence vers la case de la grille du plateau de démineur correspondante
     * au bouton.
     */
    private final Case refVerscaseCorrespondante;

    // Définition du constructeur:
    /**
     * Constructeur de la classe.
     *
     * @param caseCorrespondante case de la grille du plateau de démineur
     *                           correspondante
     *                           au bouton.
     */
    public CaseDeDemineur(Case caseCorrespondante)
    {
        // Initialisation des attributs
        this.refVerscaseCorrespondante = caseCorrespondante;
        // Initialisation des paramêtres d'une case par défaut
        this.setBackground(Color.BLUE);
        this.setVerticalAlignment(CENTER);
        this.setHorizontalAlignment(CENTER);
    }

    //Définition des méthodes:
    /**
     * Méthode de mise à jour des propriétés du JButton.
     * Cette méthode applique un style spécifique au bouton en fonction de son
     * statut.
     */
    public void mettreAJourLeBouton()
    {
        if (this.refVerscaseCorrespondante.getStatutCase() == StatutCase.DECOUVERTE)
        {
            this.setEnabled(false);
            if (this.refVerscaseCorrespondante.getaUneBombe())
            {
                this.setBackground(Color.RED);
                JLabel contenuBouton = new JLabel("");
                this.setIcon(new ImageIcon("./src/iutvalence/java/tp/a2014/g2c/binome6/demineur/IHM/Swing/bombeExplosee.png"));
                this.add(contenuBouton);
            }
            else
            {
                this.setIcon(null);
                this.setOpaque(false);
                this.setBackground(null);
                if (this.refVerscaseCorrespondante.getaNBombesAdjacentes() != 0)
                {
                    this.setText(String.valueOf(this.refVerscaseCorrespondante.getaNBombesAdjacentes()));
                }
            }
        }

        if (this.refVerscaseCorrespondante.getStatutCase() == StatutCase.MARQUEE)
        {
            this.setIcon(new ImageIcon("./src/iutvalence/java/tp/a2014/g2c/binome6/demineur/IHM/Swing/drapeau_case_marquee.png"));
        }
        if (this.refVerscaseCorrespondante.getStatutCase() == StatutCase.MASQUEE)
        {
            this.setIcon(null);
        }
    }

}
