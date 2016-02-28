package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem {
    private ArrayList<Project> projectsList;
    private ArrayList<Student> studentsList;
    private ArrayList<Lecturer> lecturerList;
    private ArrayList<Student>[][] studentsSortedByLecturersPreferance;

    public Problem(){
        projectsList = new ArrayList<>();
        studentsList = new ArrayList<>();
        lecturerList = new ArrayList<>();
    }

    private Scanner getScanner(String filePath) {
        Scanner file = null;
        try {
            file = new Scanner(new File(filePath));
        }
        catch (Exception exeptionOpeningFile) {
            System.out.println(exeptionOpeningFile.getMessage());
        }
        return file;
    }

    // TODO: 27.02.2016 ID-uri unice
    private void readProjectsList(String projectsFile) {
        Scanner scanner = getScanner(projectsFile);
        if (scanner != null) {
            if (scanner.hasNext()) {
                System.err.println("There is not enough information in file  " + projectsFile);
            } else {
                int numberOfProjects = scanner.nextInt();
                for (int i = 0; i < numberOfProjects; ++i) {
                    projectsList.add(Project.construct(scanner));
                }
            }
        }
    }

    // TODO: 27.02.2016 ID-uri unice
    private void readStudentList(TypeOfPerson typeOfPerson, String file, ArrayList<Student> studentsList) {
        Scanner scanner = getScanner(file);
        if (scanner != null) {
            if (scanner.hasNext()) {
                System.err.println("There is not enough information in file  " + file);
            } else {
                int numberOfStudents = scanner.nextInt();
                for (int i = 0; i < numberOfStudents; ++i) {
                    studentsList.add(Student.construct(projectsList, scanner));
                }
            }
        }
    }

    // TODO: 27.02.2016 ID-uri unice
    private void readLecturerList(TypeOfPerson typeOfPerson, String file, ArrayList<Lecturer> lecturerList) {
        Scanner scanner = getScanner(file);
        if (scanner != null) {
            if (scanner.hasNext()) {
                System.err.println("There is not enough information in file  " + file);
            } else {
                int numberOfLecurer = scanner.nextInt();
                for (int i = 0; i < numberOfLecurer; ++i) {
                    lecturerList.add(Lecturer.construct(studentsList, projectsList, scanner));
                }
            }
        }
    }

    private void computeStudentsSortedByLecturersPreferrance() {
        for (int i = 0; i < lecturerList.size(); ++i) {
            for (int j = 0; j <projectsList.size(); ++j) {
                studentsSortedByLecturersPreferance[i][j] = new ArrayList();
            }
        }

        for (int i = 0; i < lecturerList.size(); ++i) {
            for (int j = 0; j <studentsList.size(); ++j) {
                for (Project project : lecturerList.get(i).getMyProjects()) {
                    if (studentsList.get(j).getPreferanceList().contains(project)) {
                        studentsSortedByLecturersPreferance[i][j].add(studentsList.get(j));
                    }
                }
            }
        }
    }

    public void readProblemInstance(String projectsFile, String studentsFile, String lecturerFile) {
        readProjectsList(projectsFile);
        readStudentList(TypeOfPerson.student, studentsFile, studentsList);
        readLecturerList(TypeOfPerson.lecturer, lecturerFile, lecturerList);

        studentsSortedByLecturersPreferance = new ArrayList<>[lecturerList.size()][projectsList.size()];
        computeStudentsSortedByLecturersPreferrance();
    }

    private Student getThatNeedsAProject() {
        for (Student student : studentsList) {
            if (student.isFree() && !student.isProjectListEmpty()) {
                return student;
            }
        }
        return null;
    }

    private void delete(ArrayList<Student> studentsList, Project project, Lecturer lecturer) {
        if (studentsList.get(0).getPreferanceList().contains(project) && lecturer.getMyProjects().contains(project)) {
            studentsList.get(0).removePreferance(project);
            studentsList.remove(0);
        }
    }

    public void findStableMatching() {
        for (Student newStudent = getThatNeedsAProject(); newStudent !=null; newStudent = getThatNeedsAProject()) {
            Project firstProject = newStudent.getFirstProjectFromPreferanceList();
            Lecturer lecturer = firstProject.getLecturer();
            newStudent.assignProject(firstProject);

            if (firstProject.isOverSubscribed()) {
                Student worstStudent = studentsSortedByLecturersPreferance
                        [lecturerList.indexOf(lecturer)][projectsList.indexOf(firstProject)].get(0);
                worstStudent.breakAssignement(firstProject);
            }
            else if (lecturer.isOverSubscribed()) {
                Student worstStudent = lecturer.getLeastPreferredStudentAssignedToAProject();
                Project projectAssignedToWorstStudent = worstStudent.getAssignedProject();
                worstStudent.breakAssignement(projectAssignedToWorstStudent);
            }

            if (firstProject.isFull()) {
                Student worstStudent = lecturer.getLeastPreferredStudentAssignedToProiect(firstProject);
                while (!studentsSortedByLecturersPreferance[lecturerList.indexOf(lecturer)][projectsList.indexOf(firstProject)]
                        .get(0).equals(worstStudent)) {
                    delete(studentsSortedByLecturersPreferance[lecturerList.indexOf(lecturer)][projectsList.indexOf(firstProject)],
                            firstProject, lecturer);
                }
            }
            if (lecturer.isFull()) {
                Student worstStudent = lecturer.getLeastPreferredStudentAssignedToAProject();
                while (!lecturer.getPreferredStudents().get(0).equals(worstStudent)){
                    for (Project project : projectsList) {
                        delete(studentsSortedByLecturersPreferance[lecturerList.indexOf(lecturer)][projectsList.indexOf(project)],
                                project, lecturer);
                    }
                }

            }
        }
    }

    public void printSolution() {
        for (Student student : studentsList) {
            System.out.println(student.getID() + " " + student.getAssignedProject().getID());
        }
    }
}
