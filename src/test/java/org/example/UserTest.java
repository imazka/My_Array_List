package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The UserTest class extends the {@link BaseTest} and provides unit tests for the {@link User} class.
 * <p>
 * This class contains tests for the {@link User#compareTo(User)} method to ensure it correctly compares
 * {@link User} instances based on their age. The tests verify that the comparison logic adheres to the expected
 * behavior.
 * </p>
 */
public class UserTest extends BaseTest {

    /**
     * Tests the {@link User#compareTo(User)} method.
     * <p>
     * This test verifies that the {@link User#compareTo(User)} method correctly compares {@link User}
     * instances based on their age. It checks three scenarios:
     * <ul>
     * <li>Comparing a user to itself, which should return 0.</li>
     * <li>Comparing a user with a user of greater age, which should return -1.</li>
     * <li>Comparing a user with a user of lesser age, which should return 1.</li>
     * </ul>
     * </p>
     */
    @Test
    public void compareToTest() {

        // Assert that comparing a user to itself results in 0
        assertEquals(0, user1.compareTo(user1));

        // Assert that comparing a user to another user with greater age returns -1
        assertEquals(-1, user1.compareTo(new User(41)));

        // Assert that comparing a user to another user with lesser age returns 1
        assertEquals(1, user1.compareTo(new User(17)));
    }
}

