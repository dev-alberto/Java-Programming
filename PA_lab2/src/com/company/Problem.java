package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Problem {
    private ArrayList<Project> projectsList;
    private ArrayList<Student> studentsList;
    private ArrayList<Lecturer> lecturerList;

    public Problem(){
        projectsList = new ArrayList<>();
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
    private void readPersonList(TypeOfPerson typeOfPerson, String file, ArrayList<Persons> personsList) {
        Scanner scanner = getScanner(file);
        if (scanner != null) {
            if (scanner.hasNext()) {
                System.err.println("There is not enough information in file  " + file);
            } else {
                int numberOfPersons = scanner.nextInt();
                for (int i = 0; i < numberOfPersons; ++i) {
                    personsList.add(PersonFactory.getObject(typeOfPerson, scanner));
                }
            }
        }
    }

    public void readProblemInstance(String projectsFile, String studentsFile, String lecturerFile) {
        readProjectsList(projectsFile);
        //readPersonList(TypeOfPerson.student, studentsFile, (ArrayList<Persons>)studentsList);
        //readPersonList(TypeOfPerson.lecturer, lecturerFile, (ArrayList<Persons>)lecturerList);
    }

}