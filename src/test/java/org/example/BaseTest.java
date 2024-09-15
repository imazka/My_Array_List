package org.example;

import org.junit.jupiter.api.BeforeEach;

/**
 * The BaseTest class provides a foundation for unit tests by initializing common
 * test objects and a collection (MyArrayList) of users.
 * <p>
 * This class sets up the necessary test environment by creating instances of
 * {@link User} objects and populating a {@link MyArrayList} with those users.
 * It serves as a base class for other test classes, so the setup process doesn't
 * need to be repeated in individual test cases.
 * </p>
 */
public class BaseTest {
    /**
     * Protected fields for user objects, allowing access in subclasses.
     */
    protected User user1 = new User();
    protected User user2 = new User();
    protected User user3 = new User();

    /**
     * A collection of users to be used in tests.
     * Initialized in the {@code setUp()} method.
     */
    protected MyArrayList<User> myArrayList;

    /**
     * This method is executed before each test case. It initializes a new instance
     * of {@link MyArrayList} and populates it with predefined users (user1, user2, and user3).
     * <p>
     * The {@code setUp} method is annotated with {@link BeforeEach}, meaning it runs
     * before each test method in any class that extends this base class. It ensures
     * that a fresh test environment is provided for every test.
     * </p>
     */
    @BeforeEach
    protected void setUp() {
        myArrayList = new MyArrayList<>();
        myArrayList.add(user1);
        myArrayList.add(user2);
        myArrayList.add(user3);
    }
}

