package com.sahil.Database;

import com.sahil.Model.Employee;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class EmployeeDatabase {
    private final ArrayList<Employee> employees;

    public EmployeeDatabase(){
        this.employees = new ArrayList<>();
    }

    public Employee searchEmployee(int emp_id, String emp_Name){
        for(Employee e : employees){
            if(e.getUser_Id() == emp_id && e.getUser_Name().equals(emp_Name)){
                return e;
            }
        }
        return null;
    }

    public void add_Employee(Employee emp){
        if(emp != null){
            employees.add(emp);
            System.out.println("Employee added successfully with the following information - ");
            emp.display_Info();
        }
        else{
            System.out.println("Invalid employee object");
        }
    }

    public void remove_Employee(int emp_id, String emp_Name){
        Employee emp = searchEmployee(emp_id, emp_Name);
        if(emp == null){
            System.out.println("Employee doesn't exist");
        }
        else{
            employees.remove(emp);
            System.out.println("Employee removed Successfully");
        }
    }


}
