package by.aircompany.command.exception;

/**
 * Created by user1 on 22.03.2017.
 */
public class CommandException extends Exception {
    public CommandException(){}

    public CommandException(Exception e){
        super(e);
    }

    public CommandException(String message){
        super(message);
    }

    public CommandException(String message, Exception e){
        super(message,e);
    }
}
