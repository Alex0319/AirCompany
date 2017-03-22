package by.aircompany.service.serviceimplementation;

import by.aircompany.beans.AbstractAirplane;
import by.aircompany.beans.AirCompanyManager;
import by.aircompany.enums.CompareCriteria;
import by.aircompany.service.AirplanesComparator;

/**
 * Created by user1 on 22.03.2017.
 */
public class SortService {
    private AirplanesComparator airplanesComparator;

    public SortService(CompareCriteria criteria){
        airplanesComparator = new AirplanesComparator(criteria);
    }

    private void doSort(AirCompanyManager airCompanyManager,int minArrayIndex,int maxArrayIndex){
        if (minArrayIndex > maxArrayIndex){
            return;
        }
        AbstractAirplane temp;
        AbstractAirplane x = airCompanyManager.getAirplane(minArrayIndex + (maxArrayIndex - minArrayIndex) / 2);
        int i = minArrayIndex;
        int j = maxArrayIndex;
        while (i <= j) {
            while (airplanesComparator.compare(airCompanyManager.getAirplane(i), x) < 0){
                i++;
            }
            while (airplanesComparator.compare(airCompanyManager.getAirplane(j), x) > 0) {
                j--;
            }
            if (i <= j) {
                temp = airCompanyManager.getAirplane(i);
                airCompanyManager.setAirplane(i,airCompanyManager.getAirplane(j));
                airCompanyManager.setAirplane(j,temp);
                i++;
                j--;
            }
        }
        if (i < maxArrayIndex) {
            doSort(airCompanyManager, i, maxArrayIndex);
        }
        if (minArrayIndex < j){
            doSort(airCompanyManager, minArrayIndex, j);
        }
    }

    public void sort(AirCompanyManager airCompanyManager){
        doSort(airCompanyManager,0,airCompanyManager.getAirplanesCount() - 1);
    }
}
