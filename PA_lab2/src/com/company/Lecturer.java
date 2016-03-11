<<<<<<< HEAD
package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lecturer extends Person {
    List<Student> studentsPreferred;
    List<Project> projectsList;
    List<Student> assignedStudents;
    int capacity;

    public Lecturer() {
        studentsPreferred = new ArrayList<>();
        projectsList = new ArrayList<>();
        assignedStudents = new ArrayList<>();
    }

    public List<Student> getStudentsPreferred() {
        return studentsPreferred;
    }

    public void setStudentsPreferred(List<Student> studentsPreferred) {
        this.studentsPreferred = studentsPreferred;
    }

    public List<Project> getProjectsList() {
        return projectsList;
    }

    public void setProjectsList(List<Project> projectsList) {
        this.projectsList = projectsList;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Student> getAssignedStudents() {
        return assignedStudents;
    }

    public void setAssignedStudents(List<Student> assignedStudents) {
        this.assignedStudents = assignedStudents;
    }

    @Override
    public void read(Scanner scanner, Problem problem) {
        ID = scanner.nextInt();
        capacity = scanner.nextInt();
        int numberOfStudents = scanner.nextInt();
        for (int i = 0; i < numberOfStudents; ++i) {
            int student = scanner.nextInt();
            studentsPreferred.add(problem.getStudent(student));
        }
        int numberOfProject = scanner.nextInt();
        for (int i = 0; i < numberOfProject; ++i) {
            int projectID = scanner.nextInt();
            Project tempProject = problem.getProject(projectID);
            projectsList.add(tempProject);
            tempProject.setLecturer(this);
            tempProject.constructPossibleAssignedStudentsInOrder(this.studentsPreferred);
        }
    }

    @Override
    public boolean isFree() {
        return capacity < assignedStudents.size();
    }

    public boolean isOverSubscribed() {
        return capacity < assignedStudents.size();
    }

    @Override
    public String toString() {
       String text = "Lecturer L" + ID + " prefers students ";
        for (Student student : studentsPreferred) {
            text = text + student.getID() + " ";
        }
        text = text + "and is responsible for project ";
        for (Project project : projectsList) {
            text = text + project.getID() + " ";
        }
        return text;
    }

    @Override
    public boolean equals(Object obj) {
        return ((Lecturer)obj).getID()==ID;
    }

    public void addAssignedStudent(Student student) {
        assignedStudents.add(student);
    }

    public Student worstStudentAssigned() {
        Student worstStudent = null;
        for (Student student : studentsPreferred) {
            if (assignedStudents.contains(student)) {
                worstStudent = student;
            }
        }
        return worstStudent;
    }

    public boolean isFull() {
        return capacity == assignedStudents.size();
    }

    public void cleanLists(Student worstStudent) {
        while (!worstStudent.equals(studentsPreferred.get(studentsPreferred.size()-1))) {
            Student student = studentsPreferred.get(studentsPreferred.size()-1);
            studentsPreferred.remove(studentsPreferred.size()-1);
            for (Project project : projectsList) {
                if (student.getProjectsPrefered().contains(project)) {
                    student.getProjectsPrefered().remove(project);
                    project.getPossibleAssignedStudentsInOrder().remove(student);
                }
            }
        }
    }
}
=======
package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lecturer extends Person {
    List<Student> studentsPreferred;
    List<Project> projectsList;
    List<Student> assignedStudents;
    int capacity;

    public Lecturer() {
        studentsPreferred = new ArrayList<>();
        projectsList = new ArrayList<>();
        assignedStudents = new ArrayList<>();
    }

    public List<Student> getStudentsPreferred() {
        return studentsPreferred;
    }

    public void setStudentsPreferred(List<Student> studentsPreferred) {
        this.studentsPreferred = studentsPreferred;
    }

    public List<Project> getProjectsList() {
        return projectsList;
    }

    public void setProjectsList(List<Project> projectsList) {
        this.projectsList = projectsList;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Student> getAssignedStudents() {
        return assignedStudents;
    }

    public void setAssignedStudents(List<Student> assignedStudents) {
        this.assignedStudents = assignedStudents;
    }

    @Override
    public void read(Scanner scanner, Problem problem) {
        ID = scanner.nextInt();
        capacity = scanner.nextInt();
        int numberOfStudents = scanner.nextInt();
        for (int i = 0; i < numberOfStudents; ++i) {
            int student = scanner.nextInt();
            studentsPreferred.add(problem.getStudent(student));
        }
        int numberOfProject = scanner.nextInt();
        for (int i = 0; i < numberOfProject; ++i) {
            int projectID = scanner.nextInt();
            Project tempProject = problem.getProject(projectID);
            projectsList.add(tempProject);
            tempProject.setLecturer(this);
            tempProject.constructPossibleAssignedStudentsInOrder(this.studentsPreferred);
        }
    }

    /**
     * Method that checks if a a lecturer has reached the quota of assigned students
     * @return boolean
     */

    @Override
    public boolean isFree() {
        return capacity < assignedStudents.size();
    }



    public boolean isOverSubscribed() {
        return capacity < assignedStudents.size();
    }

    /**
     * Method that prints out lecturer's preferences and project assignments
     * @return String
     */

    @Override
    public String toString() {
       String text = "Lecturer L" + ID + " prefers students ";
        for (Student student : studentsPreferred) {
            text = text + student.getID() + " ";
        }
        text = text + "and is responsible for project ";
        for (Project project : projectsList) {
            text = text + project.getID() + " ";
        }
        return text;
    }

    @Override
    public boolean equals(Object obj) {
        return ((Lecturer)obj).getID()==ID;
    }

    public void addAssignedStudent(Student student) {
        assignedStudents.add(student);
    }

    /**
     * Method that iterates through the studentPreferred list in search for the worst assigned student
     * @return Student object, worst student
     */

    public Student worstStudentAssigned() {
        Student worstStudent = null;
        for (Student student : studentsPreferred) {
            if (assignedStudents.contains(student)) {
                worstStudent = student;
            }
        }
        return worstStudent;
    }

    /**
     * Method that checks if the maxim number of students have been assigned
     * @return boolean
     */

    public boolean isFull() {
        return capacity == assignedStudents.size();
    }


    public void cleanLists(Student worstStudent) {
        while (!worstStudent.equals(studentsPreferred.get(studentsPreferred.size()-1))) {
            Student student = studentsPreferred.get(studentsPreferred.size()-1);
            studentsPreferred.remove(studentsPreferred.size()-1);
            for (Project project : projectsList) {
                if (student.getProjectsPrefered().contains(project)) {
                    student.getProjectsPrefered().remove(project);
                    project.getPossibleAssignedStudentsInOrder().remove(student);
                }
            }
        }
    }
}
>>>>>>> dev-alberto-tema4
