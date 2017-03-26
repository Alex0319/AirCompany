package by.aircompany.command.commandimplementation;

import by.aircompany.beans.AbstractAirplane;
import by.aircompany.command.Command;
import by.aircompany.enums.SearchCompareCriteria;
import by.aircompany.enums.enumsimplementation.SearchCompareCriteriaImpl;
import by.aircompany.service.SearchService;
import by.aircompany.service.serviceimplementation.SearchServiceImpl;

import java.util.ArrayList;

/**
 * Created by user1 on 22.03.2017.
 */
public class SearchAirplanes implements Command {

    @Override
    public String execute(String request){
        String[] requestParams = request.split("&");
        SearchCompareCriteria searchCriteria = SearchCompareCriteriaImpl.values()[Integer.parseInt(requestParams[1]) - 1];
        float rangeStart = Float.parseFloat(requestParams[2]);
        float rangeEnd = Float.parseFloat(requestParams[3]);
        if(rangeStart > rangeEnd){
            return "Значение начала диапазона должно быть меньше значения конца диапазона";
        }
        SearchService searchService = new SearchServiceImpl(searchCriteria);
        ArrayList<AbstractAirplane> foundAirplanes = searchService.searchAirplanes(rangeStart,rangeEnd);
        StringBuilder stringBuilder = new StringBuilder();
        for (AbstractAirplane airplane : foundAirplanes){
            stringBuilder.append('\n');
            stringBuilder.append(airplane.toString());
        }
        if(stringBuilder.length() == 0){
            return "Самолеты в заданном диапазоне не найдены";
        }else{
            return stringBuilder.insert(0,"Найденные самолеты:").toString();
        }
    }
}
