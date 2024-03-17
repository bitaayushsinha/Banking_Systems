package Banking;
import java.util.Scanner;
public class CreateAccount {
    public static void create() {
        System.out.println("Creating Account...\n");
        String name, pass, choice;
        int acc_no, balance = 0;
        boolean saving;
        Scanner input = new Scanner(System.in);
        System.out.println("Name: ");
        name = input.nextLine();
        System.out.println("Password: ");
        pass = input.nextLine();
        System.out.println("Press 'y' for Saving Account: ");
        choice = input.nextLine();
        saving = choice.equals("y");

    }
}
