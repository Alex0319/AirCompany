package by.aircompany.service.serviceimplementation;

import by.aircompany.beans.AbstractAirplane;
import by.aircompany.beans.AirCompanyManager;
import by.aircompany.enums.SearchCompareCriteria;
import by.aircompany.comparators.AirplaneRangeComparator;
import by.aircompany.service.SearchService;

import java.util.ArrayList;

/**
 * Created by user1 on 22.03.2017.
 */
public class SearchServiceImpl implements SearchService {
    private AirplaneRangeComparator airplanesRangeComparator;
    private AirCompanyManager airCompanyManager = AirCompanyManager.getInstance();

    public SearchServiceImpl(SearchCompareCriteria criteria){
        airplanesRangeComparator = new AirplaneRangeComparator(criteria);
    }

    public void setAirplanesRangeComparator(AirplaneRangeComparator airplanesRangeComparator) {
        this.airplanesRangeComparator = airplanesRangeComparator;
    }

    public ArrayList<AbstractAirplane> searchAirplanes(float rangeStart, float rangeEnd){
        ArrayList<AbstractAirplane> result = new ArrayList<>();
        for (int i = 0; i < airCompanyManager.getAirplanesCount(); i++){
            AbstractAirplane currentAirplane = airCompanyManager.getAirplane(i);
            if(airplanesRangeComparator.checkRange(currentAirplane,rangeStart,rangeEnd)){
                result.add(currentAirplane);
            }
        }
        return result;
    }
}
