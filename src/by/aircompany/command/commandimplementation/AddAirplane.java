package by.aircompany.command.commandimplementation;

import by.aircompany.airplanesfactory.AirplanesFactory;
import by.aircompany.airplanesfactory.factoriesimplementations.FactoryMapper;
import by.aircompany.beans.AbstractAirplane;
import by.aircompany.beans.AirCompanyManager;
import by.aircompany.command.Command;
import by.aircompany.command.exception.CommandException;

import java.util.Arrays;

/**
 * Created by user1 on 22.03.2017.
 */
public class AddAirplane implements Command {

    @Override
    public String execute(String request) throws CommandException {
        String[] requestParams = request.split("&");
        AirplanesFactory factory = FactoryMapper.getFactory(Integer.parseInt(requestParams[1]) - 1);
        AbstractAirplane airplane = factory.createAirplane(Arrays.copyOfRange(requestParams,2,requestParams.length));
        AirCompanyManager.getInstance().addAirplane(airplane);
        return null;
    }
}
