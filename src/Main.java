// Main.java
package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PoupeeRusse firstDoll = new PoupeeRusse(10);
        PoupeeRusse secondDoll = new PoupeeRusse(30);
        PoupeeRusse thirdDoll = new PoupeeRusse(20);

        int choice;



        do {
            printMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    playWithDolls(firstDoll, secondDoll, thirdDoll);
                    break;
                case 2:
                    displayDollsInfo(firstDoll, secondDoll, thirdDoll);
                    break;
                case 3:
                    placeDollMenu(firstDoll, secondDoll, thirdDoll);
                    break;
                case 4:
                    placeDollMenu(secondDoll, thirdDoll);
                    break;
                case 5:
                    System.out.println("Sortie de l'application.");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
                    break;
            }

        } while (choice != 5);

        scanner.close();
    }
    private static void printMenu() {
        System.out.println("Menu :");
        System.out.println("1. Jouer avec les poupées");
        System.out.println("2. Afficher les informations des poupées");
        System.out.println("3. Placer une poupée dans une autre (1ère poupée dans 2ème poupée)");
        System.out.println("4. Placer une poupée dans une autre (2ème poupée dans 3ème poupée)");
        System.out.println("5. Quitter");
        System.out.print("Choix : ");
    }



    private static void playWithDolls(PoupeeRusse... dolls) {
        System.out.println("Menu Jouer avec les poupées :");
        for (int i = 0; i < dolls.length; i++) {
            System.out.println((i + 1) + ". Ouvrir/Fermer la poupée de taille " + dolls[i].getTaille());
        }

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if (choice >= 1 && choice <= dolls.length) {
            PoupeeRusse selectedDoll = dolls[choice - 1];
            System.out.println("Que voulez-vous faire avec la poupée de taille " + selectedDoll.getTaille() + "?");
            System.out.println("1. Ouvrir");
            System.out.println("2. Fermer");

            int actionChoice = scanner.nextInt();
            switch (actionChoice) {
                case 1:
                    selectedDoll.ouvrir();
                    break;
                case 2:
                    selectedDoll.fermer();
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
        } else {
            System.out.println("Choix invalide.");
        }
    }

    private static void displayDollsInfo(PoupeeRusse... dolls) {
        System.out.println("Informations des poupées :");
        for (PoupeeRusse doll : dolls) {
            System.out.println("Taille : " + doll.getTaille() + ", Ouverte : " + doll.isOuverte());
        }
    }

    private static void placeDollMenu(PoupeeRusse sourceDoll, PoupeeRusse... destinationDolls) {
        System.out.println("Menu Placer une poupée dans une autre :");
        System.out.println("Source : Taille " + sourceDoll.getTaille());

        for (int i = 0; i < destinationDolls.length; i++) {
            System.out.println((i + 1) + ". Destination : Taille " + destinationDolls[i].getTaille());
        }

        Scanner scanner = new Scanner(System.in);
        int destinationChoice = scanner.nextInt();

        if (destinationChoice >= 1 && destinationChoice <= destinationDolls.length) {
            PoupeeRusse destinationDoll = destinationDolls[destinationChoice - 1];
            sourceDoll.placerDans(destinationDoll);
        } else {
            System.out.println("Choix invalide.");
        }
    }
}
