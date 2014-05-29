package iutvalence.java.tp.a2014.g2c.binome6.demineur.IHM.Swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * Classe définissant la barre de menu de la fenêtre principale du jeu de
 * démineur.
 * Elle étends JMenuBar et écoute les action réalisés sur ses menus en
 * implémentant ActionListener.
 *
 * @author MOREL Charles
 */
class BarreDeMenuFenetre extends JMenuBar implements ActionListener {

    // Attributs:
    /**
     * Référence vers la classe parent contenant (entre autres) la JFrame du
     * jeu.
     */
    private final IHMJeuDemineurSWING refVersIHMJeuDemineurSWING;

    /**
     * Attribut correspondant à la référence mémoire du sous-menu "à propos".
     */
    private JMenuItem aProposItem;


    // Déninition du constructeur:
    /**
     * Constructeur de la classe.
     *
     * @param refversIHMJeuDemineurSWING la classe parent contenant (entre
     *                                   autres) la JFrame du jeu.
     */
    public BarreDeMenuFenetre(IHMJeuDemineurSWING refversIHMJeuDemineurSWING)
    {

        // Initialisation des attributs
        this.refVersIHMJeuDemineurSWING = refversIHMJeuDemineurSWING;

        // Initialisation du menu
        JMenu menu = new JMenu("Menu");
        this.aProposItem = new JMenuItem("A Propos...");
        this.aProposItem.addActionListener(this);
        menu.add(this.aProposItem);
        JMenuItem quitterLeJeuItem = new JMenuItem("Quitter le jeu...");
        quitterLeJeuItem.addActionListener(this);
        menu.add(quitterLeJeuItem);
        this.add(menu);
    }

    // Méthodes:
    /**
     * Implémentation de la classe ActionListener.
     * Permet d'effectuer les actions correspondant aux sous-menu sélectionnés.
     *
     * @param actionSelectione événement à traiter.
     */
    @Override
    public void actionPerformed(ActionEvent actionSelectione)
    {
        JMenuItem ItemDeMenuSelectione = (JMenuItem) actionSelectione.getSource();

        if (ItemDeMenuSelectione == this.aProposItem)
        {
            JOptionPane.showMessageDialog(this.refVersIHMJeuDemineurSWING.getFenetrePrincipaleDuJeu(), new JLabel("Démineur - Travaux pratiques S2, IUT Valence, 2014 - MOREL Charles et BEGOT William"), "A propos...", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (JOptionPane.showConfirmDialog(this.refVersIHMJeuDemineurSWING.getFenetrePrincipaleDuJeu(), "Voulez-vous vraiment quitter l'application?", "Attention! Vous allez nous quitter!", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION)
        {
            this.refVersIHMJeuDemineurSWING.getFenetrePrincipaleDuJeu().dispose();
            System.exit(0);
        }

    }

}
