/* TODO Changer le nom du package. */
package demineur;

/**
 * TODO
 *
 * @author BEGOT William <william.begot@iut-valence.fr>
 * @version 0.1
 */
public class Application
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // Commandes de test
        Plateau monplateau = new Plateau(10, 10, 10);
        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < 10; j++)
            {
                System.out.print(" " + monplateau.plateau[i][j].getaUneBombe());
            }
            System.out.println();
        }
        for (int k = 0; k < 10; k++)
        {
            for (int l = 0; l < 10; l++)
            {
                System.out.print(" " + monplateau.plateau[k][l].getaNBombesAdjacentes());
            }
            System.out.println();
        }
    }

}
