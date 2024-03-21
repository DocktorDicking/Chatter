package cli;

import java.util.Scanner;

public class MenuRunner {
    private Scanner scanner;

    public MenuRunner() {
        scanner = new Scanner(System.in);
    }

    public void run() throws InterruptedException {
        showMenu();
        int choice = scanner.nextInt();
        navigateMenu(choice);
    }

    private void navigateMenu(int choice) throws InterruptedException {
        switch (choice) {
            case 1:
//                scanner.close();
                System.out.println(choice);
                // TODO show chats

                break;
            case 2:
//                scanner.close();
                System.out.println(choice);
                // TODO show profile
                break;
            case 3:
//                scanner.close();
                System.out.println(choice);
                System.out.println("Closing application");
                return;
            default:
                System.out.println("Invalid choice, please try again: ");
                this.run();
                break;
        }
    }

    private void showMenu() {
        System.out.println("=== Chatter Menu ===");
        System.out.println("1. Show chats");
        System.out.println("2. Show profile");
        System.out.println("0. Exit");

        System.out.print("Enter your choice: ");
    }
}
