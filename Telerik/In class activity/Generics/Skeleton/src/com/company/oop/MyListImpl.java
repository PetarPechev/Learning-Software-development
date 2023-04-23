package com.company.oop;

import java.util.Arrays;
import java.util.Iterator;

public class MyListImpl<T> implements MyList<T> {

    private static final int DEFAULT_CAPACITY = 4;
    private T[] data;
    private int size;

    public MyListImpl() {
        this(DEFAULT_CAPACITY);
    }

    public MyListImpl(int capacity) {
        data = ((T[]) new Object[capacity]);
        size = 0;
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public int capacity() {
        return data.length;
    }

    @Override
    public void add(T element) {
        if (size >= data.length) {
            data = Arrays.copyOf(data, capacity() * 2);
        }

        data[size++] = element;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + " is out of bounds");
        }

        return data[index];
    }

    @Override
    public int indexOf(T element) {
        Object[] es = Arrays.copyOf(data, size());
        if (element == null) {
            for (int i = 0; i < size(); i++) {
                if (es[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size(); i++) {
                if (element.equals(es[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T element) {
        Object[] es = data;
        if (element == null) {
            for (int i = size() - 1; i >= 0; i--) {
                if (es[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = size() - 1; i >= 0; i--) {
                if (element.equals(es[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public boolean contains(T element) {
        return indexOf(element) >= 0;
    }

    @Override
    public void removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[--size] = null;
    }

    @Override
    public boolean remove(T element) {
        int index = indexOf(element);

        if (index < 0) {
            return false;
        }

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[--size] = null;

        return true;
    }

    @Override
    public void clear() {
        //Arrays.fill(data, null);

        for (int i = 0; i < size; i++) {
            data[i] = null;
        }

        size = 0;
    }

    @Override
    public void swap(int from, int to) {
        if (from < 0 || from >= size() || to < 0 || to >= size()) {
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }

        T temp = data[from];
        data[from] = data[to];
        data[to] = temp;
    }

    @Override
    public void print() {
        System.out.print("[");

        for (int i = 0; i < size; i++) {
            System.out.print(data[i]);
            if (i != size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }


    private class MyIterator implements Iterator<T> {
        int index = 0;
        @Override
        public boolean hasNext() {
            return index < size();
        }

        @Override
        public T next() {
            return get(index++);
        }
    }

}
