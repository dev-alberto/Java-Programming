import java.util.Date;

public abstract class Persons {
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String telephoneNumber;
    protected Date dateOfBirth;

    public Persons() {
    }

    public Persons(String firstName, String lastName, String email, String telephoneNumber, Date dateOfBirth){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
        this.dateOfBirth = dateOfBirth;
    }

    protected abstract void isFree();
}
