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
