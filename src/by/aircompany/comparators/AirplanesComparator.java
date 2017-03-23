package by.aircompany.comparators;

import by.aircompany.beans.AbstractAirplane;
import by.aircompany.enums.SortCompareCriteria;

import java.util.Comparator;

/**
 * Created by user1 on 22.03.2017.
 */
public class AirplanesComparator implements Comparator<AbstractAirplane>{
    private SortCompareCriteria sortCriteria;

    public AirplanesComparator(SortCompareCriteria criteria){
        this.sortCriteria = criteria;
    }

    @Override
    public int compare(AbstractAirplane airplane1, AbstractAirplane airplane2) {
        return sortCriteria.compare(airplane1,airplane2);
    }
}
