import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public class Student extends Persons {
    private LinkedList<Project> projects = new LinkedList<>();
    private long studentID;

    Student(long studentID, String firstName, String lastName, String email, String telephoneNumber, Date dateOfBirth) {
        super(firstName, lastName, email, telephoneNumber, dateOfBirth);
        this.studentID = studentID;
    }

    public void isFree() {

    }
}
