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
 * Elle étends JPanel et se compose d'une grille 2*2 contenant 2 boutons et 2
 * Jlabels. Les boutons radio servent à sélectionner l'action à effectuer sur la
 * grille du démineur, les deux JLables sont le timer et le nombre de bombes
 * restantes.
 * Elle étends JPanel et écoute les action réalisés sur ses boutons en
 * implémentant ActionListener.
 *
 * @author MOREL Charles
 */
class BoutonRadioSelectionAction extends JPanel implements ActionListener {

    // Définition des attributs:
    /**
     * Attribut représentant quelle action à effectuer sur la grille est
     * sélectionnée.
     * (true <=> action de déminage - false <=> action de marquage/démarquage)
     */
    private boolean lActionSelectionneeEstLeDeminage;

    /**
     * Attribut représentant le pointeur vers le bouton radio "Marquer/Démarquer
     * une case".
     */
    private final JRadioButton boutonRadioMarquerDemarquer;

    /**
     * Attribut représentant le JLabel contenant le texte du temps écoulé depuis
     * le début de la partie.
     * Le texte est sous la forme "Temps écoulé: 5:17".
     */
    private final JLabel tempsEcoule;

    /**
     * Attribut représentant le JLabel contenant le compteur de mines restantes.
     * Le texte est sous la forme "Nombre de mines restantes: 5".
     */
    private final JLabel nombreBombesRestantes;

    /**
     * Référence vers la classe parent contenant (entre autres) la JFrame du
     * jeu.
     */
    private final Plateau refVersPlateau;

    // Définition du constructeur.
    /**
     * Constructeur de la classe.
     *
     * @param refVersPlateau la classe parent contenant (entre autres) la JFrame
     *                       du jeu.
     */
    public BoutonRadioSelectionAction(Plateau refVersPlateau)
    {
        // Définition des attributs
        this.lActionSelectionneeEstLeDeminage = true;
        this.refVersPlateau = refVersPlateau;

        // Définition du layout
        this.setLayout(new GridLayout(2, 2));

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

    // Définition des méthodes:
    /**
     * Implémentation de la classe ActionListener.
     * Permet d'effectuer les actions correspondant aux boutons radio
     * sélectionnés.
     *
     * @param actionSelectione événement à traiter.
     */
    @Override
    public void actionPerformed(ActionEvent evenement)
    {

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


    /**
     * Méthode de mise à jour du JLabel du Timer.
     * Elle utilise l'heure de début de la partie et l'heure courante.
     */
    public void mettreAJourLeTimer()
    {
        String nouveauTexteDuLabel = "Temps écoulé: ";
        nouveauTexteDuLabel += new SimpleDateFormat("mm:ss", Locale.FRANCE).format(new Date(System.currentTimeMillis() - this.refVersPlateau.getHeureDeDebutDuJeu()));
        this.tempsEcoule.setText(nouveauTexteDuLabel);
    }

    /**
     * Méthode de mise à jour du JLabel du compteur de mines restantes.
     * Elle utilise le plateau pour dénombrer le nombre de cases marquées et les
     * soustraire au nombre de mines disposées sur le plateau.
     */
    public void mettreAJourCompteurMineRestantes()
    {
        String nouveauTexteDuLabel = "Nombre de mines restantes: ";
        int nbBombesRestantes = this.refVersPlateau.getNombreBombesPlateau();
        for (int numColCaseATester = 0; numColCaseATester < this.refVersPlateau.getNombreColonnesPlateau(); numColCaseATester++)
        {
            for (int numLigCaseATester = 0; numLigCaseATester < this.refVersPlateau.getNombreLignesPlateau(); numLigCaseATester++)
            {
                if (this.refVersPlateau.getPlateau()[numColCaseATester][numLigCaseATester].getStatutCase() == StatutCase.MARQUEE)
                {
                    nbBombesRestantes--;
                }
            }
        }
        nouveauTexteDuLabel += nbBombesRestantes;
        this.nombreBombesRestantes.setText(nouveauTexteDuLabel);
    }

    // Getters:
    /**
     * Retourne l'action sélectionnée par les boutons radio.
     *
     * @return booléen pour l'action sélectionnée.
     *         (true <=> action de déminage - false <=> action de marquage/démarquage)
     */
    public boolean islActionSelectionneeEstLeDeminage()
    {
        return lActionSelectionneeEstLeDeminage;
    }

}
