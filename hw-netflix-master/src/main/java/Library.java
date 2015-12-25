import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
* This class defines the Library, which is a Collection of Movies
* @version 1.0
* @author Alizain Charania
*/
public class Library {
    private List<Movie> movies;

    /**
    * Constructor for the Library
    * @param m      ArrayList<Movie> to be used
    */
    public Library(ArrayList<Movie> m) {
        movies = new ArrayList<>(m);
    }

    /**
    * This method sorts alphabetically
    * @param m the list of movie to be sorted
    * @return List<Movie> the list of sorted movie
    */
    public List<Movie> listAlphabetically(List<Movie> m) {
        Collections.sort(m);
        return m;
    }

    /**
    * This method groups the list by genres
    * @param g var args input of the Genres
    * @return List<Movie> the list of grouped movies
    */
    public List<Movie> moviesWithGenre(Genre... g) {
        List<Movie> movieByGenre = new ArrayList<>();
        for (Genre gen : g) {
            for (Movie movie : movies) {
                if (movie.getGenres().contains(gen)
                    && !movieByGenre.contains(movie)) {
                    movieByGenre.add(movie);
                }
            }
        }
        return movieByGenre;
    }

    /**
    * This method groups by the year range
    * @param start      the staring year, inclusive
    * @param end        the ending year, exclusive
    * @return List<Movie> the list of group/sorted movies
    */
    public List<Movie> listByYearRange(int start, int end) {
        List<Movie> moviesByYear = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getYear() >= start && movie.getYear() < end) {
                moviesByYear.add(movie);
            }
        }
        Collections.sort(moviesByYear,
            (Movie m1, Movie m2) -> {
                int comp = m1.getYear() - m2.getYear();
                if (0 == comp) {
                    comp = m1.getName().compareTo(m2.getName());
                }
                return comp;
            });
        return moviesByYear;
    }

    /**
    * This method sorts by the rating from low to high
    * @param m the list of movie to be sorted
    * @return List<Movie> the list of sorted movies
    */
    public List<Movie> listByLowestRating(List<Movie> m) {
        Collections.sort(m, (Movie m1, Movie m2) -> {
                double tempd = m1.getRating() - m2.getRating();
                int comp = (tempd > 0) ? 1 : (tempd == 0) ? 0 : -1;
                if (0 == comp) {
                    comp = m1.getName().compareTo(m2.getName());
                }
                return comp;
            });
        return m;
    }

    /**
    * This method sorts by the rating from high to low
    * @param m the list of movie to be sorted
    * @return List<Movie> the list of sorted movies
    */
    public List<Movie> listByHighestRating(List<Movie> m) {
        Collections.sort(m, (Movie m1, Movie m2) -> {
                double tempd = m2.getRating() - m1.getRating();
                int comp = (tempd > 0) ? 1 : (tempd == 0) ? 0 : -1;
                if (0 == comp) {
                    comp = m1.getName().compareTo(m2.getName());
                }
                return comp;
            });
        return m;
    }
}