package by.aircompany.service.exception;

/**
 * Created by user1 on 22.03.2017.
 */
public class ServiceException extends Exception {
    public ServiceException(){}

    public ServiceException(Exception e){
        super(e);
    }

    public ServiceException(String message){
        super(message);
    }

    public ServiceException(String message, Exception e){
        super(message,e);
    }
}
