package com.company;


import java.util.*;

public class Student extends Persons {
    Project assignedProject;
    LinkedList<Project> preferanceList;

    public Student() {
        assignedProject = new Project();
        preferanceList = new LinkedList<>();
    }

    public void assignProject(Project project) {
        assignedProject = project;
        project.assignProject(this);
    }

    public Project getAssignedProject() {
        return assignedProject;
    }

    public void setAssignedProject(Project assignedProject) {
        this.assignedProject = assignedProject;
    }

    public LinkedList<Project> getPreferanceList() {
        return preferanceList;
    }

    public void setPreferanceList(LinkedList<Project> preferanceList) {
        this.preferanceList = preferanceList;
    }

    public void removePreferance(Project project) {
        preferanceList.remove(project);
    }

    public void breakAssignement(Project project) {
        assignedProject.breakAssignement(this);
        assignedProject = null;
    }

    public boolean isProjectListEmpty() {
        return preferanceList.isEmpty();
    }

    public Project getFirstProjectFromPreferanceList() {
        return preferanceList.getLast();
    }

    void removeProject() {
        assignedProject = null;
    }

    @Override
    public boolean isFree() {
        return assignedProject != null;
    }

    public void add(AbstractList<Project> projectList, int ID) {
        preferanceList.addFirst(Utils.findProject(projectList, ID));
    }

    public static Student construct(final AbstractList<Project> project, Scanner scanner) {
        Student newStudent = new Student();
        Persons.constructPerson(newStudent, scanner);
        int numberOfProjects = scanner.nextInt();
        for (int i = 0; i < numberOfProjects; ++i) {
            int ID = scanner.nextInt();
            newStudent.add(project, ID);
        }
        return newStudent;
    }
}