package by.aircompany.beans;

/**
 * Created by user1 on 21.03.2017.
 */
public class PassengersAirplane extends AbstractAirplane {
    private int passengersCount;

    public PassengersAirplane() {
        super();
    }

    public PassengersAirplane(String name, String producer, int length, int wingspan, int height, int range,
                              int speed, int carrying, int flightAltitude, int capacity, int fuelConsumption,
                              int passengersCount) {
        super(name, producer, length, wingspan, height, range, speed, carrying, flightAltitude, capacity, fuelConsumption);
        this.passengersCount = passengersCount;
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
        return "Тип: Пассажирский самолет, " + super.toString() + ", количество пассажиров = " + passengersCount;
    }

    @Override
    public String toXmlString() {
        return "type=PASSENGERS, " + super.toXmlString() + ", passengersCount=" + passengersCount;
    }
}
