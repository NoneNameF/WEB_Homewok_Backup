package com.domain;

public class Manager {
    private Integer ID;
    private String Name;
    private String Password;

    @Override
    public String toString() {
        return "user{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public  String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public  String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }


}
