package edu.guap.dtsalgo.coursework.collections;

public class SortedLinkedList<T extends Comparable<T>> extends LinkedList<T>{
    public void addSorted(T element) {
        if (first == null) {
            addFirstElementToEmptyList(element);
            return;
        }

        // добавление в середину (не начало и конец)
        Node buf = first;
        while (buf.getNextNode() != null && element.compareTo(buf.getNextNode().getData()) < 0) {
            buf = buf.getNextNode();
        }
        Node newNode = new Node(element, buf.getNextNode());
        if(buf.getNextNode() == null){
            last = newNode;
        }
        buf.setNextNode(newNode);
        length++;
    }

}
