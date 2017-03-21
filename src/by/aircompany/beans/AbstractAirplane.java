package by.aircompany.beans;

/**
 * Created by user1 on 21.03.2017.
 */
public abstract class AbstractAirplane {
    protected String name,producer;
    protected float length;
    protected float wingspan;
    protected float height;
    protected float range;
    protected float speed;
    protected float carrying;
    protected float flightAltitude;
    protected float capacity;
    protected float fuelConsumption;

    public AbstractAirplane(){
        super();
    }

    public AbstractAirplane(String name,String producer,float length,float wingspan,float height,
                            float range,float speed,float carrying,float flightAltitude,
                            float capacity,float fuelConsumption){
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

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWingspan() {
        return wingspan;
    }

    public void setWingspan(float wingspan) {
        this.wingspan = wingspan;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getRange() {
        return range;
    }

    public void setRange(float range) {
        this.range = range;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getCarrying() {
        return carrying;
    }

    public void setCarrying(float carrying) {
        this.carrying = carrying;
    }

    public float getFlightAltitude() {
        return flightAltitude;
    }

    public void setFlightAltitude(float flightAltitude) {
        this.flightAltitude = flightAltitude;
    }

    public float getCapacity() {
        return capacity;
    }

    public void setCapacity(float capacity) {
        this.capacity = capacity;
    }

    public float getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(float fuelConsumption) {
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
        if(name != null){
            return name;
        }else{
            return "no";
        }
    }

    @Override
    public String toString() {
        return "Name = " + checkStringValue(name) + ", producer = " + checkStringValue(producer) + ", length = " +
                length + ", wingspan = " + wingspan + ", height = " + height + ", range = " + range + ", speed = " +
                speed + ", carrying = " + carrying + ", flightAltitude = " + flightAltitude + ", capacity = " + capacity +
                ", fuelConsumption = " + fuelConsumption;
    }
}
