import java.util.ArrayList;

/**
 * A class named Musician that will buy and sell different instruments
 * @author Alizain Charania
 * @version 1.0 Oct. 12 2015
 */
public class Musician {

    private ArrayList<Instrument> instruments =  new ArrayList<>();
    private String name;
    private double funds;

    /**
     * This is a constructor for the Musician class
     * @param aName         Name of the Musician
     * @param aFund         The amount of funds he has available
     * @param anInst  The instrument to be added
     * @throws NoLessThanOneInstrumentException    if less than one
     * instrument is left in the collection
     */
    public Musician(String aName, double aFund, ArrayList<Instrument> anInst)
    throws NoLessThanOneInstrumentException {
        if (anInst.isEmpty()) {
            throw new NoLessThanOneInstrumentException();
        }
        instruments = anInst;
        name = aName;
        funds = aFund;
    }

    /**
     * A getter method for the instance variable name
     * @return a String of its name
     */
    public String getName() {
        return name;
    }

    /**
     * A getter method for the instance variable funds
     * @return a double of its funds
     */
    public double getFunds() {
        return funds;
    }

    /**
     * A getter method for the instance variable instruments
     * @return a ArrayList of Instrument
     */
    public ArrayList<Instrument> getInstruments() {
        return instruments;
    }

    /**
     * This method is used to add new instruments in that the Musician
     * wishes to buy in his collection
     * @param ins       the instrument to add to the collection
     * @throws NotEnoughFundsException   if the funds are less than the
     *         cost price of the instrument being bought
     * @throws NoSameInstrumentException if an instrument of the same
     *         serial number is bought
     */
    public void purchase(Instrument ins) throws NotEnoughFundsException,
    NoSameInstrumentException {
        if (funds < ins.getPrice()) {
            throw new NotEnoughFundsException();
        }
        for (int i = 0; i < instruments.size(); i++) {
            if (instruments.get(i).equals(ins)) {
                throw new NoSameInstrumentException("NoSame"
                    + "InstrumentException");
            }
        }
        instruments.add(ins);
        funds = funds - ins.getPrice();
    }

    /**
     * This method is used to remove any instrument that the Musician
     * wishes to sell from his collection
     * @param ins       the instrument to remove from the collection
     * @throws NoLessThanOneInstrumentException    if less than one
     * instrument is left in the collection
     * @throws DoNotOwnInstrumentException          if the Musician
     *         tries to sell the instrument he doesn't own
     */
    public void sell(Instrument ins) throws NoLessThanOneInstrumentException,
    DoNotOwnInstrumentException {
        if (instruments.size() == 1) {
            throw new NoLessThanOneInstrumentException();
        }
        boolean isThere = false;
        for (Instrument i : instruments) {
            if (i.equals(ins)) {
                isThere = true;
            }
        }
        if (!isThere) {
            throw new DoNotOwnInstrumentException("DoNot"
                + "OwnInstrumentException");
        }
        instruments.remove(ins);
        funds = funds + ins.getPrice();
    }

}