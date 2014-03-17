package iutvalence.java.tp.a2014.g2c.binome6.demineur;

import iutvalence.java.tp.a2014.g2c.binome6.demineur.annexes.StatutDeLaCase;
import java.util.Scanner;

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
    public static void main(String[] args) {
        // Commandes de test
        Plateau monplateau = new Plateau(10, 10, 10);
        Scanner scanner = new Scanner(System.in);
        int LigneCaseAAfficher = 0;
        int ColonneCaseAAfficher = 0;
        while (LigneCaseAAfficher != 100) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    System.out.print(" " + monplateau.plateau[i][j].toString());
                }
                System.out.println();
            }
            System.out.println("Veuillez entrer la ligne de la case à afficher: ");
            LigneCaseAAfficher = scanner.nextInt();
            System.out.println("Veuillez entrer la colonne de la case à afficher: ");
            ColonneCaseAAfficher = scanner.nextInt();
            monplateau.plateau[ColonneCaseAAfficher][LigneCaseAAfficher].setStatutCase(StatutDeLaCase.Decouvert);
        }

    }

}
