package by.aircompany.airplanesfactory;

import by.aircompany.beans.AbstractAirplane;

import java.util.ArrayList;

/**
 * Created by user1 on 22.03.2017.
 */
public interface AirplanesFactory {
    AbstractAirplane createAirplane(String[] airplanesParams);
}
