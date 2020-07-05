package com.company.list;

public class LinkedListQueue<E> {
    private Node first;
    private int size;

    private LinkedListQueue() {
        this.first = null;
        this.size = 0;
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        linkedListQueue.addLast(92);
        System.out.println(linkedListQueue);
        linkedListQueue.addLast(87);
        System.out.println(linkedListQueue);
        linkedListQueue.addLast(45);
        System.out.println(linkedListQueue);
        linkedListQueue.addLast(32);
        System.out.println(linkedListQueue);
        linkedListQueue.pollFirst();
        System.out.println(linkedListQueue);
        linkedListQueue.removeFirst();
        System.out.println(linkedListQueue);

    }

    private void addLast(E eLast) {
        if (isEmpty()) {
            first = new Node(eLast);
            size++;
        } else {
            Node node = first;
            if (node == null) {
                Node newNode = new Node(eLast);
                node.next = newNode;
                size++;

            }
        }

    }

    private E pollFirst() {
        if (isEmpty()) {
            return null;
        } else {
            Node node = this.first;
            Node firstDelete = this.first;
            first = null;
            size--;
            first = node.next;
            return (E) firstDelete;
        }
    }

    private void removeFirst() {
        if (isEmpty()) {
            System.out.println("LinkedeList is empty.");
        } else {
            Node node = this.first;
            first = null;
            size--;
            first = node.next;
        }
    }

    private boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return "LinkedListQueue{" +
                "first=" + first +
                ", size=" + size +
                '}';
    }

    private class Node {
        E e;
        Node next;

        public Node(E e) {
            this.e = e;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
}
