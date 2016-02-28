package com.company;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Lecturer extends Persons {
    private LinkedList<Student> preferredStudents;
    private LinkedList<Project> myProjects;
    private LinkedList<Student> myStudents;

    public LinkedList<Student> getPreferredStudents() {
        return preferredStudents;
    }

    public void setPreferredStudents(LinkedList<Student> preferredStudents) {
        this.preferredStudents = preferredStudents;
    }

    public LinkedList<Project> getMyProjects() {
        return myProjects;
    }

    public void setMyProjects(LinkedList<Project> myProjects) {
        this.myProjects = myProjects;
    }

    public LinkedList<Student> getMyStudents() {
        return myStudents;
    }

    public void setMyStudents(LinkedList<Student> myStudents) {
        this.myStudents = myStudents;
    }

    private int capacity;

    public Lecturer() {
        preferredStudents = new LinkedList<>();
        myProjects = new LinkedList<>();
    }

    @Override
    public boolean isFree() {
        return myStudents.size() < capacity;
    }

    private void addProject(ArrayList<Project> projectsList, int id) {
        myProjects.addFirst(Utils.findProject(projectsList, id));
    }

    private void addStudents(ArrayList<Student> studentsList, int id) {
        preferredStudents.addFirst(Utils.findStudents(studentsList, id));
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public static Lecturer construct(ArrayList<Student> studentsList, ArrayList<Project> projectsList, Scanner scanner) {
        Lecturer newLecturer = new Lecturer();
        Persons.constructPerson(newLecturer, scanner);

        newLecturer.setCapacity(scanner.nextInt());

        int numberOfProjects = scanner.nextInt();
        for (int i = 0; i < numberOfProjects; ++i) {
            int ID = scanner.nextInt();
            newLecturer.addProject(projectsList, ID);
        }

        int numberOfStudents = scanner.nextInt();
        for (int i = 0; i < numberOfStudents; ++i) {
            int ID = scanner.nextInt();
            newLecturer.addStudents(studentsList, ID);
        }

        return newLecturer;
    }

    public Student getLeastPreferredStudentAssignedToAProject() {
        for (Student student : preferredStudents) {
            if (myStudents.contains(student)) {
                return student;
            }
        }
        return null;
    }

    public void removeStudentsWorstThan(Student student) {
        for(ListIterator<Student> it = preferredStudents.listIterator();
            !student.equals(it); it = preferredStudents.listIterator()) {

            it.remove();
        }
    }

    public void assignProject(Student student) {
        myStudents.add(student);
    }

    public boolean isOverSubscribed() {
        return myStudents.size() > capacity;
    }

    public boolean isFull() {
        return myStudents.size() == capacity;
    }

    public void addSupervisedStudent(Student student) {
        myStudents.add(student);
    }

    public Student getLeastPreferredStudentAssignedToProiect(Project project) {
        for (Student student : preferredStudents) {
            if (myStudents.contains(student) && student.getAssignedProject().equals(project)) {
                return student;
            }
        }
        return null;
    }

    public void breakAssignment(Student student) {
        myStudents.remove(student);
    }
}
