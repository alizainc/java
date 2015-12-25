import java.util.ArrayList;

/**
 * This is a tester class named MusicStore. It is used to test the
 * the instruments homework which uses/outputs every moethod created
 * @author Alizain Charania
 * @version 1.0 Oct. 6 2015
 */
public class MusicStore {

    /**
     * This is the main method. This is the initial begging point of the program
     * @param args      it takes in the input from the command line call
     */
    public static void main(String[] args) {
        double violinPrice = 80.00;
        String violinProperty = "10 strings";
        Instrument violin = new Violin(violinPrice,
            violinProperty);

        Instrument trumpet = new Trumpet(120.00, "15cm diameter");
        Instrument flute = new Flute(35.00, "2cm thick and 10cm long");
        Instrument snareDrum = new SnareDrum(200.00,
            "25 inches diameter");

        String musicianName = "Mark";
        double musicianFund = 350.00;
        ArrayList<Instrument> instruments = new ArrayList<>();
        instruments.add(violin);
        Musician mark = null;
        try {
            mark = new Musician(musicianName, musicianFund, instruments);
        } catch (NoLessThanOneInstrumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(violin.play());
        System.out.println(violin.toString());
        System.out.println("-----------------------------");

        System.out.println(trumpet.play());
        System.out.println(trumpet.toString());
        System.out.println("-----------------------------");

        System.out.println(flute.play());
        System.out.println(flute.toString());
        System.out.println("-----------------------------");

        System.out.println(snareDrum.play());
        System.out.println(snareDrum.toString());
        System.out.println("-----------------------------");

        System.out.printf("Musician name: %s, funds: $%.2f.\n",
            mark.getName(), mark.getFunds());
        System.out.printf("%s has the following instruments by "
            + "serial number:\n", mark.getName());
        for (Instrument i : mark.getInstruments()) {
            System.out.println(i.getSerialNum());
        }
        System.out.println("-----------------------------");

        try {
            mark.purchase(trumpet);
            mark.purchase(snareDrum);
            System.out.println("Buying new instruments");
            System.out.printf("Musician name: %s, funds: $%.2f.\n",
                mark.getName(), mark.getFunds());
            System.out.printf("%s has the following instruments by "
                + "serial number:\n", mark.getName());
            for (Instrument i : mark.getInstruments()) {
                System.out.println(i.getSerialNum());
            }
            System.out.println("-----------------------------");

            mark.purchase(flute);
            System.out.println("-----------------------------");
        } catch (NotEnoughFundsException e) {
            System.out.println(e.getMessage());
        } catch (NoSameInstrumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("-----------------------------");

        try {
            mark.sell(flute);
        } catch (NoLessThanOneInstrumentException e) {
            System.out.println(e.getMessage());
        } catch (DoNotOwnInstrumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("-----------------------------");

        try {
            mark.sell(trumpet);
            mark.sell(snareDrum);
            System.out.println("Selling owned instruments");
            System.out.printf("Musician name: %s, funds: $%.2f.\n",
                mark.getName(), mark.getFunds());
            System.out.printf("%s has the following instruments by "
                + "serial number:\n", mark.getName());
            for (Instrument i : mark.getInstruments()) {
                System.out.println(i.getSerialNum());
            }
            System.out.println("-----------------------------");

            mark.sell(violin);
            System.out.println("-----------------------------");
        } catch (NoLessThanOneInstrumentException e) {
            System.out.println(e.getMessage());
        } catch (DoNotOwnInstrumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("-----------------------------");

        try {
            mark.purchase(violin);
        } catch (NoSameInstrumentException e) {
            System.out.println(e.getMessage());
        } catch (NotEnoughFundsException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("-----------------------------");

        ArrayList<Instrument> nullInstrument = new ArrayList<>();
        try {
            Musician john = new Musician("John", 1000.00, nullInstrument);
        } catch (NoLessThanOneInstrumentException e) {
            System.out.println(e.getMessage());
        }
    }
}