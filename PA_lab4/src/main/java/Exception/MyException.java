<<<<<<< 65e416ee5d382d004dea1ceae70ab86e4b0af3b6
package Exception;


import java.io.IOException;

/**
 * Personal exception class, used to treat different types of exception that arise in the app.
 */
public class MyException extends Exception{
    public MyException(){}
    public MyException(String message){super(message);}
    public MyException(String message,Throwable cause){super(message,cause);}
}
=======
package Exception;


import java.io.IOException;

/**
 * Personal exception class, used to treat different types of exception that arise in the app.
 */
public class MyException extends Exception{
    public MyException(){}
    public MyException(String message){super(message);}
    public MyException(String message,Throwable cause){super(message,cause);}
}
>>>>>>> Refactoring
