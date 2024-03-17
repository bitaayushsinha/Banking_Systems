package Banking;
import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {
        int acc_no, choice;
        String pass;
        System.out.println("""
                1. Create Account
                2. Login
                3. Find Account Number
                4. Exit
                """
        );
        System.out.println("Enter Choice");
        Scanner input = new Scanner(System.in);
        choice = input.nextInt();
        switch (choice){
            case 1:
                CreateAccount.create();
                break;
            case 2:
                Login.login();
                break;
            case 3:
                Find.find();
                break;
            case 4:
                break;
            default:
                System.out.println("Invalid Choice\n\n");
                main(new String[]{""});
        }

    }
}
