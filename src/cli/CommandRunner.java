package cli;

import controller.Authentication;
import model.User;

import java.util.Scanner;

/**
 * Will be responsible for the CLI usage of this application.
 * Since we are not sure if we ever gonna create a gui for this let's go with this for now.
 */
public class CommandRunner {
    private Scanner scanner;
    private Authentication auth;

    public CommandRunner() {
        scanner = new Scanner(System.in);
        auth = Authentication.getInstance();
    }

    public void run() throws InterruptedException {
        System.out.println("=== Chatter application ===");
        System.out.println("Welcome to chatter application.");
        System.out.println("Please supply your username: ");
        String username = scanner.nextLine();

        System.out.println("Please supply your password: ");
        String password = scanner.nextLine();
        scanner.close();

        System.out.println("=== Trying to authenticate, please wait.. ===");
        Thread.sleep(250);

        User user = auth.authenticate(username, password);
        if (user != null) {
            System.out.println("Authentication successfull.");
            System.out.println("=== Redirecting to menu, please wait... ===");
            Thread.sleep(500);

            MenuRunner menu = new MenuRunner();
            menu.run();
        } else {
            System.out.println("=== Authentication failed. System will shutdown. ===");
        }
    }
}
