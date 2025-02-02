package com.sahil;

import com.sahil.Database.CustomerDatabase;
import com.sahil.Database.EmployeeDatabase;
import com.sahil.Database.LoanDatabase;
import com.sahil.Model.Customer;
import com.sahil.Model.Employee;
import com.sahil.Service.TransactionManagement;

import java.util.Scanner;
import java.util.UUID;

public class Launch {
    CustomerDatabase cd = new CustomerDatabase();
    EmployeeDatabase ed = new EmployeeDatabase();
    LoanDatabase ld = new LoanDatabase();

    public void launch() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to the World Bank");
            System.out.println("Enter your choices");
            System.out.println("1 -> Enter a customer");
            System.out.println("2 -> Enter an Employee");
            System.out.println("3 -> Remove a Customer");
            System.out.println("4 -> Remove an Employee");
            System.out.println("5 -> Send Money");
            System.out.println("6 -> Withdraw money");
            System.out.println("7 -> Check account balance");
            System.out.println("8 -> Take loan");
            System.out.println("9 -> Display loan holders");
            System.out.println("10 -> Exit");

            int n = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (n) {
                case 1:
                    System.out.println("Enter Customer details - ");
                    System.out.println("Enter Customer id - ");
                    int cid = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Customer Name - ");
                    String cname = sc.nextLine();
                    System.out.println("Enter Customer age - ");
                    int cage = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Customer address - ");
                    String caddress = sc.nextLine();
                    Customer c = new Customer(cid, cname, cage, caddress, 0);
                    cd.add_Customer(c);
                    break;

                case 2:
                    System.out.println("Enter Employee details - ");
                    System.out.println("Enter Employee id - ");
                    int eid = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Employee Name - ");
                    String ename = sc.nextLine();
                    System.out.println("Enter Employee age - ");
                    int eage = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Employee address - ");
                    String eaddress = sc.nextLine();
                    System.out.println("Enter Employee position - ");
                    String eposition = sc.nextLine();
                    Employee e = new Employee(eid, ename, eage, eposition);
                    ed.add_Employee(e);
                    break;

                case 3:
                    System.out.println("Enter the customer details - ");
                    System.out.println("Enter customer id - ");
                    int c1id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Customer Name - ");
                    String c1name = sc.nextLine();
                    System.out.println("Enter account number - ");
                    String account = sc.nextLine();

                    UUID uuid = null;
                    try {
                        uuid = UUID.fromString(account);
                    } catch (IllegalArgumentException ex) {
                        System.out.println("Invalid UUID format.");
                        break;
                    }

                    cd.remove_Customer(c1id, c1name, uuid);
                    break;

                case 4:
                    System.out.println("Enter Employee details - ");
                    System.out.println("Enter Employee id - ");
                    int e1id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Employee Name - ");
                    String e1name = sc.nextLine();
                    ed.remove_Employee(e1id, e1name);
                    break;

                case 5:
                    System.out.println("Enter Sender and recipient details - ");
                    System.out.println("Enter sender's id - ");
                    int id1 = sc.nextInt();
                    System.out.println("Enter receiver's id - ");
                    int id2 = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Sender's name - ");
                    String n1 = sc.nextLine();
                    System.out.println("Enter receiver's name - ");
                    String n2 = sc.nextLine();
                    System.out.println("Enter Sender's account number - ");
                    String a1 = sc.nextLine();
                    System.out.println("Enter Receiver's account number - ");
                    String a2 = sc.nextLine();
                    System.out.println("Enter the amount to be sent - ");
                    int amount = sc.nextInt();

                    UUID uuid1, uuid2;
                    try {
                        uuid1 = UUID.fromString(a1);
                        uuid2 = UUID.fromString(a2);
                    } catch (IllegalArgumentException ex) {
                        System.out.println("Invalid UUID format.");
                        break;
                    }

                    TransactionManagement tm = new TransactionManagement(cd);
                    tm.send_Money(id1, n1, uuid1, id2, n2, uuid2, amount);
                    break;

                case 6:
                    System.out.println("Enter Customer id - ");
                    int id3 = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Customer name - ");
                    String n3 = sc.nextLine();
                    System.out.println("Enter account number -");
                    String u3 = sc.nextLine();
                    System.out.println("Enter the amount to be withdrawn - ");
                    int amountw = sc.nextInt();

                    UUID uuid3;
                    try {
                        uuid3 = UUID.fromString(u3);
                    } catch (IllegalArgumentException ex) {
                        System.out.println("Invalid UUID format.");
                        break;
                    }

                    TransactionManagement tr = new TransactionManagement(cd);
                    tr.withdraw_Money(id3, n3, uuid3, amountw);
                    break;

                case 7:
                    System.out.println("Under Development");
                    break;

                case 8:
                    System.out.println("Under development");
                    break;
                case 9:
                    System.out.println("Under Development");

                case 10:
                    System.out.println("Exited Successfully");
                    sc.close();
                    return;
            }
        }
    }

    public static void main(String[] args) {
        Launch l = new Launch();
        l.launch();
    }
}
