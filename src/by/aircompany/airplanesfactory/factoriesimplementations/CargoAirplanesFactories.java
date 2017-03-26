package by.aircompany.airplanesfactory.factoriesimplementations;

import by.aircompany.airplanesfactory.AirplanesFactory;
import by.aircompany.beans.AbstractAirplane;
import by.aircompany.beans.CargoAirplane;

/**
 * Created by user1 on 22.03.2017.
 */
public class CargoAirplanesFactories implements AirplanesFactory {
    @Override
    public AbstractAirplane createAirplane(String[] airplanesParams) {
        return new CargoAirplane(airplanesParams[0], airplanesParams[1],Integer.parseInt(airplanesParams[2]),
                Integer.parseInt(airplanesParams[3]), Integer.parseInt(airplanesParams[4]),
                Integer.parseInt(airplanesParams[5]), Integer.parseInt(airplanesParams[6]),
                Integer.parseInt(airplanesParams[7]), Integer.parseInt(airplanesParams[8]),
                Integer.parseInt(airplanesParams[9]), Integer.parseInt(airplanesParams[10]),
                Integer.parseInt(airplanesParams[11]), Integer.parseInt(airplanesParams[12]));
    }
}
