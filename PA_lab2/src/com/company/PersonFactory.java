package com.company;
import java.util.Scanner;

public class PersonFactory {
    public static Persons getObject(TypeOfPerson typeOfPerson, Scanner scanner) {
        switch (typeOfPerson) {
            case student: return Student.construct(scanner);
            case lecturer: return Lecturer.construct(scanner);
        }
        return null;
    }
}