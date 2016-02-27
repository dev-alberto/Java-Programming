package com.company;


import java.util.Scanner;

public class Lecturer extends Persons {


    @Override
    public boolean isFree() {
        return false;
    }

    public static Persons construct(Scanner scanner) {
        return null;
    }
}
