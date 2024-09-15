package org.example;

import java.util.Comparator;

/**
 * MyArrayList is a custom implementation of a dynamic array, similar to the standard ArrayList.
 * It supports basic operations such as adding, removing, retrieving, and sorting elements.
 *
 * @param <T> the type of elements stored in this list
 */
public class MyArrayList<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private int size = 0;
    private Object[] elements;

    /**
     * Creates an empty list with the default initial capacity.
     */
    public MyArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    /**
     * Returns the number of elements in the list.
     *
     * @return the current number of elements
     */
    public int size() {
        return size;
    }

    /**
     * Validates the specified index to ensure it is within the valid range of the list.
     *
     * @param index the index to check
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size)
     */
    private void checkIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    /**
     * Adds an element to the end of the list.
     * If the list is full, its capacity is increased.
     *
     * @param t the element to be added to the list
     * @throws NullPointerException if the element is null
     */
    public void add(T t) {
        checkCapacity();
        if (t != null) {
            elements[size++] = t;
        } else {
            throw new NullPointerException("Object can not be null");
        }
    }

    /**
     * Ensures that the list has sufficient capacity to hold additional elements.
     * If the array is full, it increases its size by 1.5 times.
     */
    private void checkCapacity() {
        if (size == elements.length) {
            Object[] newArray = new Object[(int) (elements.length * 1.5 + 1)];
            for (int i = 0; i < size; i++) {
                newArray[i] = elements[i];
            }
            elements = newArray;
        }
    }

    /**
     * Retrieves the element at the specified index.
     *
     * @param index the index of the element to return
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size)
     */
    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    /**
     * Returns the index of the first occurrence of the specified element in this list,
     * or -1 if this list does not contain the element.
     *
     * @param t the element to search for
     * @return the index of the first occurrence of the specified element, or -1 if not found
     */
    public int indexOf(T t) {
        int result = -1;
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(t)) {
                result = i;
                break;
            }
        }

        return result;
    }

    /**
     * Removes the element at the specified index from the list and returns the removed element.
     * The elements after the removed element are shifted to the left.
     *
     * @param index the index of the element to remove
     * @return the element previously at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size)
     */
    public T remove(int index) {
        checkIndex(index);
        T oldValue = get(index);
        for (int i = index; i < size; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;

        return oldValue;
    }


    /**
     * Removes all elements from the list and resets the size to zero.
     * The underlying array is reset to its default capacity.
     */
    public void clear() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Sorts the elements in the list using the provided comparator.
     * If the comparator is null, the elements are sorted in their natural order.
     *
     * @param comparator the comparator to be used for sorting,
     *                   or null for natural ordering
     */
    public void sort(Comparator<? super T> comparator) {
        quickSort((T[]) elements, 0, size - 1, comparator);
    }

    /**
     * Implements the QuickSort algorithm to sort the elements.
     *
     * @param array the array to be sorted
     * @param low the starting index of the array section to sort
     * @param high the ending index of the array section to sort
     * @param comparator the comparator to determine the order of the elements, or null for natural order
     */
    private void quickSort(T[] array, int low, int high, Comparator<? super T> comparator) {
        if (low < high) {
            int pivotIndex = partition(array, low, high, comparator);
            quickSort(array, low, pivotIndex - 1, comparator);
            quickSort(array, pivotIndex + 1, high, comparator);
        }
    }

    /**
     * Partitions the array into two sections based on a pivot element.
     * Elements smaller than the pivot are moved to the left, and larger ones to the right.
     *
     * @param array the array to be partitioned
     * @param low the starting index of the section to partition
     * @param high the ending index of the section to partition
     * @param comparator the comparator to determine the order, or null for natural order
     * @return the index of the pivot element after partitioning
     */
    private int partition(T[] array, int low, int high, Comparator<? super T> comparator) {
        T pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (comparator == null) {
                if (((Comparable<? super T>) array[j]).compareTo(pivot) <= 0) {
                    i++;
                    swap(array, i, j);
                }
            } else {
                if (comparator.compare(array[j], pivot) <= 0) {
                    i++;
                    swap(array, i, j);
                }
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    /**
     * Swaps two elements in the array.
     *
     * @param array the array where the swap will occur
     * @param i the index of the first element to swap
     * @param j the index of the second element to swap
     */
    private void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}