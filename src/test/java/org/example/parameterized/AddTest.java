package org.example.parameterized;

import org.example.MyArrayList;
import org.example.User;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * The AddTest class performs parameterized tests on the {@link MyArrayList#add(Object)} method.
 * It verifies the behavior of adding {@link User} objects to the list and handles cases
 * where {@code null} is passed as a parameter.
 * <p>
 * This class extends {@link ParameterizedBaseTest}, which likely sets up the basic test
 * environment for parameterized tests. It uses JUnit 5's parameterized test features,
 * specifically {@link MethodSource} and {@link NullSource}, to provide test data.
 * </p>
 */
public class AddTest extends ParameterizedBaseTest {

    /**
     * Provides test data for the {@code addTest} method.
     * <p>
     * The method returns a stream of {@link Arguments} with a single {@link User} object.
     * This data is used by the parameterized test to check the behavior of the {@code add} method.
     * </p>
     *
     * @return a stream of arguments containing a {@link User} instance.
     */
    private static Stream<Arguments> testData() {
        return Stream.of(
                arguments(new User())  // Providing a User object for testing
        );
    }

    /**
     * Parameterized test for the {@link MyArrayList#add(Object)} method.
     * <p>
     * This method tests adding a {@link User} object to the list, including a case
     * where {@code null} is passed. It handles potential {@link NullPointerException}
     * when {@code null} is added to the list, as {@code myArrayList.add()} should
     * throw an exception when attempting to add {@code null}.
     * </p>
     * <p>
     * The test uses JUnit's {@link ParameterizedTest} to run multiple scenarios.
     * {@link NullSource} is used to provide {@code null} as input, while
     * {@link MethodSource} supplies additional {@link User} instances for testing.
     * </p>
     *
     * @param user the {@link User} object to be added to the list, can be {@code null}.
     */
    @ParameterizedTest
    @NullSource
    @MethodSource("testData")
    public void addTest(User user) {
        try {
            // Attempt to add user to the list and assert it's added correctly
            myArrayList.add(user);
            assertEquals(user, myArrayList.get(0));  // Check if user is added at index 0
        } catch (Exception e) {
            // If an exception is caught, assert that it's a NullPointerException
            assertThrows(NullPointerException.class, () ->
                    myArrayList.add(user));  // Expect a NullPointerException if user is null
        }
    }
}

