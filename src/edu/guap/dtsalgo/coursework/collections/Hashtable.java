package edu.guap.dtsalgo.coursework.collections;


import java.util.Iterator;

public class Hashtable <T,S> implements Iterable<T> {

    private LinkedList[] table;
    // Критическая длина списка (chain-а)
    private int criticalLength;

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int idxInTable = -1;
            int idxInList = -1;

            @Override
            public boolean hasNext() {
                if(idxInTable >= 0){
                    if(idxInList + 1 < table[idxInTable].getSize()) return true;
                }
                idxInTable++;
                for (; idxInTable < table.length; ++idxInTable) {
                    if(table[idxInTable].getSize() > 0){
                        idxInList = 0;
                        return true;
                    }
                }
                return false;
            }

            @Override
            public T next() {
                return ((Pair)table[idxInTable].getElement(idxInList)).getKey();
            }
        };
    }

    private class Pair {
        T key;
        S value;

        Pair(T k, S v) {
            key = k;
            value = v;

        }

        public T getKey() {
            return key;
        }

        public S getValue() {
            return value;
        }
    }

    public Hashtable() {
        table = new LinkedList[100];
        for (int i = 0; i < 100; i++) {
            table[i] = new LinkedList();

        }

        criticalLength = 10;
    }


    public Hashtable(int size) {
        table = new LinkedList[size];
        criticalLength = size / 10;
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList();
        }
    }




    private int getHash(Object o) {
        return Math.abs(o.hashCode() % table.length);
    }

    // Создаёт более вместительную хэштаблицу,
    // c теми же элементами, как и были
    public void reHash() {
        Hashtable table2 = new Hashtable(this.table.length * 2);
        for (LinkedList chain : table) {
            for (int i = 0; i < chain.getSize(); i++)
                if (chain.getElement(i) != null) {
                    Pair e = (Pair) chain.getElement(i);
                    table2.table[table2.getHash(e.key)].addLast(e);
                } else break;
        }
        this.table = table2.table;
        this.criticalLength = table2.criticalLength;
    }

    /**
     * associates a specified value with specified key, if the key was previously
     * associated with another value, returns it, otherwise returns null
     * @param key
     * @param value
     * @return
     */
    public Object put(T key, S value) {
        int hash = getHash(key);
        //Если размер списка, расположенного в массиве под № hash слишком велико,
        // то перехэшировать таблицу
        if (table[hash].getSize() > criticalLength) {
            this.reHash();
            hash = getHash(key);
        }

        if (table[hash].getSize() > 0) {
            for (int i = 0; i < table[hash].getSize(); i++) {
                Pair pair = (Pair) table[hash].getElement(i);
                // Если в списке уже есть такой ключ, заменяем его значение на новое, а старое возвращаем
                if (pair.key == key) {
                    Object toReturn = pair.value;
                    table[hash].setElement(i, new Pair(key, value));
                    return toReturn;
                }
            }
        }
        //Если достигли конца списка, добавляем новый элемент списка в конец
        table[hash].addLast(new Pair(key, value));
        return null;
    }

    /**
     * Gets a value, associated with
     * specified key, returns null if key is not associated with any value
     *
     * @param key
     * @return
     */
    public Object get(Object key) {
        int hash = getHash(key);
        if (table[getHash(key)].getSize() > 0) {
            for (int i = 0; i < table[hash].getSize(); i++) {
                Pair pair = (Pair) table[getHash(key)].getElement(i);
                if (pair.key == key) {
                    return pair.value;
                }
            }
        }
        return null;
    }

    /**
     * Removes association of the specified key,
     * and returns previously associated value or null if
     * key was not associated with any value
     *
     * @param key
     * @return
     */
    public Object remove(Object key) {
        int chain = table[getHash(key)].getSize();
        if (chain > 0) {
            for (int i = 0; i < chain; i++) {
                Pair compare = (Pair) table[getHash(key)].getElement(i);
                if (compare.key == key) {
                    Object toReturn = compare.value;
                    table[getHash(key)].removeAt(i);
                    return toReturn;
                }
            }
        }
        return null;

    }
}