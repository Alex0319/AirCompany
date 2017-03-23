package by.aircompany.comparators;

import by.aircompany.beans.AbstractAirplane;
import by.aircompany.enums.SearchCompareCriteria;

/**
 * Created by user1 on 22.03.2017.
 */
public class AirplaneRangeComparator {
    SearchCompareCriteria searchCriteria;

    public AirplaneRangeComparator(SearchCompareCriteria criteria){
        this.searchCriteria = criteria;
    }

    public boolean checkRange(AbstractAirplane airplane, float rangeStart, float rangeEnd){
        return searchCriteria.checkRange(airplane, rangeStart, rangeEnd);
    }
}
