package by.aircompany.dao.exception;

/**
 * Created by user1 on 23.03.2017.
 */
public class DaoException extends Exception {
    public DaoException(){}

    public DaoException(Exception e){
        super(e);
    }

    public DaoException(String message){
        super(message);
    }

    public DaoException(String message, Exception e){
        super(message,e);
    }
}
