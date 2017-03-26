package by.aircompany.beans;

/**
 * Created by user1 on 21.03.2017.
 */
public class CargoAirplane extends AbstractAirplane {
    private int maxLoad, maxVolume;

    public CargoAirplane() {
        super();
    }

    public CargoAirplane(String name, String producer, int length, int wingspan, int height, int range, int speed,
                         int carrying, int flightAltitude, int capacity, int fuelConsumption, int maxLoad, int maxVolume) {
        super(name, producer, length, wingspan, height, range, speed, carrying, flightAltitude, capacity, fuelConsumption);
        this.maxLoad = maxLoad;
        this.maxVolume = maxVolume;
    }

    public int getMaxLoad() {
        return maxLoad;
    }

    public void setMaxLoad(int maxLoad) {
        this.maxLoad = maxLoad;
    }

    public int getMaxVolume() {
        return maxVolume;
    }

    public void setMaxVolume(int maxVolume) {
        this.maxVolume = maxVolume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        if (!super.equals(o)) { return false; }

        CargoAirplane that = (CargoAirplane) o;

        if (maxLoad != that.maxLoad) { return false; }
        return maxVolume == that.maxVolume;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + maxLoad;
        result = 31 * result + maxVolume;
        return result;
    }

    @Override
    public String toString() {
        return "Тип: Грузовой самолет, " + super.toString() +
                ", максимальная загруженность = " + maxLoad + ", максимальный объем = " + maxVolume;
    }

    @Override
    public String toXmlString() {
        return "type=CARGO, " + super.toXmlString() + ", maxLoad=" + maxLoad + ", maxVolume=" + maxVolume;
    }
}
