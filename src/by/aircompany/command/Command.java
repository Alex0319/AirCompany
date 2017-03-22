package by.aircompany.command;

import by.aircompany.command.exception.CommandException;

/**
 * Created by user1 on 22.03.2017.
 */
public interface Command{
    String execute(String request) throws CommandException;
}
