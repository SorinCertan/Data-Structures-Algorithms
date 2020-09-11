package datastructures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class GenericDynamicArrayTest {

    @Test
    public void isEmptyList() {
        GenericDynamicArray<Integer> list = new GenericDynamicArray<>();
        assertTrue(list.isEmpty());
    }

    @Test(expected = Exception.class)
    public void testRemovingEmpty() {
        GenericDynamicArray<Integer> list = new GenericDynamicArray<>();
        list.removeAt(0);
    }

    @Test(expected = Exception.class)
    public void testIndexOutOfBounds() {
        GenericDynamicArray<Integer> list = new GenericDynamicArray<>();
        list.add(-100);
        list.add(-25);
        list.add(-1995);
        list.removeAt(3);
    }

    @Test(expected = Exception.class)
    public void testIndexOutOfBounds2() {
        GenericDynamicArray<Integer> list = new GenericDynamicArray<>();
        for (int i = 0; i < 500; i++) list.add(i);
        list.removeAt(500);
    }

    @Test(expected = Exception.class)
    public void testIndexOutOfBounds3() {
        GenericDynamicArray<Integer> list = new GenericDynamicArray<>();
        for (int i = 0; i < 10; i++) list.add(100);
        list.removeAt(-1);
    }

    @Test(expected = Exception.class)
    public void testIndexOutOfBounds4() {
        GenericDynamicArray<Integer> list = new GenericDynamicArray<>();
        for (int i = 0; i < 10; i++) list.add(i);
        list.removeAt(-20);
    }

    @Test
    public void testRemoving() {
        GenericDynamicArray<String> list = new GenericDynamicArray<>();
        String[] strings = {"a", "b", "c", "d", "e", null, "g", "k"};
        for (String s : strings) list.add(s);

        boolean retrieve = list.remove("c");
        assertTrue(retrieve);

        retrieve = list.remove("c");
        assertFalse(retrieve);

        retrieve = list.remove("k");
        assertTrue(retrieve);

        retrieve = list.remove(null);
        assertTrue(retrieve);

        retrieve = list.remove("a");
        assertTrue(retrieve);

        retrieve = list.remove("a");
        assertFalse(retrieve);

        retrieve = list.remove("k");
        assertFalse(retrieve);

        retrieve = list.remove(null);
        assertFalse(retrieve);
    }

    @Test
    public void testRemoving2() {
        GenericDynamicArray<String> list = new GenericDynamicArray<>();
        String[] strings = {"a", "b", "c", "d"};

        for (String s : strings) list.add(s);

        assertTrue(list.remove("a"));
        assertTrue(list.remove("b"));
        assertTrue(list.remove("c"));
        assertTrue(list.remove("d"));


        assertFalse(list.remove("a"));
        assertFalse(list.remove("b"));
        assertFalse(list.remove("c"));
        assertFalse(list.remove("d"));
    }

    @Test
    public void testIndexOfNullElement() {
        GenericDynamicArray<String> list = new GenericDynamicArray<>();
        String[] strings = {"a", "b", null, "d"};
        for (String s : strings) list.add(s);

        assertTrue(list.indexOf(null) == 2);
    }

    @Test
    public void testAddingElements() {
        GenericDynamicArray<Integer> list = new GenericDynamicArray<>();
        int[] elements = {1, 2, 3, 4, 5, 6, 7};

        for (int i : elements) list.add(i);

        for (int i = 0; i < elements.length; i++) assertEquals(list.get(i).intValue(), elements[i]);
    }

    @Test
    public void testAddAndRemove() {
        GenericDynamicArray<Long> list = new GenericDynamicArray<>();

        for (int i = 0; i < 30; i++) list.add(20L);
        for (int i = 0; i < 30; i++) list.remove(20L);
        assertTrue(list.isEmpty());

        for (int i = 0; i < 30; i++) list.add(20L);
        for (int i = 0; i < 30; i++) list.removeAt(0);
        assertTrue(list.isEmpty());

        for (int i = 0; i < 60; i++) list.add(20L);
        for (int i = 0; i < 60; i++) list.remove(20L);
        assertTrue(list.isEmpty());

        for (int i = 0; i < 30; i++) list.add(20L);
        for (int i = 0; i < 30; i++) list.remove(0);
        assertTrue(list.isEmpty());
    }

    @Test
    public void testAndSetRemove() {
        GenericDynamicArray<Long> list = new GenericDynamicArray<>();

        for (int i = 0; i < 55; i++) list.add(44L);
        for (int i = 0; i < 55; i++) list.set(i, 33L);
        for (int i = 0; i < 55; i++) list.remove(33L);
        assertTrue(list.isEmpty());

        for (int i = 0; i < 55; i++) list.add(44L);
        for (int i = 0; i < 55; i++) list.set(i, 33L);
        for (int i = 0; i < 55; i++) list.removeAt(0);
        assertTrue(list.isEmpty());

        for (int i = 0; i < 155; i++) list.add(44L);
        for (int i = 0; i < 155; i++) list.set(i, 33L);
        for (int i = 0; i < 155; i++) list.remove(33L);
        assertTrue(list.isEmpty());

        for (int i = 0; i < 155; i++) list.add(44L);
        for (int i = 0; i < 155; i++) list.removeAt(0);
        assertTrue(list.isEmpty());
    }

    @Test
    public void testSize() {
        GenericDynamicArray<Integer> list = new GenericDynamicArray<>();

        Integer[] elements = {-50, -34, 20, 70, 2, null, 90};
        for (int i = 0, size = 1; i < elements.length; i++, size++) {
            list.add(elements[i]);
            assertEquals(list.size(), size);
        }
    }
}
