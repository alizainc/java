/**
 * An abstract class named Stringed that extencd from the Instrument
 * @author Alizain Charania
 * @version 1.0 Oct. 12 2015
 */
public abstract class Stringed extends Instrument {

    private String property;

    /**
     * This is a constructor for the Stringed class
     * @param price         The cost price of each instrument
     * @param property      The unique property of stringed instruments
     */
    public Stringed(double price, String property) {
        super(price);
        this.property = property;
    }

    /**
     * An abstract method to be implemented in the subclasses
     * @return a String that makes the sound of that specific instrument
     */
    public abstract String play();

    /**
     * A getter method for the instance variable property
     * @return a String of its property
     */
    public String getProperty() {
        return property;
    }

}