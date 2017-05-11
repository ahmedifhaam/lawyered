package com.mit.lawyered.models;


/**
 * Created by S.T.Sarma on 5/9/2017.
 */

public class Contact {

    String type,name,uname,pass,contact,description,thirdtype;



    public void setType(String type)
    {
        this.type=type;
    }

    public String getType(){
        return this.type;
    }
    public void setName(String name)
    {
        this.name=name;
    }

    public String getName(){
        return this.name;
    }

    public void setUname(String uname)
    {
        this.name=name;
    }

    public String getUname(){
        return this.uname;
    }
    public void setPass (String pass)
    {
        this.pass=pass;
    }

    public String getPass(){
        return this.pass;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContact(){
        return this.contact;
    }
    public void setDescription(String description)
    {
        this.description=description;
    }

    public String getDescription(){
        return this.description;
    }
    public void setThirdtype(String thirdtype)
    {
        this.thirdtype=thirdtype;
    }

    public String getThirdtype(){
        return this.thirdtype;
    }

}
