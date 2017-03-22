package by.aircompany.service.serviceimplementation;

import by.aircompany.beans.AirCompanyManager;
import by.aircompany.service.AirplaneService;

import java.math.BigDecimal;

/**
 * Created by user1 on 22.03.2017.
 */
public class AirplaneServiceImpl implements AirplaneService{

    @Override
    public BigDecimal calculateTotalCapacity(AirCompanyManager airCompanyManager) {
        BigDecimal result = new BigDecimal(0);
        for (int i = 0; i < airCompanyManager.getAirplanesCount(); i++){
            result = result.add(BigDecimal.valueOf(airCompanyManager.getAirplane(i).getCapacity()));
        }
        return result;
    }

    @Override
    public BigDecimal calculateTotalCarryingCapacity(AirCompanyManager airCompanyManager) {
        BigDecimal result = new BigDecimal(0);
        for (int i = 0; i < airCompanyManager.getAirplanesCount(); i++){
            result = result.add(BigDecimal.valueOf(airCompanyManager.getAirplane(i).getCarrying()));
        }
        return result;
    }
}
