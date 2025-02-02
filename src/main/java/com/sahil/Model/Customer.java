package com.sahil.Model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Customer extends User{
    private final String customer_Address;
    private final UUID account_Number;
    private int account_Balance;
    public int loan_amount = 0;
    public Customer(int user_Id, String user_Name, int user_Age, String customer_Address, int account_Balance) {
        super(user_Id, user_Name, user_Age);
        this.customer_Address = customer_Address;
        this.account_Number = UUID.randomUUID();
        this.account_Balance = account_Balance;
    }

    public void display_Info(){
        System.out.println("Customer Id - "+getUser_Id());
        System.out.println("Customer Name - "+getUser_Name());
        System.out.println("User Age - "+getUser_Age());
        System.out.println("Account Number - "+getAccount_Number());
        System.out.println("Customer Address -"+getCustomer_Address());
        System.out.println("Account Balance - " + getAccount_Balance());
        System.out.println("Loan Amount - "+ loan_amount);
    }
}
