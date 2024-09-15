package org.example.parameterized;

import org.example.MyArrayList;
import org.example.User;
import org.junit.jupiter.api.BeforeEach;

/**
 * The ParameterizedBaseTest class provides a base setup for parameterized tests involving
 * the {@link MyArrayList} class, specifically for use with {@link User} objects.
 * <p>
 * This class initializes the {@link MyArrayList} instance before each test, ensuring
 * that each test starts with a fresh instance of the list. It is designed to be extended
 * by test classes that require a pre-configured {@link MyArrayList} for their parameterized tests.
 * </p>
 */
public class ParameterizedBaseTest {

    /**
     * An instance of {@link MyArrayList} used in the parameterized tests.
     * This list is specifically typed to hold {@link User} objects.
     */
    protected MyArrayList<User> myArrayList;

    /**
     * Sets up the test environment by initializing a new instance of {@link MyArrayList}.
     * <p>
     * This method is annotated with {@link BeforeEach}, ensuring that a fresh instance
     * of {@link MyArrayList} is created before each test method is executed. This helps
     * to maintain isolation between tests and ensures that tests do not interfere with each
     * other's state.
     * </p>
     */
    @BeforeEach
    protected void setUp() {
        myArrayList = new MyArrayList<>();
    }

}

