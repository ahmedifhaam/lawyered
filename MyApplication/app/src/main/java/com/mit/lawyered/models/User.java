package com.mit.lawyered.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Ahmed on 5/9/2017.
 */

public class User implements Parcelable{



    private String id;
    private String name;
    private String email;
    private String password;
    private String Balance;
    private String type;

    public User() {

    }

    public User(String id,String name){
        this.id=id;
        this.name = name;

    }

    public User(String id, String name, String email, String password, String balance,String type) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.Balance = balance;
        this.type=type;

    }

    protected User(Parcel in) {
        id = in.readString();
        name = in.readString();
        email = in.readString();
        password = in.readString();
        Balance = in.readString();
        type=in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

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

    public void setEmail(String email) {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(email);
        dest.writeString(password);
        dest.writeString(Balance);
        dest.writeString(type);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
