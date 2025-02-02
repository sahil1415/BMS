package com.sahil.Database;

import com.sahil.Model.Customer;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.UUID;

@Getter
@Setter
public class CustomerDatabase {
    private final ArrayList<Customer> customers;

    public CustomerDatabase(){
        this.customers = new ArrayList<>();
    }

    public Customer search_Customer(int customer_Id, String customer_Name, UUID account_Number){
        for(Customer cus : customers){
            if(cus.getUser_Id() == customer_Id && cus.getUser_Name().equals(customer_Name) && account_Number == cus.getAccount_Number()){
                return cus;
            }
        }
        return null;
    }
    public  void add_Customer(Customer customer){
        if(customer != null){
            customers.add(customer);
            System.out.println("Customer added successfully with the following information - ");
            customer.display_Info();
        }
        else{
            System.out.println("Invalid Customer");
        }
    }

    public void remove_Customer(int customer_Id, String customer_Name, UUID account_Number){
        Customer cus = search_Customer(customer_Id, customer_Name, account_Number);
        if(cus == null){
            System.out.println("Customer doesn't Exist");
        }
        else{
            customers.remove(cus);
            System.out.println("Customer removed successfully");
        }
    }

    public void check_Balance(int u_id, String u_name, UUID a_number){
        boolean flag = false;
        for(Customer cu : customers){
            if(cu.getUser_Id() == u_id && cu.getUser_Name().equals(u_name) && a_number == cu.getAccount_Number()){
                System.out.println("Account balance is - " + cu.getAccount_Balance());
                flag = true;
            }
        }
        if(!flag){
            System.out.println("Customer not found or invalid credentials");
        }
    }
}
