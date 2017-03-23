package by.aircompany.enums;

import by.aircompany.beans.AbstractAirplane;

/**
 * Created by user1 on 22.03.2017.
 */
public interface SearchCompareCriteria {
    boolean checkRange(AbstractAirplane airplane, float rangeStart, float rangeEnd);
}
