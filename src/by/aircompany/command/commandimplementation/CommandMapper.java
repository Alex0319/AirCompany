package by.aircompany.command.commandimplementation;

import by.aircompany.command.Command;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user1 on 22.03.2017.
 */
public class CommandMapper {
    private static Map<String,Command> commandMap;

    static {
        commandMap = new HashMap<>();
        commandMap.put("ADD_AIRPLANE", new AddAirplaneCommand());
    }

    public static Command getCommand(String commandName){
        return commandMap.get(commandName);
    }
}
