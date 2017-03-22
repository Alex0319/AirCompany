package by.aircompany.service;

import by.aircompany.beans.AbstractAirplane;

import java.util.ArrayList;

/**
 * Created by user1 on 22.03.2017.
 */
public interface SearchService {
    ArrayList<AbstractAirplane> searchAirplanes(float rangeStart, float rangeEnd);
}
