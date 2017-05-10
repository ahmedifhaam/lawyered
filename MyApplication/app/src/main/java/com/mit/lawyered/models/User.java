package com.mit.lawyered.models;

/**
 * Created by Ahmed on 5/9/2017.
 */

public class User {
    private String id;
    private String name;
    private String username;
    private String password;
    private String Balance;

    public User() {

    }

    public User(String id, String name, String username, String password, String balance) {
        this.id = id;
        this.name = name;
        this.username = username;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
