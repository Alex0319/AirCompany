package by.aircompany.airplanesfactory.factoriesimplementations;

import by.aircompany.airplanesfactory.AirplanesFactory;
import by.aircompany.command.commandimplementation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by user1 on 22.03.2017.
 */
public class FactoryMapper {
    private static ArrayList<AirplanesFactory> factories;

    static {
        factories = new ArrayList<>();
        factories.add(new PassengersAirplanesFactory());
        factories.add(new CargoAirplanesFactories());
    }

    public static AirplanesFactory getFactory(int index){
        return factories.get(index);
    }
}
