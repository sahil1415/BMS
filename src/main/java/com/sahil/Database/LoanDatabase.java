package com.sahil.Database;

import com.sahil.Model.Customer;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.UUID;

@Getter
@Setter
public class LoanDatabase {
    private final ArrayList<Customer> loan_holders;
    private CustomerDatabase cu;

    public LoanDatabase(ArrayList<Customer> loan_holders){
        this.loan_holders = loan_holders;
    }

    public void take_Loan(int u_id, String u_name, UUID account_Number, int loan_amount){
        Customer cus = cu.search_Customer(u_id, u_name, account_Number);
        if(cus == null){
            System.out.println("Customer not found, Register yourself first ");
        }
        else{
            cus.loan_amount = loan_amount;
            loan_holders.add((cus));
            System.out.println("Loan Granted Successfully");
        }
    }

    public void return_Loan(int u_id, String u_name, UUID account_Number, int amount){
        Customer cus =  cu.search_Customer(u_id, u_name, account_Number);
        if(cus != null){
            cus.loan_amount -= amount;
            if(cus.loan_amount == 0){
                loan_holders.remove(cus);
                System.out.println("Loan paid successfully ");
            }
            else{
                System.out.println("Loan paid successfully, remaining amount is - "+cus.loan_amount);
            }
        }
    }

    public void display_loan_holders(){
        for(Customer c : loan_holders){
            c.display_Info();
        }
    }
}
