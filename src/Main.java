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
                    takeOutOfDollMenu(firstDoll, secondDoll, thirdDoll);
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
        System.out.println("3. Placer une poupée dans une autre");
        System.out.println("4. Sortir une poupée d'une autre");
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

    private static void placeDollMenu(PoupeeRusse... dolls) {
        System.out.println("Menu Placer une poupée dans une autre :");

        // Display the available dolls
        for (int i = 0; i < dolls.length; i++) {
            System.out.println((i + 1) + ". Taille " + dolls[i].getTaille() + ", Ouverte : " + dolls[i].isOuverte());
        }

        Scanner scanner = new Scanner(System.in);

        
        System.out.println("Choisissez la poupée source (numéro) : ");
        int sourceChoice = scanner.nextInt();
        PoupeeRusse sourceDoll = dolls[sourceChoice - 1];


        System.out.println("Choisissez la poupée de destination (numéro) avec une taille plus grande : ");
        int destinationChoice = scanner.nextInt();

        if (destinationChoice < 1 || destinationChoice > dolls.length) {
            System.out.println("Choix invalide.");
            return;
        }

        PoupeeRusse destinationDoll = dolls[destinationChoice - 1];

        //
        if (destinationDoll.getTaille() <= sourceDoll.getTaille()) {
            System.out.println("La taille de la poupée de destination doit être plus grande.");
        } else {
            sourceDoll.placerDans(destinationDoll);
        }
    }
    private static void takeOutOfDollMenu(PoupeeRusse... dolls) {
        System.out.println("Menu Sortir une poupee d'une autre :");


        for (int i = 0; i < dolls.length; i++) {
            PoupeeRusse doll = dolls[i];
            PoupeeRusse internalDoll = doll.getPoupeeInterne();
            if (internalDoll != null) {
                System.out.println((i + 1) + ". Taille " + doll.getTaille() + ", Interne : Taille " + internalDoll.getTaille());
            }
        }

        Scanner scanner = new Scanner(System.in);


        System.out.println("Choisissez la poupée source (numero) : ");
        int sourceChoice = scanner.nextInt();
        PoupeeRusse sourceDoll = dolls[sourceChoice - 1];


        PoupeeRusse internalDoll = sourceDoll.getPoupeeInterne();
        if (internalDoll != null) {
            sourceDoll.sortirDe(internalDoll);
            System.out.println("La poupée russe de taille " + internalDoll.getTaille() + " a été sortie de la poupée source.");
        } else {
            System.out.println("La poupée source ne contient pas d'autre poupée.");
        }
    }
}
