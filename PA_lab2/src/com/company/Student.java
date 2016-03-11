package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student extends Person {
    private List<Project> projectsPreferred;
    private Project assignedProject;

    public Student() {
        projectsPreferred = new ArrayList<>();
        assignedProject = null;
    }

    public List<Project> getProjectsPreferred() {
        return projectsPreferred;
    }

    public Project getAssignedProject() {
        return assignedProject;
    }

    public void setAssignedProject(Project assignedProject) {
        this.assignedProject = assignedProject;
    }

    public List<Project> getProjectsPrefered() {
        return projectsPreferred;
    }

    public void setProjectsPreferred(List<Project> projectsPreferred) {
        this.projectsPreferred = projectsPreferred;
    }

    @Override
    public void read(Scanner scanner, Problem problem) {
        ID = scanner.nextInt();
        int numberOfProjectsPreferred = scanner.nextInt();
        for (int i = 0; i < numberOfProjectsPreferred; ++i) {
            projectsPreferred.add(problem.getProject(scanner.nextInt()));
        }
    }

    @Override
    public boolean isFree() {
        return assignedProject == null;
    }

    @Override
    public String toString() {
        String text = "Student " + ID + " prefers projects ";
        for (Project project : projectsPreferred) {
            text = text + project.getID() + " ";
        }
        return text;
    }

    @Override
    public boolean equals(Object obj) {
        return ((Student)obj).getID() == ID;
    }

    public Project getMostPreferredProject() {
        return projectsPreferred.get(0);
    }
}
