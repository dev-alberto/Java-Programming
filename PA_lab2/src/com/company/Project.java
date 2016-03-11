package com.company;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Project {
    private int ID;
    private int capacity;
    private Lecturer lecturer;
    private List<Student> possibleAssignedStudentsInOrder;
    private List<Student> studentsAssigned;

    public Project(){
        possibleAssignedStudentsInOrder = new ArrayList<>();
        studentsAssigned = new ArrayList<>();
    }

    public List<Student> getStudentsAssigned() {
        return studentsAssigned;
    }

    public void setStudentsAssigned(List<Student> studentsAssigned) {
        this.studentsAssigned = studentsAssigned;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public List<Student> getPossibleAssignedStudentsInOrder() {
        return possibleAssignedStudentsInOrder;
    }

    public void setPossibleAssignedStudentsInOrder(List<Student> possibleAssignedStudentsInOrder) {
        this.possibleAssignedStudentsInOrder = possibleAssignedStudentsInOrder;
    }

    public void readProject(Scanner scanner) {
        ID = scanner.nextInt();
        capacity = scanner.nextInt();
    }

    public void constructPossibleAssignedStudentsInOrder(List<Student> studentsList) {
        for (Student student : studentsList) {
            if (student.getProjectsPrefered().contains(this)) {
                possibleAssignedStudentsInOrder.add(student);
            }
        }
    }

    @Override
    public String toString() {
        return "Projects P" + ID + " capacity is " + capacity;
    }

    @Override
    public boolean equals(Object obj) {
        return ((Project)obj).getID() == ID;
    }

    public void assignStudent(Student student) {
        studentsAssigned.add(student);
        lecturer.addAssignedStudent(student);
    }

    public boolean isOverSubscribed() {
        return capacity < studentsAssigned.size();
    }

    public Student worstStudentAssigned() {
        Student worstStudent = null;
        for (Student student : possibleAssignedStudentsInOrder) {
            if (studentsAssigned.contains(student) && student.getAssignedProject().equals(this)) {
                worstStudent = student;
            }
        }
        return worstStudent;
    }

    public boolean isFull() {
        return capacity == studentsAssigned.size();
    }

    public void cleanLists(Student worstStudent) {
        while (!worstStudent.equals(possibleAssignedStudentsInOrder.get(possibleAssignedStudentsInOrder.size()-1))) {
            Student student = possibleAssignedStudentsInOrder.get(possibleAssignedStudentsInOrder.size()-1);
            possibleAssignedStudentsInOrder.remove(possibleAssignedStudentsInOrder.size() - 1);
            student.getProjectsPrefered().remove(this);
        }
    }
}
