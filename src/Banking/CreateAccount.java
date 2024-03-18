package Banking;
import java.util.Scanner;
public class CreateAccount {

    public static boolean checkforchar(String str, String character){
        for (int i=0; i<str.length(); i++){
            int flag = 0;
            char a = str.charAt(i);
            for (int j = 0; j < character.length(); j++) {
                char b = character.charAt(j);
                if(a==b){
                    flag = 1;
                    break;
                }
            }
            if(flag==0) {
                return false;
            }
        }
        return true;
    }
    public static void create() {
        System.out.println("Creating Account...\n");
        String name, pass, temp, choice;
        int acc_no, balance = 0;
        boolean saving;
        Scanner input = new Scanner(System.in);
        System.out.println("Name: ");
        name = input.nextLine();
        while (true) {
            System.out.println("Password: ");
            pass = input.nextLine();
            System.out.println("Password Again: ");
            temp = input.nextLine();
            if(pass.equals(temp)&&
                    (pass.length()>=8)&&
                    (checkforchar(pass," !@#$%^&*()-_=+[{]}|:;'<,>.?/abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"))){
                break;
            } else if (!pass.equals(temp)) {
                System.out.println("\nPasswords Do Not Match!!!\nPlease Enter Again:\n");
            }else if(pass.length()<8){
                System.out.println("\nPassword must Be more than or equal to 8 Characters!!!\nPlease Enter Again:\n");
            }else{
                System.out.println("\nPassword Contains an Illegal character!!!\nOnly Legal Characters are' !@#$%^&*()-_=+[{]}|:;'<,>.?/abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789'\nPlease Enter Again:\n");
            }
        }
        System.out.println("Press 'y' for Saving Account: ");
        choice = input.nextLine();
        saving = choice.equals("y");
        int lastAccount = Integer.parseInt(utils.getAccNo("texts/login.txt"));
        acc_no = lastAccount+1;
        user newuser = new user(acc_no,name,pass,saving,balance);

        System.out.println(newuser.LoginData());
    }
}
