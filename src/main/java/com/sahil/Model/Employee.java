package com.sahil.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee extends User{
    private String employee_Role;

    public Employee(int employee_Id, String employee_Name, int employee_Age, String employee_Role){
        super(employee_Id, employee_Name, employee_Age);
        this.employee_Role = employee_Role;
    }

    public void display_Info() {
        System.out.println("Employee Id - " +getUser_Id());
        System.out.println("Employee Name - " +getUser_Name());
        System.out.println("Employee Age - " +getUser_Age());
        System.out.println("Employee role - " +getEmployee_Role());
    }
}
