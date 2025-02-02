package com.sahil.Service;

import com.sahil.Database.CustomerDatabase;
import com.sahil.Model.Customer;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class TransactionManagement {
    CustomerDatabase cus;

    public void send_Money(int id1, String name1, UUID account1, int id2, String name2, UUID account2, int money){
        Customer c1 = cus.search_Customer(id1, name1, account1);
        Customer c2 = cus.search_Customer(id2, name2, account2);
        if(c1 == null){
            System.out.println("Sender's Account doesn't exist");
        }
        else if(c2 == null){
            System.out.println("Recipient's Account doesn't exist");
        }
        else{
            int balance1 = c1.getAccount_Balance();
            int balance2 = c2.getAccount_Balance();
            c1.setAccount_Balance(balance1-money);
            c2.setAccount_Balance(balance2+money);
            System.out.println("Money transferred successfully");
        }
    }
    public  void withdraw_Money(int id, String name, UUID accountNumber, int money){
        Customer c = cus.search_Customer(id, name, accountNumber);
        if(c != null){
            int balance = c.getAccount_Balance();
            if(balance < money){
                System.out.println("Balance not available");
            }
            else{
                c.setAccount_Balance(balance-money);
                System.out.println("Money Withdrawn successfully");
            }
        }
        else{
            System.out.println("Account number not found");
        }
    }
}
