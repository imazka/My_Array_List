package org.example.parameterized;

import org.example.MyArrayList;
import org.example.User;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The CheckIndexTest class performs parameterized tests on the {@link MyArrayList#get(int)} method.
 * It verifies the behavior of retrieving elements from the list, particularly handling cases
 * where the provided index is either valid or invalid.
 * <p>
 * This class extends {@link ParameterizedBaseTest}, which sets up the basic test environment
 * for parameterized tests. It uses JUnit 5's parameterized test feature, specifically {@link CsvSource},
 * to provide a variety of index values for testing.
 * </p>
 */
public class CheckIndexTest extends ParameterizedBaseTest {

    /**
     * Parameterized test for the {@link MyArrayList#get(int)} method.
     * <p>
     * This method tests the behavior of retrieving an element from the list at a given index.
     * The indices are provided via the {@link CsvSource} annotation, which supplies both valid
     * and invalid index values.
     * </p>
     * <p>
     * The test ensures that:
     * <ul>
     *     <li>If the index is within the valid range (0 to size - 1), the method should return
     *     the corresponding element without throwing an exception.</li>
     *     <li>If the index is out of bounds, an {@link IndexOutOfBoundsException} is expected.</li>
     * </ul>
     * </p>
     *
     * @param index the index to be used for retrieving an element from the list. It may be valid
     *              or out of bounds.
     */
    @ParameterizedTest
    @CsvSource({
            "-2",  // Invalid index (below zero)
            "20",  // Invalid index (beyond the list size)
            "3",   // Valid index (depends on list size)
            "9"    // Valid index (depends on list size)
    })
    public void checkIndexTest(int index) {

        // Add 5 User objects to the list for testing
        for (int i = 0; i < 5; i++) {
            myArrayList.add(new User());
        }

        try {
            // Attempt to retrieve an element at the specified index
            myArrayList.get(index);
            // If index is valid, assert that it is within the expected range
            assertTrue(index >= 0 && index < myArrayList.size());
        } catch (Exception e) {
            // If an exception is thrown, assert that it is an IndexOutOfBoundsException
            assertThrows(IndexOutOfBoundsException.class, () -> {
                myArrayList.get(index);
            });
        }
    }
}
