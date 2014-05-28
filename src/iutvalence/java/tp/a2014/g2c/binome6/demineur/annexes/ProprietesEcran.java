package iutvalence.java.tp.a2014.g2c.binome6.demineur.annexes;

/**
 * Classe utilisée pour obtenir des mesures pour les fenêtres de programmes à
 * partir de la résolution de l'écran.
 *
 * @author MOREL Charles
 */
public class ProprietesEcran {

    /**
     * Méthode de calcul de la largeur maximale de la fenêtre.
     *
     * @return la largeur maximale d'une fenêtre
     */
    public static int ObtenirLaLargeurMaximaleDeLaFenetre() {
        return java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width;
    }

    /**
     * Méthode de calcul de la hauteur maximale de la fenêtre.
     *
     * @return la hauteur maximale d'une fenêtre
     */
    public static int ObtenirLaHauteurMaximaleDeLaFenetre() {
        return java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height - 150;
    }

    /**
     * Méthode de calcul du point X optimal d'ancrage de la fenêtre en fonction
     * de sa largeur et de la résolution de l'écran.
     *
     * @param largeurDeLaFenetre: la largeur de la fenêtre.
     * @return point X optimal d'ancrage de la fenêtre.
     */
    public static int ObtenirLlePointXDAncrageOptimaleDeLaFenetre(int largeurDeLaFenetre) {
        int coordonneeX = (ObtenirLaLargeurMaximaleDeLaFenetre() - largeurDeLaFenetre) / 2;
        if (coordonneeX<0)
            return 0;
        return coordonneeX; 
    }

    /**
     * Méthode de calcul du point Y optimal d'ancrage de la fenêtre en fonction
     * de sa hauteur et de la résolution de l'écran.
     *
     * @param hauteurDeLaFenetre: la largeur de la fenêtre.
     * @return point X optimal d'ancrage de la fenêtre.
     */
    public static int ObtenirLlePointYDAncrageOptimaleDeLaFenetre(int hauteurDeLaFenetre) {
        int coordonneeY = ((ObtenirLaHauteurMaximaleDeLaFenetre() + 50 - hauteurDeLaFenetre) / 2) - 75;
        if (coordonneeY<0)
            return 0;
        return coordonneeY; 
    }
}
