/**
 * An concrete class named Violin that extends from the Stringed
 * and implements all the abstract methods of Stringed
 * @author Alizain Charania
 * @version 1.0 Oct. 12 2015
 */
public class Violin extends Stringed {

    /**
     * This is a constructor for the Violin class
     * @param price         The cost price of each instrument
     * @param property      The unique property of percussion instruments
     */
    public Violin(double price, String property) {
        super(price, property);
    }

    /**
     * A contrete method implemented, which was abstract in superclass
     * @return a String that makes the sound of this specific instrument
     */
    public String play() {
        return "tin tun ting tung tungggg....";
    }

    /**
     * Overriding the toString() method to output a custom string
     * @return a String of meaningful statements
     */
    @Override
    public String toString() {
        String str = "Violin is a " + getProperty()
            + " instrument. Its price is $" + getPrice()
            + " and the unique serial number is " + getSerialNum()
            + ". The sound of this instrument is " + play();

        return str;
    }
}