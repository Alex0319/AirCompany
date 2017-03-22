package by.aircompany.service;

import by.aircompany.beans.AbstractAirplane;

import java.util.ArrayList;

/**
 * Created by user1 on 23.03.2017.
 */
public interface SaveLoadAirplanesService {
    boolean saveAirplanes(ArrayList<AbstractAirplane> airplanes);
    ArrayList<AbstractAirplane> loadAirplanes();
}
