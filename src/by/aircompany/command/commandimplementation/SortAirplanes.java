package by.aircompany.command.commandimplementation;

import by.aircompany.beans.AirCompanyManager;
import by.aircompany.command.Command;
import by.aircompany.enums.SortCompareCriteria;
import by.aircompany.enums.enumsimplementation.SortCompareCriteriaImpl;
import by.aircompany.service.SortService;
import by.aircompany.service.serviceimplementation.SortServiceImpl;

/**
 * Created by user1 on 22.03.2017.
 */
public class SortAirplanes implements Command {
    @Override
    public String execute(String request){
        String[] requestParams = request.split("&");
        SortCompareCriteria sortCriteria = SortCompareCriteriaImpl.values()[Integer.parseInt(requestParams[1]) - 1];
        SortService sortService = new SortServiceImpl(sortCriteria);
        sortService.sort();
        return AirCompanyManager.getInstance().toString();
    }
}
