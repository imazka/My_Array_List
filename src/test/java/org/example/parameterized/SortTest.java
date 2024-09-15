package org.example.parameterized;

import org.example.MyArrayList;
import org.example.User;
import org.example.UserComparator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

/**
 * The SortTest class extends the {@link ParameterizedBaseTest} and provides a parameterized test
 * for the sorting functionality of the {@link MyArrayList} class using a {@link UserComparator}.
 * <p>
 * This test verifies that the {@link MyArrayList} can correctly sort its elements based on a provided
 * {@link UserComparator}. It ensures that the list is sorted in ascending order according to user ages.
 * </p>
 */
public class SortTest extends ParameterizedBaseTest {

    /**
     * Provides test data for the {@link #sortTest(UserComparator)} method.
     * <p>
     * This method returns a stream of arguments for the parameterized test. In this case, it provides an
     * instance of {@link UserComparator} that will be used to sort the {@link MyArrayList} in the test.
     * </p>
     *
     * @return a stream of {@link Arguments} containing the {@link UserComparator} for sorting.
     */
    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.arguments(new UserComparator<User>())
        );
    }

    /**
     * Parameterized test method that verifies the sorting functionality of {@link MyArrayList}.
     * <p>
     * This test method takes a {@link UserComparator} as a parameter, adds a number of {@link User}
     * objects to the {@link MyArrayList}, sorts the list using the provided comparator, and then
     * asserts that the list is sorted in ascending order based on the age of the {@link User} objects.
     * It also handles null inputs and ensures that sorting is done correctly.
     * </p>
     *
     * @param comparator the {@link UserComparator} used for sorting the {@link MyArrayList}.
     */
    @ParameterizedTest
    @NullSource
    @MethodSource("testData")
    public void sortTest(UserComparator<User> comparator) {

        // Add 20 User objects with random ages to the list
        for (int i = 0; i < 20; i++) {
            myArrayList.add(new User());
        }

        // Sort the list using the provided comparator
        myArrayList.sort(comparator);

        // Verify that the list is sorted in ascending order based on age
        for (int i = 0; i < 19; i++) {
            assertTrue(myArrayList.get(i).getAge() <= myArrayList.get(i + 1).getAge());
        }
    }
}

