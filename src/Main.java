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

        private static void printMenu() {
            System.out.println("Menu :");
            System.out.println("1. Jouer avec les poupées");
            System.out.println("2. Afficher les informations des poupées");
            System.out.println("3. Placer une poupée dans une autre (1ère poupée dans 2ème poupée)");
            System.out.println("4. Placer une poupée dans une autre (2ème poupée dans 3ème poupée)");
            System.out.println("5. Quitter");
            System.out.print("Choix : ");
        }

        do {
            printMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                 