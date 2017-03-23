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
        commandMap.put("ADD_AIRPLANE", new AddAirplane());
        commandMap.put("REMOVE_AIRPLANE", new RemoveAirplane());
        commandMap.put("SEARCH_AIRPLANES", new SearchAirplanes());
        commandMap.put("SORT_AIRPLANES", new SortAirplanes());
        commandMap.put("GET_ALL_AIRPLANES", new GetAllAirplanes());
        commandMap.put("CALCULATE_TOTAL_CAPACITY", new CalculateTotalCapacity());
        commandMap.put("CALCULATE_TOTAL_CARRYING_CAPACITY", new CalculateTotalCarryingCapacity());
        commandMap.put("LOAD_AIRPLANES", new LoadAirplanes());
        commandMap.put("SAVE_AIRPLANES", new SaveAirplanes());
    }

    public static Command getCommand(String commandName){
        return commandMap.get(commandName);
    }
}
