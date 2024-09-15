package org.example;

import com.github.javafaker.Faker;
import java.util.Random;

/**
 * The {@code User} class represents a user with a name and age.
 * This class implements the {@link Comparable} interface to allow comparison of users based on their age.
 * The comparison is based on the natural ordering of the age attribute.
 */
public class User implements Comparable<User> {

    private String name;
    private int age;

    /**
     * Default constructor that creates a user with a random name and age.
     * The name is generated using {@link Faker} and the age is randomly set between 20 and 40.
     */
    public User() {
        this.name = new Faker().name().firstName();
        this.age = new Random().nextInt(20, 40);
    }

    /**
     * Constructor that creates a user with a random name and a specified age.
     * The name is generated using {@link Faker}.
     *
     * @param age the age of the user
     */
    public User(int age) {
        this.name = new Faker().name().firstName();
        this.age = age;
    }

    /**
     * Returns the age of the user.
     *
     * @return the age of the user
     */
    public int getAge() {
        return age;
    }

    /**
     * Compares this user with the specified user for order based on age.
     * Returns a negative integer, zero, or a positive integer as this user's age is less than, equal to,
     * or greater than the specified user's age.
     *
     * @param o the user to be compared
     * @return a negative integer, zero, or a positive integer as this user's age is less than, equal to,
     *         or greater than the specified user's age
     */
    @Override
    public int compareTo(User o) {
        if (age == o.getAge()) return 0;
        else if (age < o.getAge()) return -1;
        else return 1;
    }
}
