package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The {@code MyArrayListTest} class contains unit tests for the {@code MyArrayList} class,
 * ensuring correct behavior of core methods such as adding elements, clearing the list,
 * finding the index of an element, and removing elements. This class extends the {@code BaseTest},
 * which may provide common setup or utilities for testing.
 */
public class MyArrayListTest extends BaseTest {

    /**
     * Tests the {@code checkCapacity} method of {@code MyArrayList}.
     * The test adds 12 elements to the list, which triggers the capacity expansion.
     * After adding, it checks if the internal array has resized to hold 15 elements (default growth factor logic).
     */
    @Test
    public void checkCapacityTest() {
        for (int i = 0; i < 12; i++) {
            myArrayList.add(new User());
        }

        // The expected size after capacity is expanded
        assertEquals(15, myArrayList.size());
    }

    /**
     * Tests the {@code clear} method of {@code MyArrayList}.
     * This test clears the list and asserts that its size becomes zero after clearing.
     */
    @Test
    public void clearTest() {
        myArrayList.clear();

        // The size should be zero after clearing the list
        assertEquals(0, myArrayList.size());
    }

    /**
     * Tests the {@code indexOf} method of {@code MyArrayList}.
     * This test checks if the correct index is returned when searching for an element ({@code user3}) in the list.
     */
    @Test
    public void indexOfTest() {
        // The index of user3 should be 2
        assertEquals(2, myArrayList.indexOf(user3));
    }

    /**
     * Tests the {@code remove} method of {@code MyArrayList}.
     * This test removes an element at index 1 and checks if the list's size decreases appropriately.
     * It also verifies that the removed element ({@code user2}) is no longer present in the list.
     */
    @Test
    public void removeTest() {
        myArrayList.remove(1);

        // The size should be reduced by 1
        assertEquals(2, myArrayList.size());

        // user2 should no longer exist in the list, returning -1
        assertEquals(-1, myArrayList.indexOf(user2));
    }
}


