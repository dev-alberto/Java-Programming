package com.company;

import java.util.Date;
import java.util.Scanner;

public abstract class Persons {
    protected int ID;
    protected String firstName;
    protected String lastName;

    public Persons() {}

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public abstract boolean isFree();
}