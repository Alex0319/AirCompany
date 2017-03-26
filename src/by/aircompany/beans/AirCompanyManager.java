package by.aircompany.beans;

import java.util.ArrayList;
import java.util.List;

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

    public void addRange(List<AbstractAirplane> airplanes){
        if(airplanes != null){
            this.airplanes.addAll(airplanes);
        }
    }

    public void removeAirplane(int index){
        airplanes.remove(index);
    }

    public AbstractAirplane getAirplane(int index){
        return airplanes.get(index);
    }

    public ArrayList<AbstractAirplane> getAirplanes(){
        return airplanes;
    }

    public void setAirplane(int index, AbstractAirplane airplane){
        airplanes.set(index, airplane);
    }

    public int getAirplanesCount(){
        return airplanes.size();
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        int airplaneNumber = 0;
        for (AbstractAirplane airplane: airplanes) {
            stringBuilder.append(++airplaneNumber + ". ");
            stringBuilder.append(airplane.toString());
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }
}
