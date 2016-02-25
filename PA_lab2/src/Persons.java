
public abstract class Persons {
    private String email;
    private String name;

    public Persons(){}
    public String getEmail(){return email;}
    public String getName(){return name;}
    public void setEmail(String newEmail){email=newEmail;}
    public void setName(String newName){name=newName;}
    protected abstract void isFree();
}
