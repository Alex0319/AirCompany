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
        AirCompanyManager airCompanyManager = AirCompanyManager.getInstance();
        String[] requestParams = request.split("&");
        int airplaneNumber = Integer.parseInt(requestParams[1]) - 1;
        if(airplaneNumber < airCompanyManager.getAirplanesCount()){
            airCompanyManager.removeAirplane(airplaneNumber);
        }else{
            return "Самолет с номером " + (airplaneNumber + 1) + " не найден" ;
        }
        return "Самолет успешно удален";
    }
}
