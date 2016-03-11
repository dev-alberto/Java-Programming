package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

public class Problem {
    List<Project>  projectsList;
    List<Student> studentsList;
    List<Lecturer> lecturersList;

    /**
     * Problem class constructor, allocates memory for Project,Student,lecturer Lists
     */

    public Problem() {
        projectsList = new ArrayList<Project>();
        studentsList = new ArrayList<Student>();
        lecturersList = new ArrayList<Lecturer>();
    }

    private void readProjectsList() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("projects.txt"));
        int numberOfProjects = scanner.nextInt();
        for (int i = 0; i < numberOfProjects; ++i) {
            Project tempProject = new Project();
            tempProject.readProject(scanner);
            projectsList.add(tempProject);
        }
    }

    private void readStudentsList() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("students.txt"));
        int numberOfStudents = scanner.nextInt();
        for (int i = 0; i < numberOfStudents; ++i) {
            Student tempStudent = new Student();
            tempStudent.read(scanner, this);
            studentsList.add(tempStudent);
        }
    }

    private void readLecturerList() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("lecturers.txt"));
        int numberOfLecturers = scanner.nextInt();
        for (int i = 0; i < numberOfLecturers; ++i) {
            Lecturer tempLecturer = new Lecturer();
            tempLecturer.read(scanner, this);
            lecturersList.add(tempLecturer);
        }
    }

    /**
     * Method used to read Students, Project and Lecturer Lists
     */

    public void readInstance() {
        try {
            readProjectsList();
            readStudentsList();
            readLecturerList();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void writeProjects() {
        for (Project project:projectsList) {
            System.out.println(project.toString());
        }
    }

    private void writeStudents() {
        for (Student students : studentsList) {
            System.out.println(students.toString());
        }
    }

    private void writeLecturer() {
        for (Lecturer lecturer : lecturersList) {
            System.out.println(lecturer.toString());
        }
    }

    /**
     * Methods that prints out Projects,Students and Lecturer Lists
     */

    public void writeInstance() {
        writeProjects();
        writeStudents();
        writeLecturer();
    }

    public Project getProject(int ID) {
        for (Project project : projectsList) {
            if (project.getID() == ID) {
                return project;
            }
        }
        return null;
    }

    public Student getStudent(int ID) {
        for (Student student : studentsList) {
            if (student.getID() == ID) {
                return student;
            }
        }
        return null;
    }

    private Student getStudentsWithoutProjectAssigned() {
        for (Student student : studentsList) {
            if (student.isFree() && !student.getProjectsPrefered().isEmpty()) {
                return student;
            }
        }
        return null;
    }

    private void assign(Student student, Project project) {
        student.setAssignedProject(project);
        project.assignStudent(student);
    }

    private void breakAgreement(Student student, Project project) {
        student.setAssignedProject(null);
        project.getStudentsAssigned().remove(student);
        project.getLecturer().getAssignedStudents().remove(student);
    }

    /**
     * The algorithm for SPA that is student oriented and finds a stable matching
     */

    public void computeStableMatching() {
        Student student;
        do{
            student = getStudentsWithoutProjectAssigned();
            if (student != null) {
                Project project = student.getMostPreferredProject();
                Lecturer lecturer = project.getLecturer();
                assign(student, project);

                if (project.isOverSubscribed()) {
                    Student worstStudent = project.worstStudentAssigned();
                    breakAgreement(worstStudent, project);
                }
                else if (lecturer.isOverSubscribed()) {
                    Student worstStudent = lecturer.worstStudentAssigned();
                    Project worstsStudentProject = worstStudent.getAssignedProject();
                    breakAgreement(worstStudent, worstsStudentProject);
                }
                if (project.isFull()) {
                    Student worstStudent = project.worstStudentAssigned();
                    project.cleanLists(worstStudent);
                }
                if (lecturer.isFull()) {
                    Student worstStudent = lecturer.worstStudentAssigned();
                    lecturer.cleanLists(worstStudent);
                }
            }
        }while (student != null);
    }

    public void writeSolution() {
        for (Student student : studentsList) {
            if (student.getAssignedProject() != null) {
                System.out.println("The Student S" + student.getID() + " was assigned to the project P" + student.getAssignedProject().getID());
            }
        }
    }
}
