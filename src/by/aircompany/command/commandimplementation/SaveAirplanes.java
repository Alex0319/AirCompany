package by.aircompany.command.commandimplementation;

import by.aircompany.command.Command;
import by.aircompany.command.exception.CommandException;
import by.aircompany.service.exception.ServiceException;

/**
 * Created by user1 on 23.03.2017.
 */
public class SaveAirplanes implements Command {
    @Override
    public String execute(String request) throws CommandException {
        try {

        }catch (ServiceException e){
            throw new CommandException(e.getMessage(),e);
        }
    }
}
