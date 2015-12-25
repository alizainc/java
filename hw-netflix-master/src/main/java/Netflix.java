import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 * Your Netflix journey begins here!
 *
 * @author Jayanth
 * @author Srijan
 * @author PUT YOUR NAME HERE
 * @version 1.0
 */
public class Netflix {

    private static Scanner in;
    private static PopulateNetflix popPop;
    private static Random rand;
    private static Library library;
    private static List<Movie> list;

    /**
     * Main method for Netflix. This produces the high-end login screen
     * for our Netflix service that took a team of experienced
     * UI designers to create.
     *
     * @param args command-line arguments for the program.
     */
    public static void main(String[] args) throws Exception {
        in = new Scanner(System.in);
        popPop = new PopulateNetflix();
        library = new Library(popPop.getNetflixPopulation());
        // TODO: Change the variable below to be a properly type-parameterized
        // map from roommate names to a list of movies. See the instructions
        // for which roommates to add and what their watchlists should be
        Map<String, List<Movie>> userWatchLists = new HashMap<>();
        list = new ArrayList<>(library.moviesWithGenre(Genre.COMEDY));
        list = library.listAlphabetically(list);
        userWatchLists.put("Taylor", list);
        List<Movie> list1 = new ArrayList<>(
            library.moviesWithGenre(Genre.ACTION, Genre.ADVENTURE));
        list1 = library.listByHighestRating(list1);
        userWatchLists.put("George", list1);
        List<Movie> list2 = new ArrayList<>(
            library.listByYearRange(1980, 2000));
        userWatchLists.put("Sarah", list2);


        boolean running = true;
        System.out.println("Welcome to your very own Netflix service!");
        while (running) {
            System.out.println("\nNow, who's watching tonight? [q to exit]");

            String response = in.nextLine();
            if (response.equals("q")) {
                System.out.println("Thanks for watching!");
                running = false;
            } else if (userWatchLists.containsKey(response)) {

                // TODO: change this to get the requested user's watch list
                // instead of an empty list
                List<Movie> watchList = null;
                if (response.equals("Taylor")) {
                    watchList = userWatchLists.get("Taylor");
                } else if (response.equals("Sarah")) {
                    watchList = userWatchLists.get("Sarah");
                } else if (response.equals("George")) {
                    watchList = userWatchLists.get("George");
                }

                int numMovies = -1;
                while (numMovies < 1) {
                    System.out.println("How many movies would you like"
                        + " to watch? (1 - 10)");
                    try {
                        numMovies = Integer.parseInt(in.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input, please try again");
                    }
                }

                System.out.println("\nHere you go!\n");

                if (numMovies > watchList.size()) {
                    numMovies = watchList.size();
                }
                for (Movie m : watchList.subList(0, numMovies)) {
                    System.out.println(m);
                }
            } else {
                System.out.println("\nNetflix does not "
                    + "recognize that input\n");
            }
        }
    }
}
