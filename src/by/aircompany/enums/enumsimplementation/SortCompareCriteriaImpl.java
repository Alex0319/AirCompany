package by.aircompany.enums.enumsimplementation;

import by.aircompany.beans.AbstractAirplane;
import by.aircompany.enums.SortCompareCriteria;

/**
 * Created by user1 on 22.03.2017.
 */
public enum SortCompareCriteriaImpl implements SortCompareCriteria{

    FLIGHT_ALTITUDE{
        public int compare(AbstractAirplane airplane1, AbstractAirplane airplane2) {
            return Float.compare(airplane1.getFlightAltitude(),airplane2.getFlightAltitude());
        }
    },
    RANGE{
        public int compare(AbstractAirplane airplane1, AbstractAirplane airplane2) {
            return Float.compare(airplane1.getRange(),airplane2.getRange());
        }
    }
}
