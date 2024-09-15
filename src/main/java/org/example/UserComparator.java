package org.example;

import java.util.Comparator;

/**
 * A generic comparator that compares objects of type.
 *
 * @param <T> the type of objects that this comparator compares, which must implement {@link Comparable}
 */
public class UserComparator<T extends Comparable<T>> implements Comparator<T> {

    /**
     * Compares two objects using their natural ordering.
     * This method returns a negative integer, zero, or a positive integer if the first argument is less than,
     * equal to, or greater than the second, respectively.
     *
     * @param o1 the first object to be compared
     * @param o2 the second object to be compared
     * @return a negative integer, zero, or a positive integer as the first object is less than, equal to,
     *         or greater than the second
     * @throws NullPointerException if either of the arguments is null
     */
    @Override
    public int compare(T o1, T o2) {
        return o1.compareTo(o2);
    }
}
