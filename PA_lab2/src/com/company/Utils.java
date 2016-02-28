package com.company;

import java.util.AbstractList;

public class Utils {
    public static Project findProject(AbstractList<Project> projectsList, int ID) {
        for (int i = 0; i < projectsList.size(); ++i) {
            if (projectsList.get(i).getID() == ID) {
                return projectsList.get(i);
            }
        }
        return null;
    }

    public static Student findStudents(AbstractList<Student> studentsList, int ID) {
        for (int i = 0; i < studentsList.size(); ++i) {
            if (studentsList.get(i).getID() == ID) {
                return studentsList.get(i);
            }
        }
        return null;
    }
}
