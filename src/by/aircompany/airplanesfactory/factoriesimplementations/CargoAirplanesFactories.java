package by.aircompany.airplanesfactory.factoriesimplementations;

import by.aircompany.airplanesfactory.AirplanesFactory;
import by.aircompany.beans.AbstractAirplane;
import by.aircompany.beans.CargoAirplane;

import java.util.ArrayList;

/**
 * Created by user1 on 22.03.2017.
 */
public class CargoAirplanesFactories implements AirplanesFactory {
    @Override
    public AbstractAirplane createAirplane(String[] airplanesParams) {
        return new CargoAirplane(airplanesParams);
    }
}
