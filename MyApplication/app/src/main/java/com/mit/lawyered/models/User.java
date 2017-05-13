package com.mit.lawyered.models;

/**
 * Created by Ahmed on 5/9/2017.
 */

public class User {
    private String id;
    private String name;
    private String email;
    private String password;
    private String Balance;

    public User() {

    }

    public User(String id,String name){
        this.id=id;
        this.name = name;

    }

    public User(String id, String name, String email, String password, String balance) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        Balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setUsername(String username) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBalance() {
        return Balance;
    }

    public void setBalance(String balance) {
        Balance = balance;
    }
}
