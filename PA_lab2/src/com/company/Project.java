package com.company;

import java.util.Scanner;

public class Project {
    private int ID;
    private Lecturer lecturer;
    private int capacity;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public static Project construct(Scanner scanner) {
        Project newPeoject = new Project();
        if (scanner.hasNext()) {
            newPeoject.setID(scanner.nextInt());
        }
        else {
            System.err.println
                    ("There is not enough information in file where is stored the information about the projects");
        }

        if (scanner.hasNext()) {
            newPeoject.setCapacity(scanner.nextInt());
        }
        else {
            System.err.println
                    ("There is not enough information in file where is stored the information about the projects");
        }
        return newPeoject;
    }
}