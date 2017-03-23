package by.aircompany.controller;

import by.aircompany.command.commandimplementation.CommandMapper;
import by.aircompany.command.exception.CommandException;

public class Controller {

    public static String doAction(String request) {
        String response = null;
        try {
            String commandName = request.split("&")[0];
            response =  CommandMapper.getCommand(commandName).execute(request);
        }catch (CommandException e){
            e.printStackTrace();
        }
        return response;
    }
}
