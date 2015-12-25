import java.util.Set;

/**
* This class defines each movie and implements the Comparable interface
* @version 1.0
* @author Alizain Charania
*/
public class Movie implements Comparable<Movie> {
    private String name;
    private double rating;
    private int year;
    private Set<Genre> genres;

    /**
    * Constructor for the Movie class
    * @param name       name of the movie
    * @param r          rating of the movie
    * @param y          year release of the movie
    * @param g          Set<Genre> of the movie
    */
    public Movie(String name, double r, int y, Set<Genre> g) {
        this.name = name;
        this.rating = r;
        this.year = y;
        genres = g;
    }

    /**
    * Getter of the name
    * @return String name of the movie
    */
    public String getName() {
        return name;
    }

    /**
    * Getter of the rating
    * @return double rating of the movie
    */
    public double getRating() {
        return rating;
    }

    /**
    * Getter of the year
    * @return int year of the movie
    */
    public int getYear() {
        return year;
    }

    /**
    * Getter of the Set Genre
    * @return String name of the movie
    */
    public Set<Genre> getGenres() {
        return genres;
    }

    /**
    * Compares the specified object with this Movie for equality
    * @param o      object to be check for equality
    * @return boolean   Returns true if the specified object
    * is also a Movie and every instance variable is the same
    */
    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof Movie)) {
            return false;
        }
        Movie that = (Movie) other;
        return this.name.equals(that.name)
            && this.year == that.year
            && this.rating == that.rating
            && this.genres.equals(that.genres);
    }

    /**
    * Dummy hashCode() method to follow the equals method
    * @return int Returns the recipe provided on piazza value for this set.
    */
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + year;
        result = 31 * result + (int) rating;
        result = 31 * result + genres.hashCode();
        return result;
    }

    /**
    * Overriding the toString() method to output a custom string
    * @return a String of meaningful statements
    */
    @Override
    public String toString() {
        String result = name + " (" + year + ") - "
            + rating + " " + genres;
        return result;
    }

    /**
    * Overriding the compareTo method to satisfy the Comparable inteface
    * @param other      the Movie to compare to
    * @return int       the integer value which can be used by the sort
    */
    @Override
    public int compareTo(Movie other) {
        int comp =  this.name.compareTo(other.name);
        if (0 == comp) {
            double temp = this.rating - other.rating;
            comp = (temp > 0) ? 1 : (temp == 0) ? 0 : -1;
        }
        if (0 == comp) {
            comp = this.year - other.year;
        }
        if (0 == comp) {
            boolean temp = this.genres.equals(other.genres);
            comp = (temp) ? 0 : 1;
        }
        return comp;
    }
}