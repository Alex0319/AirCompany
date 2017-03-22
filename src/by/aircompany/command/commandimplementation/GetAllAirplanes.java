package by.aircompany.command.commandimplementation;

import by.aircompany.beans.AirCompanyManager;
import by.aircompany.command.Command;

/**
 * Created by user1 on 22.03.2017.
 */
public class GetAllAirplanes implements Command {
    @Override
    public String execute(String request) {
        return AirCompanyManager.getInstance().toString();
    }
}
