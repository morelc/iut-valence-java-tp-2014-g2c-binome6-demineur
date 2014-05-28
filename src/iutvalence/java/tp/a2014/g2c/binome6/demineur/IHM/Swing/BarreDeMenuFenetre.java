package iutvalence.java.tp.a2014.g2c.binome6.demineur.IHM.Swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author MOREL Charles
 */
class BarreDeMenuFenetre extends JMenuBar implements ActionListener {

    private final IHMJeuDemineurSWING refVersIHMJeuDemineurSWING;
    private JMenuItem aProposItem;
    public BarreDeMenuFenetre(IHMJeuDemineurSWING refversIHMJeuDemineurSWING) {

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

    @Override
    public void actionPerformed(ActionEvent actionSelectione) {
        JMenuItem ItemDeMenuSelectione = (JMenuItem) actionSelectione.getSource();

        if (ItemDeMenuSelectione == this.aProposItem) {
            JOptionPane.showMessageDialog(this.refVersIHMJeuDemineurSWING.getFenetrePrincipaleDuJeu(), new JLabel("Démineur - Travaux pratiques S2, IUT Valence, 2014 - MOREL Charles et BEGOT William"), "A propos...", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        if(JOptionPane.showConfirmDialog(this.refVersIHMJeuDemineurSWING.getFenetrePrincipaleDuJeu(), "Voulez-vous vraiment quitter l'application?", "Attention! Vous allez nous quitter!", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION)
        {
            this.refVersIHMJeuDemineurSWING.getFenetrePrincipaleDuJeu().dispose();
            System.exit(0);
        }
        
    }

}
