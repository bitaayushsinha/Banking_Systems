package Banking;

import java.util.Arrays;
import java.util.Scanner;

public class User {
    private long acc_no, phone;
    private double bal;
    private String name, pass,type;
    public User(long acc_no, String name, String pass, String type, double bal, long phone)
    {
        this.acc_no = acc_no;
        this.name = name;
        this.pass = pass;
        this.type = type;
        this.bal = bal;
        this.phone = phone;
    }
    public long getAcc_no()
    {
        return acc_no;
    }
    public String getName(){return name;}
    public String getPass(){return pass;}
    public String getType(){return type;}
    public long getPhone(){return phone;}
    public double getBalance(){return bal;}
    public void deposit(double money){bal += money;}
    public void withdraw(double money){
        if (bal>= money){
            bal -= money;
        }else{System.out.println("You only have "+bal+" amount of money!!!!!");}
    }

}

