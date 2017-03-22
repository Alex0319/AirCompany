package by.aircompany.service.serviceimplementation;

import by.aircompany.beans.AbstractAirplane;
import by.aircompany.beans.AirCompanyManager;
import by.aircompany.service.SaveLoadAirplanesService;

import java.util.ArrayList;

/**
 * Created by user1 on 23.03.2017.
 */
public class SaveLoadAirplanesServiceImpl implements SaveLoadAirplanesService{
    private AirCompanyManager airCompanyManager = AirCompanyManager.getInstance();

    @Override
    public boolean saveAirplanes(ArrayList<AbstractAirplane> airplanes) {
        
        return false;
    }

    @Override
    public ArrayList<AbstractAirplane> loadAirplanes() {
        return null;
    }
}
