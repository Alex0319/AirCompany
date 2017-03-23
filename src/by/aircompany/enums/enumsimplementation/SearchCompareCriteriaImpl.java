package by.aircompany.enums.enumsimplementation;

import by.aircompany.beans.AbstractAirplane;
import by.aircompany.enums.SearchCompareCriteria;

/**
 * Created by user1 on 22.03.2017.
 */
public enum SearchCompareCriteriaImpl implements SearchCompareCriteria {

    FUEL_CONSUMPTION{
        public boolean checkRange(AbstractAirplane airplane, float rangeStart, float rangeEnd) {
            return ((Float.compare(airplane.getFuelConsumption(),rangeStart) >= 0)
                    && (Float.compare(airplane.getFuelConsumption(),rangeEnd) <= 0));
        }
    },
    CARRYING{
        public boolean checkRange(AbstractAirplane airplane, float rangeStart, float rangeEnd) {
            return ((Float.compare(airplane.getCarrying(),rangeStart) >= 0)
                    && (Float.compare(airplane.getCarrying(),rangeEnd) <= 0));
        }
    }

}
