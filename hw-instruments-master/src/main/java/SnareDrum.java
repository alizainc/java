/**
 * An concrete class named SnareDrum that extends from the Percussion
 * and implements all the abstract methods of Percussion
 * @author Alizain Charania
 * @version 1.0 Oct. 12 2015
 */
public class SnareDrum extends Percussion {

    /**
     * This is a constructor for the SnareDrum class
     * @param price         The cost price of each instrument
     * @param property      The unique property of percussion instruments
     */
    public SnareDrum(double price, String property) {
        super(price, property);
    }

    /**
     * A contrete method implemented, which was abstract in superclass
     * @return a String that makes the sound of this specific instrument
     */
    public String play() {
        return "dang dang dang dang!!!!";
    }

    /**
     * Overriding the toString() method to output a custom string
     * @return a String of meaningful statements
     */
    @Override
    public String toString() {
        String str = "Snare Drum is a " + getProperty()
            + " instrument. Its price is $" + getPrice()
            + " and the unique serial number is " + getSerialNum()
            + ". The sound of this instrument is " + play();

        return str;
    }
}