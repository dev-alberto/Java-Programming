package com.company;


import java.util.Date;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Student extends Persons {
    Project assignedProject;
    LinkedList<Project> preferanceList;

    public Student() {
        assignedProject = new Project();
        preferanceList = new LinkedList<>();
    }

    public void assignProject(Project project) {
        assignedProject = project;
    }

    public void removePreferance(Project project) {
        for (ListIterator it = preferanceList.listIterator(); it.hasNext(); it.next()) {
            if (project.equals(it)) {
                it.remove();
                return;
            }
        }
    }

    public boolean isProjectListEmpty() {
        return preferanceList.isEmpty();
    }

    public Project getFirstProjectFromPreferanceList() {
        return preferanceList.getFirst();
    }

    void removeProject() {
        assignedProject = null;
    }

    @Override
    public boolean isFree() {
        return assignedProject != null;
    }

    public static Persons construct(Scanner scanner) {
        return null;
    }
}