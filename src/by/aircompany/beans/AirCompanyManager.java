package by.aircompany.beans;

import java.util.ArrayList;

/**
 * Created by user1 on 22.03.2017.
 */
public class AirCompanyManager {
    private static AirCompanyManager instance;
    private ArrayList<AbstractAirplane> airplanes = new ArrayList<>();

    private AirCompanyManager(){}

    public static AirCompanyManager getInstance(){
        if(instance == null){
            instance = new AirCompanyManager();
        }
        return instance;
    }

    public void addAirplane(AbstractAirplane airplane){
        airplanes.add(airplane);
    }

    public void removeAirplane(int index){
        airplanes.remove(index);
    }

    public AbstractAirplane getAirplane(int index){
        return airplanes.get(index);
    }

    public void setAirplane(int index, AbstractAirplane airplane){
        airplanes.set(index, airplane);
    }

    public int getAirplanesCount(){
        return airplanes.size();
    }
}
