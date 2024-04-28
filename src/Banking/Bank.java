package Banking;
import java.util.Arrays;
import java.util.Scanner;

public class Bank {

    public static User[] Accounts = new User[]{
            new User(100001, "Aayush", "aayush18", "Savings", 50000.00d, 9262857521L),
            new User(100002, "Amruth", "qwer", "Current", 2550.00d, 9876543210L),
            new User(100003, "Rishi", "1234", "Savings", 1011.00d, 9123456789L),
    };

    public static void NewUser() {
        System.out.println("Name: ");
        String name = new Scanner(System.in).nextLine();

        System.out.println("Password: ");
        String pass = new Scanner(System.in).nextLine();

        System.out.println("Phone: ");
        long phone = new Scanner(System.in).nextLong();

        System.out.println("Press c for Current Account (Default: Savings)");
        String cur = new Scanner(System.in).nextLine();
        if (cur.equals("c") || cur.equals("C")) {
            System.out.println("Current Account!\n");
            cur = "Current";
        } else {
            System.out.println("Savings Account!\n");
            cur = "Saving";
        }

        User newUser = new User(100000 + Accounts.length + 1, name, pass, cur, 0, phone);
        Accounts = Arrays.copyOf(Accounts, Accounts.length + 1);
        Accounts[Accounts.length - 1] = newUser;
        System.out.println("Your Account Number: "+String.valueOf(newUser.getAcc_no())+"\n\n");
    }

    public static User Login() {

        System.out.println("Phone: ");
        long phone = new Scanner(System.in).nextLong();

        System.out.println("Password: ");
        String pass = new Scanner(System.in).nextLine();

        for (User nowUser : Accounts) {
            if(phone == nowUser.getPhone() && pass.equals(nowUser.getPass())){
                System.out.println("Logging Success..");
                return nowUser;
            }
        }
        return null;
    }

    public static void Transaction(User user1, User user2, double money){
        if(user1.getBalance()>=money){
            user1.withdraw(money);
            user2.deposit(money);
            System.out.println("Balance of " + user1.getName() + " : " + String.valueOf(user1.getBalance()));
            System.out.println("\nTransfer Success!!\n");
        }else{
            System.out.println("Not enough Money for the required transaction!!\n");
        }
    }

    public static void main(String[] args) {
        int choice;

        while (true) {
            System.out.println("""
                    ========================================================
                    ||         WELCOME TO OUR BANKING APPLICATION         ||
                    |======================================================|
                    || 1. Create Account                                  ||
                    || 2. Login                                           ||
                    || 3. Transfer Money                                  ||
                    || 4. Exit                                            ||
                    ========================================================
                    """
            );
            System.out.println("Enter Choice: ");
             choice = new Scanner(System.in).nextInt();

            System.out.println("\n========================================================");
            switch (choice) {
                case 1:
                    NewUser();
                    break;
                case 2:
                    User now_user = Login();
                    if (now_user == null){
                        System.out.println("Logging Failure... Invalid Credentials");
                    }else{
                        while (true) {
                            System.out.println("""
                                    ========================================================
                                    || 1. User Info                                       ||
                                    || 2. Deposit                                         ||
                                    || 3. Withdraw                                        ||
                                    || 4. Exit                                            ||
                                    ========================================================
                                    """);
                            System.out.println("Enter Choice: ");
                            Scanner ch = new Scanner(System.in);
                            int choice2 = ch.nextInt();
                            switch (choice2) {
                                case 1:
                                    System.out.println("Name : " + String.valueOf(now_user.getName()));
                                    System.out.println("Account No : " + String.valueOf(now_user.getAcc_no()));
                                    System.out.println("Account Type : " + String.valueOf(now_user.getType()));
                                    System.out.println("Balance : " + String.valueOf(now_user.getBalance())+"\n");
                                    break;
                                case 2:
                                    System.out.println("Enter the amount to be deposited: ");
                                    double Money = new Scanner(System.in).nextDouble();
                                    now_user.deposit(Money);
                                    System.out.println("Balance of " + now_user.getName() + " has " + String.valueOf(now_user.getBalance())+"\n");
                                    break;
                                case 3:
                                    System.out.println("Enter the amount to withdraw: ");
                                    double Money1 = new Scanner(System.in).nextDouble();
                                    now_user.withdraw(Money1);
                                    System.out.println("Balance of " + now_user.getName() + " : " + String.valueOf(now_user.getBalance())+"\n");
                                    break;
                                case 4:
                                    System.out.println("Going to home page..");
                                    break;
                                default:
                                    System.out.println("Invalid Choice\n\n========================================================\n");
                            }
                            if(choice2==4){
                                break;
                            }
                        }
                    }
                    break;
                case 3:
                    System.out.println("Enter the amount to be sent : ");
                    double Money = new Scanner(System.in).nextDouble();
                    System.out.println("Login Info for Payer? : \n");
                    User User1 = Login();
                    if (User1 == null){
                        System.out.println("Logging Failure.. Invalid Credentials");
                    }else {
                        System.out.println("\nAccount No. for recipient? : ");
                        int acc2 = new Scanner(System.in).nextInt();
                        boolean flag = false;
                        for (User User2 : Accounts) {
                            if(acc2 == User2.getAcc_no()){
                                Transaction(User1,User2,Money);
                                flag = true;
                            }
                        }
                        if(!flag){
                            System.out.println("Account Not Found!!");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Exiting..Thanks for Visiting.");
                    break;
                default:
                    System.out.println("Invalid Choice\n\n========================================================\n");
            }
            if(choice==4){
                break;
            }
        }
    }
}

