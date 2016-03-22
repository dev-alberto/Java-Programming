package Model.Exception;

/**
 * Created by alber_000 on 3/21/2016.
 */
public class MyException extends Exception
{
    public MyException(){}
    public MyException(String message){super(message);}
    public MyException(String message,Throwable cause){super(message,cause);}
}
