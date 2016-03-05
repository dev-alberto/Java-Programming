package com.company;

import java.util.Scanner;

public abstract class Person {
    protected int ID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public abstract void read(Scanner scanner, Problem problem);

    public abstract boolean isFree();
}
