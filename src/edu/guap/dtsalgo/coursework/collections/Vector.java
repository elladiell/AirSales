package edu.guap.dtsalgo.coursework.collections;

public class Vector<T> {
    //    Размер массива
    private int capacity;
    //    Индекс последнего элемента в массиве
    private int currentSize;
    //    Сам массив
    private T[] array;
    private static final int DEFAULT_CAPACITY = 10;
    private static final int EXTENTION_OF_CAPACITY = 10;


    public Vector(int initialCapacity) {
        capacity = initialCapacity;
        array = (T[]) new Object[initialCapacity];

    }

    public Vector(T[] array) {
        capacity = array.length;
        currentSize = capacity;
        this.array = array;
    }

    public Vector() {
        capacity = 0;
        currentSize = capacity;
        array = (T[])new Object[DEFAULT_CAPACITY];
    }


    public int getCurrentSize() {
        return currentSize;
    }


    public void addElement(T element) {
        // Если в массиве уже нет свободных мест, то созаём новый больший массив,
        // копируем в него старый и делаем его теперь новым хранилищем данных вектора
        if (currentSize == capacity) {
            T[] array2 = (T[]) new Object[capacity + EXTENTION_OF_CAPACITY];
            System.arraycopy(array, 0, array2, 0, capacity);
            array = array2;
            capacity = array2.length;
        }
        array[currentSize++] = element;
    }

    public boolean removeAt(int index) {
        if (index < 0 || index >= capacity) return false;
        if ((index < currentSize) && (currentSize > 0)) {
            System.arraycopy(array, index + 1, array, index, currentSize - index);
            currentSize--;
            return true;
        }
        return false;
    }

    public boolean insertAt(int index, T element) {
        if (index < 0 || index >= capacity) return false;
        if (index < currentSize) {
            // Если в массиве уже нет свободных мест, то созаём новый больший массив,
            // копируем в него старый и делаем его теперь новым хранилищем данных вектора
            if (currentSize == capacity) {
                T[] array2 = (T[])new Object[index + EXTENTION_OF_CAPACITY];
                System.arraycopy(array, 0, array2, 0, capacity);
                array = array2;
                capacity = array2.length;
            }
            System.arraycopy(array, index, array, index + 1, (capacity - 1 - index));
            array[index] = element;
            currentSize++;
        } else {
            array[index] = element;
            currentSize = index;
        }
        return true;
    }

    public Object getElement(int index) {
        if ((index < capacity) && (index >= 0)) {
            return array[index];
        } else return null;
    }

    public boolean setElement(int index, T element) {
        if (index < 0) {
            return false;
        } else if (index < currentSize) {
            array[index] = element;
            return true;
        } else if (index < capacity) {
            array[index] = element;
            currentSize = index;
            return true;
        } else return false;
    }
}