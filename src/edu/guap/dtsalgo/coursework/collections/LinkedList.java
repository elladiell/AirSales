package edu.guap.dtsalgo.coursework.collections;


public class LinkedList<T> {

    protected Node first;
    protected Node last;

    protected int length;

    // Узел(элемент) списка
    protected class Node {
        // Сами данные
        private T data;
        // Ссылка на следующий элемент
        private Node nextNode;

        Node() {
        }

        public T getData() {
            return data;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        Node(T data) {
            this.data = data;
            nextNode = null;
        }

        Node(T dat, Node nextNode) {
            data = dat;
            this.nextNode = nextNode;
        }

    }

    public LinkedList() {
    }

    public int getSize() {
        return length;
    }

    protected void addFirstElementToEmptyList(T element) {
        last = first = new Node(element);
        length++;
    }

    public void addLast(T element) {
        if (first == null) {
            addFirstElementToEmptyList(element);
            return;
        }
        Node prevLast = last;
        prevLast.nextNode = last = new Node(element);
        length++;
    }

    public void addFirst(T element) {
        if (first == null) {
            addFirstElementToEmptyList(element);
            return;
        }
        Node prevFirst = first;
        first = new Node(element, prevFirst);
        length++;

    }

    public Object getFirst() {
        if (first == null) return null;
        return first.data;
    }

    public Object getLast() {
        if (last == null) return null;
        return last.data;
    }

    public boolean removeAt(int index) {
        if (null == first || (index < 0 || index >= length)) return false;
        if (index == 0) {
            first = first.nextNode;
            length--;
            return true;
        }
        // Проходим по списку к элементу номер index
        Node buf = first;
        for (int i = 1; i < index; i++) {
            buf = buf.nextNode;
            if (buf == null) {
                return false;
            }
        }
        buf.nextNode = buf.nextNode.nextNode;
        if (buf.nextNode == null) last = buf;
        length--;
        return true;
    }


    public boolean insertAt(int index, T element) {
        if (index < 0 || index >= length) return false;
        // добавление в начало
        if (index == 0) {
            addFirst(element);
            return true;
        }
        // добавление в конец
        if (index == length) {
            addLast(element);
            return true;
        }
        // добавление в середину (не начало и конец)
        Node buf = first;
        for (int i = 1; i < index; i++) {
            buf = buf.nextNode;
            if (buf == null) {
                return false;
            }
        }
        buf.nextNode = new Node(element, buf.nextNode);
        length++;
        return true;
    }


    public Object getElement(int index) {
        if (index < 0 || index >= length) return null;

        if (index == 0) return getFirst();
        if (index == (length - 1)) return getLast();

        Node buf = first;

        for (int i = 0; i < index; i++) {
            if (buf == null) return null;
            buf = buf.nextNode;
        }
        if (buf != null) return buf.data;
        else return null;
    }

    public boolean setElement(int index, T element) {
        if (index < 0 || index >= length) return false;
        Node buf = first;
        if (index == 0) {
            first.data = element;
            return true;
        }
        if (index == (length - 1)) {
            last.data = element;
            return true;
        }
        for (int i = 1; i < index; i++) {
            buf = buf.nextNode;
            if (buf.nextNode == null) return false;
        }
        buf.nextNode.data = element;
        return true;
    }

    public Vector toVector() {
        Object[] array;
        Node buf = first;
        array = new Object[this.getSize()];
        for (int i = 0; i < this.getSize(); i++) {
            array[i] = buf.data;
            buf = buf.nextNode;
        }
        return new Vector(array);
    }
}
