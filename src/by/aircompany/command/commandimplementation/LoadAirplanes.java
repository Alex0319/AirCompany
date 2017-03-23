package by.aircompany.command.commandimplementation;

import by.aircompany.command.Command;
import by.aircompany.command.exception.CommandException;
import by.aircompany.service.SaveLoadAirplanesService;
import by.aircompany.service.exception.ServiceException;
import by.aircompany.service.serviceimplementation.SaveLoadAirplanesServiceImpl;

/**
 * Created by user1 on 23.03.2017.
 */
public class LoadAirplanes implements Command {
    @Override
    public String execute(String request) throws CommandException {
        String response = null;
        try {
            SaveLoadAirplanesService saveLoadAirplanesService = new SaveLoadAirplanesServiceImpl();
            if (saveLoadAirplanesService.loadAirplanes()){
                response = "Инициализация выполнена успешно";
            }
        }catch (ServiceException e){
            throw new CommandException(e.getMessage(),e);
        }
        return response;
    }
}
