import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Zoo {
    // TODO: change below to use the appropriate Java collection instead of an
    // array
    private List<Animal> animals;
    private int count;

    public Zoo() {
        animals = new ArrayList<>();
    }

    public void add(List<Animal> a) {
        // TODO: delete all the code below and replace with a single line
        // after you change the array to a Java collection
        /*animals[count++] = a;
        if (count == animals.length) {
            animals = Arrays.copyOf(animals, count * 2);
        }*/
        animals = a;
    }

    public List<Animal> getList() {
        // TODO: YOUR CODE HERE
        return animals;
    }

    /*
     * TODO: YOUR CODE BELOW
     * Fill out the return type and method body
     **/
    public Set<Animal> getTypes() {
        Set<Animal> an = new HashSet<>(animals);
        return an;
    }

    public Map<Animal, Integer> getAnimalCounts(Animal[] anim) {
        Map<Animal, Integer> map = new HashMap<>();
        for (int i = 0; i < anim.length; i++) {
            if (map.containsKey(anim[i])) {
                map.put(anim[i], map.get(anim[i]) + 1);
            } else {
                map.put(anim[i], 1);
            }
        }
        return map;
    }

    /*
    public ?? getTypes() {
        // YOUR CODE HERE
    }
    */
}
