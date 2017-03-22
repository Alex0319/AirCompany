package by.aircompany.command.commandimplementation;

import by.aircompany.command.Command;
import by.aircompany.command.exception.CommandException;
import by.aircompany.service.AirplaneService;
import by.aircompany.service.serviceimplementation.AirplaneServiceImpl;

/**
 * Created by user1 on 23.03.2017.
 */
public class CalculateTotalCapacity implements Command {
    @Override
    public String execute(String request) throws CommandException {
        AirplaneService airplaneService = new AirplaneServiceImpl();
        return "Общая вместимость: " + airplaneService.calculateTotalCapacity();
    }
}
