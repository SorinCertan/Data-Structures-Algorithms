/**
 * This is an implementation of a generic dynamic array
 * @Author name:  Certan Sorin
 * @Author email: sorin.certan.work@gmail.com
 */

package datastructures;

import java.util.Iterator;

public class GenericDynamicArray<T> implements Iterable<T>{

    private T[] genericArrayList;
    private int size = 0;
    private int capacity = 0;

    /**
     * Default capacity of the ArrayList
     */
    public GenericDynamicArray() {this(11);}

    /**
     *Create a list with the specified capacity
     * @param initialCapacity the initial capacity of the list
     * @throws IllegalArgumentException in case the capacity is negative
     */
    public GenericDynamicArray(int initialCapacity) {
        if (initialCapacity < 0) throw new IllegalArgumentException("Illegal array size: " + initialCapacity);
        this.capacity = initialCapacity;
        genericArrayList = (T[]) new Object[initialCapacity];
    }

    /**
     * @return the number of elements in the list
     */
    public int size() { return size; }

    /**
     * @return {true} if the list contains no elements
     */
    public boolean isEmpty() { return size() == 0;}

    /**
     * @param index the index of the desired element
     * @return the element at the specified index
     */
    public T get (int index) {
        return genericArrayList[index];
    }

    /**
     * set en element at a specified index
     * @param index desired index inside the list
     * @param element the element which should be assigned at the specified index
     */
    public void set(int index, T element) {
        genericArrayList[index] = element;
    }

    /**
     * assign all elements of the list to null
     */
    public void clear() {
        for (int i = 0; i < size; i++) genericArrayList[i] = null;
        size = 0;
    }

    /**
     * Add an element to the list
     * If the array capacity is full then the capacity is doubled
     * @param element the element that is added to the list
     */
    public void add(T element) {
        if (size + 1 >= capacity) {
            if (capacity == 0) capacity = 1;
            else capacity *= 2; // double the array size
            T[] tempArrayList = (T[]) new Object[capacity];
            for (int i = 0; i < size; i++) tempArrayList[i] = genericArrayList[i];
            genericArrayList = tempArrayList; // genericArray has extra null at the end
        }
        genericArrayList[size++] = element;
    }

    /**
     * Removes an element at a specific index
     * @param index the object's index to be removed
     * @return the removed object
     */
    public T removeAt(int index) {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException();
        T tempData = genericArrayList[index];
        T[] tempArrayList = (T[]) new Object[size - 1];
        for (int i = 0, j = 0; i < size; i++, j++) {
            if (i == index) j--; // skip over removeAtIndex by fixing j temporarily
            else tempArrayList[j] = genericArrayList[i];
        }
        genericArrayList = tempArrayList;
        capacity = --size;
        return tempData;
    }

    /**
     * Remove an object from the list
     * @param object the object to be removed
     * @return {true} if object is removed
     */
    public boolean remove(Object object) {
        int index = indexOf(object);
        if (index == -1) return false;
        removeAt(index);
        return true;
    }

    /**
     * Checks the index of a specific object in the list
     * @param object the searched object
     * @return the index of the searched object
     */
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (object == null) {
                if (genericArrayList[i] == null) return i;
            }else {
                if (object.equals(genericArrayList[i])) return i;
            }
        }
        return -1;
    }

    /**
     * Check if the object is in the list
     * @param object the searched object
     * @return {true} if the list contains the object
     */
    public boolean contains (Object object) {return indexOf(object) != -1;}

    /**
     * Implemented methods of the Iterator interface
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                return genericArrayList[index++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    /**
     * @return the string of objects that are on the list
     */
    @Override
    public String toString() {
        if (size == 0) return "[]";
        else {
            StringBuilder stringBuilder = new StringBuilder(size).append("[");
            for (int i = 0; i < size; i++) stringBuilder.append(genericArrayList[i] + ", ");
            return stringBuilder.append(genericArrayList[size - 1] + "]").toString();
        }
    }
}
