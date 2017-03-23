package by.aircompany.command.commandimplementation;

import by.aircompany.airplanesfactory.AirplanesFactory;
import by.aircompany.airplanesfactory.factoriesimplementations.FactoryMapper;
import by.aircompany.beans.AirCompanyManager;
import by.aircompany.command.Command;
import by.aircompany.command.exception.CommandException;

import java.util.Arrays;

/**
 * Created by user1 on 22.03.2017.
 */
public class RemoveAirplane implements Command {
    @Override
    public String execute(String request){
        String[] requestParams = request.split("&");
        AirCompanyManager.getInstance().removeAirplane(Integer.parseInt(requestParams[1]) - 1);
        return null;
    }
}
