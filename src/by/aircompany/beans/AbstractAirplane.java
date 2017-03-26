package by.aircompany.beans;

import java.io.Serializable;

/**
 * Created by user1 on 21.03.2017.
 */
public abstract class AbstractAirplane implements Serializable{
    protected String name,producer;


    protected int length;
    protected int wingspan;
    protected int height;
    protected int range;
    protected int speed;
    protected int carrying;
    protected int flightAltitude;
    protected int capacity;
    protected int fuelConsumption;

    public AbstractAirplane(){
        super();
    }

    public AbstractAirplane(String name, String producer, int length, int wingspan, int height, int range, int speed, int carrying, int flightAltitude, int capacity, int fuelConsumption) {
        this.name = name;
        this.producer = producer;
        this.length = length;
        this.wingspan = wingspan;
        this.height = height;
        this.range = range;
        this.speed = speed;
        this.carrying = carrying;
        this.flightAltitude = flightAltitude;
        this.capacity = capacity;
        this.fuelConsumption = fuelConsumption;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWingspan() {
        return wingspan;
    }

    public void setWingspan(int wingspan) {
        this.wingspan = wingspan;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getCarrying() {
        return carrying;
    }

    public void setCarrying(int carrying) {
        this.carrying = carrying;
    }

    public int getFlightAltitude() {
        return flightAltitude;
    }

    public void setFlightAltitude(int flightAltitude) {
        this.flightAltitude = flightAltitude;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    private boolean compareStrings(String thisClassString,String otherClassString){
        if(thisClassString == null) {
            if (otherClassString != null) {
                return false;
            }
            return true;
        }
        return thisClassString.equals(otherClassString);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()){
            return false;
        }

        AbstractAirplane that = (AbstractAirplane) o;

        if (Float.compare(that.length, length) != 0) { return false; }
        if (Float.compare(that.wingspan, wingspan) != 0) { return false; }
        if (Float.compare(that.height, height) != 0) { return false; }
        if (Float.compare(that.range, range) != 0) { return false; }
        if (Float.compare(that.speed, speed) != 0) { return false; }
        if (Float.compare(that.carrying, carrying) != 0) { return false; }
        if (Float.compare(that.flightAltitude, flightAltitude) != 0) { return false; }
        if (Float.compare(that.capacity, capacity) != 0) { return false; }
        if (Float.compare(that.fuelConsumption, fuelConsumption) != 0) { return false; }
        return compareStrings(name,that.name) && compareStrings(producer,that.producer);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = name.hashCode();
        result = prime * result + producer.hashCode();
        result = prime * result + (length != 0 ? Float.floatToIntBits(length) : 0);
        result = prime * result + (wingspan != 0 ? Float.floatToIntBits(wingspan) : 0);
        result = prime * result + (height != 0 ? Float.floatToIntBits(height) : 0);
        result = prime * result + (range != 0 ? Float.floatToIntBits(range) : 0);
        result = prime * result + (speed != 0 ? Float.floatToIntBits(speed) : 0);
        result = prime * result + (carrying != 0 ? Float.floatToIntBits(carrying) : 0);
        result = prime * result + (flightAltitude != 0 ? Float.floatToIntBits(flightAltitude) : 0);
        result = prime * result + (capacity != 0 ? Float.floatToIntBits(capacity) : 0);
        result = prime * result + (fuelConsumption != 0 ? Float.floatToIntBits(fuelConsumption) : 0);
        return result;
    }

    private String checkStringValue(String str){
        if(str != null){
            return str;
        }else{
            return "no";
        }
    }

    @Override
    public String toString() {
        return "Название = " + checkStringValue(name) + ", производитель = " + checkStringValue(producer) + ", длина = " +
                length + ", размах крыльев = " + wingspan + ", высота = " + height + ", дальность полета = " + range +
                ", скорость = " + speed + ", грузоподъемность = " + carrying + ", высота полета = " + flightAltitude +
                ", вместимость = " + capacity + ", потребление горючего = " + fuelConsumption;
    }

    public String toXmlString(){
        return  "name=" + name + ", producer=" + producer + ", length=" + length + ", wingspan=" + wingspan +
                ", height=" + height + ", range=" + range + ", speed=" + speed + ", carrying=" + carrying +
                ", flightAltitude=" + flightAltitude + ", capacity=" + capacity + ", fuelConsumption=" + fuelConsumption;
    }
}
