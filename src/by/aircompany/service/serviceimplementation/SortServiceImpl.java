package by.aircompany.service.serviceimplementation;

import by.aircompany.beans.AbstractAirplane;
import by.aircompany.beans.AirCompanyManager;
import by.aircompany.enums.SortCompareCriteria;
import by.aircompany.comparators.AirplanesComparator;
import by.aircompany.service.SortService;

/**
 * Created by user1 on 22.03.2017.
 */
public class SortServiceImpl implements SortService{
    private AirplanesComparator airplanesComparator;
    private AirCompanyManager airCompanyManager = AirCompanyManager.getInstance();

    public SortServiceImpl(SortCompareCriteria criteria){
        airplanesComparator = new AirplanesComparator(criteria);
    }

    public void setAirplanesComparator(AirplanesComparator airplanesComparator) {
        this.airplanesComparator = airplanesComparator;
    }

    private void doSort(int minArrayIndex,int maxArrayIndex){
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
            doSort(i, maxArrayIndex);
        }
        if (minArrayIndex < j){
            doSort(minArrayIndex, j);
        }
    }

    public void sort(){
        doSort(0,airCompanyManager.getAirplanesCount() - 1);
    }
}
