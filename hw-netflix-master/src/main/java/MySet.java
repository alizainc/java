import java.util.Iterator;
import java.util.Collection;
import java.util.Arrays;
import java.util.Set;

/**
* This class implements the Set interface
*
* @param <T> Param Type
* @version 1.0
* @author Alizain Charania
*/
public class MySet<T> implements Set<T> {

    private T[] backingArray;
    private int numElements;

    /**
    * This is the constructor of the MySet() Collection
    */
    public MySet() {
        backingArray = (T[]) new Object[10];
        numElements = 0;
    }

    /**
    * This method adds each element in the MySet Collection
    * @param t      element to be added of generic type T
    * @return boolean   returns a true if the adding is successful
    */
    @Override
    public boolean add(T t) {
        if (t == null) {
            return false;
        }
        if (backingArray.length <= numElements) {
            backingArray = Arrays.copyOf(backingArray, backingArray.length * 2);
        }
        for (T element :  backingArray) {
            if (t.equals(element)) {
                return false;
            }
        }
        backingArray[numElements] = t;
        numElements++;
        return true;
    }

    /**
    * This method adds all the elements from a different Collection
    * in the MySet Collection
    * @param t      Collection to be added that extends generic type T
    * @return boolean   returns a true if the adding is successful
    */
    @Override
    public boolean addAll(Collection<? extends T> t) {
        boolean didChange = false;
        for (T n : t) {
            didChange = this.add(n) || didChange;
        }
        return didChange;
    }

    /**
    * This method clear all the elements in the MySet Collection
    */
    @Override
    public void clear() {
        T[] arr = (T[]) new Object[backingArray.length];
        backingArray = arr;
        numElements = 0;
    }

    /**
    * This method checks if the given object is
    * present in the MySet Collection
    * @param o      element to be checked of type Object
    * @return boolean   returns a true if it contains the object
    */
    @Override
    public boolean contains(Object o) {
        for (T element : backingArray) {
            if (o != null && o.equals(element)) {
                return true;
            }
        }
        return false;
    }

    /**
    * If the specified collection is also a set,
    * this method returns true if it is a subset of this set.
    * @param o      Collection to be checked of type Object
    * @return boolean   returns a true if it contains
    * all of the elements of the specified collection
    */
    @Override
    public boolean containsAll(Collection<?> c) {
        Iterator<?> e = c.iterator();
        while (e.hasNext()) {
            if (!contains(e.next())) {
                return false;
            }
        }
        return true;
    }

    /**
    * Compares the specified object with this set for equality
    * @param o      object to be check for equality
    * @return boolean   Returns true if the specified object
    * is also a set, the two sets have the same size,
    * and every member of the specified set is contained in this set
    */
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (!(o instanceof Collection)) {
            return false;
        }
        Collection other = (Collection) o;
        return (this.containsAll(other)) && (this.size() == other.size());
    }

    /**
    * Dummy hashCode() method to satisfy the Set interface
    * @return int Returns the recipe provided on piazza value for this set.
    */
    @Override
    public int hashCode() {
        int result = 17;
        for (T elem : backingArray) {
            if (elem != null) {
                result = 31 * result + elem.hashCode();
            }
        }
        result = 31 * result + size();
        return result;
    }

    /**
    * Check if the Collection is empty
    * @return boolean   Returns true if this set contains no elements.
    */
    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    /**
    * Removes the specified element from this set if it is present
    * @param elem   the obect to remove
    * @return boolean  return true if this set changed as
    * a result of the call
    */
    @Override
    public boolean remove(Object elem) {
        int target = -1;
        int i = 0;
        for (; i < this.size(); i++) {
            if (backingArray[i].equals(elem)) {
                target = i;
            }
        }
        if (target == -1) {
            return false;
        }
        for (i = target; i < this.size(); i++) {
            if (i + 1 < backingArray.length) {
                backingArray[i] = backingArray[i + 1];
            } else {
                backingArray[i] = null;
            }
        }
        numElements--;
        return true;
    }

    /**
    * Removes from this set all of its elements
    * that are contained in the specified collection
    * @param c  the Collection to be removed
    * @return boolean  return true if the Set is changed by this call
    */
    @Override
    public boolean removeAll(Collection<?> c) {
        T[] arr = (T[]) c.toArray();
        boolean removed = false;
        for (int i = 0; i < arr.length; i++) {
            if (remove(arr[i])) {
                removed = true;
            }
        }
        return removed;
    }

    /**
    * Retains only the elements in this
    * set that are contained in the specified collection
    * @param c      the Collection to retain
    * @return boolean   returns truw if the set is changed by this call
    */
    @Override
    public boolean retainAll(Collection<?> c) {
        T[] arr = (T[]) c.toArray();
        T[] newArr = (T[]) new Object[numElements];
        numElements = 0;
        boolean retained = false;
        for (int i = 0; i < arr.length; i++) {
            if (this.contains(arr[i])) {
                retained = true;
                newArr[numElements] = arr[i];
                numElements++;
            }
        }
        if (!retained) {
            return false;
        }
        backingArray = newArr;
        return retained;
    }

    /**
    * Gives the current size of the set
    * @return int   the size of the set (numElements)
    */
    @Override
    public int size() {
        return numElements;
    }

    /**
    * changes the set into a array
    * @return Object[]  returns the array of the set
    */
    @Override
    public Object[] toArray() {
        Object[] arr = new Object[numElements];
        for (int i = 0; i < numElements; i++) {
            arr[i] = backingArray[i];
        }
        return arr;
    }

    /**
    * Dummy method to satisfy the Set interface
    * @return <T> T[]   the array casted to T[]
    */
    @Override
    public <T> T[] toArray(T[] arr) {
        arr = (T[]) this.toArray();
        return arr;
    }

    /**
    * Overriding the toString() method to output a custom string
    * @return a String of meaningful statements
    */
    @Override
    public String toString() {
        String output = "[";
        for (int i = 0; i < size() - 1; i++) {
            output += backingArray[i].toString() + ", ";
        }
        if (size() != 0) {
            output += backingArray[size() - 1].toString();
        }
        output += "]";
        return output;
    }

    /**
    * Returns an iterator if you wish to use it
    * @return An iterator for the SimpleSet
    */
    public Iterator<T> iterator() {
        return new MySetIterator();
    }

    private class MySetIterator implements Iterator {

        private int index = 0;
        public boolean hasNext() {
            return index < numElements;
        }

        public T next() {
            return backingArray[index++];
        }

        public void remove() {
            MySet.this.remove(backingArray[index]);
            index--;
        }
    }

}
