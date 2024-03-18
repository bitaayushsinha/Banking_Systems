package Banking;

public class user {
    int acc_no, balance;
    String name, password;
    boolean savings;

    public user(int acc_no, String name, String password, boolean savings, int balance){
        this.acc_no = acc_no;
        this.name = name;
        this.password = password;
        this.savings = savings;
        this.balance = balance;
    }

    public String LoginData(){
        return String.valueOf(acc_no)+" "+password;
    }
}
