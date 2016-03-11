<<<<<<< HEAD
package com.company;

import java.util.Scanner;

public abstract class Person {
    protected int ID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public abstract void read(Scanner scanner, Problem problem);

    public abstract boolean isFree();
}
=======
package com.company;

import java.util.Scanner;


public abstract class Person {
    protected int ID;
    /**
     * Getter, returns person id
     * @return id
     */

    public int getID() {
        return ID;
    }

    /**
     * Setter for the ID attribute
     * @param ID attribute
     */

    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * Method used to help read from file
     * @param scanner Scanner object
     * @param problem Problem instance
     */

    public abstract void read(Scanner scanner, Problem problem);

    public abstract boolean isFree();
}
>>>>>>> dev-alberto-tema4
