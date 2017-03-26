package by.aircompany.airplanesfactory.factoriesimplementations;

import by.aircompany.airplanesfactory.AirplanesFactory;
import java.util.*;

/**
 * Created by user1 on 22.03.2017.
 */
public class FactoryMapper {
    private static Map<String,AirplanesFactory> factories;

    static {
        factories = new LinkedHashMap<>();
        factories.put("PASSENGERS_AIRPLANE_FACTORY",new PassengersAirplanesFactory());
        factories.put("CARGO_AIRPLANE_FACTORY",new CargoAirplanesFactories());
    }

    public static AirplanesFactory getFactory(int index){
        return new ArrayList<>(factories.values()).get(index);
    }

    public static AirplanesFactory getFactory(String name){
        return factories.get(name);
    }
}
