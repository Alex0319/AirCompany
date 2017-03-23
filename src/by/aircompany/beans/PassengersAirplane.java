package by.aircompany.beans;

import java.util.Arrays;

/**
 * Created by user1 on 21.03.2017.
 */
public class PassengersAirplane extends AbstractAirplane {
    private int passengersCount;

    public PassengersAirplane() {
        super();
    }

    public PassengersAirplane(String[] airplanesParams) {
        super(airplanesParams);
        this.passengersCount = Integer.parseInt(airplanesParams[airplanesParams.length-1]);
    }

    public int getPassengersCount() {
        return passengersCount;
    }

    public void setPassengersCount(int passengersCount) {
        this.passengersCount = passengersCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) { return false; }
        if (!super.equals(o)) { return false; }

        PassengersAirplane that = (PassengersAirplane) o;

        return passengersCount == that.passengersCount;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + passengersCount;
        return result;
    }

    @Override
    public String toString() {
        return "Тип: Пассажирский самолет, " + super.toString() +
                ", количество пассажиров = " + passengersCount;
    }
}
