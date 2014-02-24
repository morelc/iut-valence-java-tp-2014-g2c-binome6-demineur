package demineur;

/**
 *
 * @author BEGOT William <william.begot@iut-valence.fr>
 */
public class Application
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Commandes de test
        Plateau monplateau = new Plateau(10, 10, 10);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(" " + monplateau.Plateau[i][j].getaUneBombe());
            }
            System.out.println();
        }
    }

}
