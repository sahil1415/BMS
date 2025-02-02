package com.sahil.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private final int user_Id;
    private final String user_Name;
    private final int user_Age;

    public User(int user_Id, String user_Name, int user_Age){
        this.user_Id = user_Id;
        this.user_Name = user_Name;
        this.user_Age = user_Age;
    }

    public void display_Info(){
        System.out.println("User Id - "+getUser_Id());
        System.out.println("User Name - "+ getUser_Name());
        System.out.println("User Age - "+getUser_Age());
    }
}
