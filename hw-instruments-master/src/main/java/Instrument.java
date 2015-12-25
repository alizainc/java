/**
 * The abstract parent class named Instruments from
 * which my different classes inherit
 * @author Alizain Charania
 * @version 1.0 Oct. 6 2015
 */
public abstract class Instrument {
    private double price;
    private int serialNum;
    private static int num = 2358;

    /**
     * This is a constructor for the Instrument class
     * @param price         The cost price of each instrument
     */
    public Instrument(double price) {
        this.price = price;
        serialNum = num++;
    }

    /**
     * An abstract method to be implemented in the subclasses
     * @return a String that makes the sound of that specific instrument
     */
    public abstract String play();

    /**
     * A getter method for instance variable price
     * @return a double price
     */
    public double getPrice() {
        return price;
    }

    /**
     * A getter method for instance variable serial number
     * @return a int serial number
     */
    public int getSerialNum() {
        return serialNum;
    }

    /**
     * Overriding the equals() method
     * @param other The reference object to compare
     * @return a boolean return of the value-equality
     */
    @Override
    public boolean equals(Object other) {
        if (null == other) {
            return false;
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof Instrument)) {
            return false;
        }
        //Instrument that = (Instrument) other;
        return this.serialNum == (((Instrument) other).serialNum);
    }

    /**
     * Overriding the hashCode() method. Just a dummy to
     * stop checkstyle error
     * @return a int
     */
    @Override
    public int hashCode() {
        int result = serialNum;
        return result;
    }
}