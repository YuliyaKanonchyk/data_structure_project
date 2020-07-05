package com.company.list;


//Е remove() - удаляет элемент из головы очереди, возвращая его. Инициирует исключение NoSuchElementException, если очередь пуста.
//Е peek() - возвращает элемент из головы очереди. Возвращает null, если очередь пуста. Элемент не удаляется.
//Е роll() - возвращает элемент из головы очереди и удаляет его. Возвращает null, если очередь пуста.


public class MyLinkedList<E> {

    private Node first;
    private Node last;
    private int size;

    public MyLinkedList() {
        this.size = 0;
        this.first = null;
        this.last = null;
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.addFirst(56);
        myLinkedList.addFirst(565);
        myLinkedList.addFirst(784);
        myLinkedList.addFirst(78);
        myLinkedList.addFirst(734);
        myLinkedList.addLast(11);
        myLinkedList.addLast(22);
        System.out.println(myLinkedList);
        myLinkedList.removeLast();
        System.out.println(myLinkedList);
        myLinkedList.removeFirst();
        System.out.println(myLinkedList);
//        System.out.println();
//        myLinkedList.add(5, 0);
//        System.out.println(myLinkedList.set(5, 1000));
//        System.out.println(myLinkedList);
    }

    public void forEach() {
        Node node = first;
        while (node != null) {
            System.out.println(node);
            node = node.next;
        }
    }

    public E get(int ind){
        Node node = this.first;
        if (isEmpty()){
            return null;
        } else {
            for (int i = 0; i < size; i++) {
                if (i == ind){
                    return node.e;
                }
                node = node.next;
            }
        }
        return null;
    }

    public E set(int ind, E element) {
        Node node = this.first;
        E oldNode;
        if (isEmpty()) {
            addFirst(element);
        } else {
            for (int i = 0; i < size; i++) {
                if (i == ind) {
                    oldNode = node.e;
                    node.e = element;
                    return oldNode;
                }
                node = node.next;
            }
        }
        return null;
    }

    public void add(E el) {
        addLast(el);
    }

    public void add(int ind, E elemtnt) {
        Node node = first;
        Node nodeAdd = new Node(elemtnt);
        if (isEmpty()) {
            addFirst(elemtnt);
        } else {
            for (int i = 0; i < ind - 1; i++) {
                node = node.next;
            }
            Node oldNode = node.next;
            node.next = nodeAdd;
            nodeAdd.next = oldNode;
            size++;
        }
    }

    public void addFirst(E eFirst) {
        Node newNode = new Node(eFirst);
        if (isEmpty()) {
            this.first = newNode;
            this.last = newNode;
            size++;
        } else {
            Node oldNode = this.first;
            this.first = newNode;
            newNode.next = oldNode;
            size++;
        }
    }

    public void addLast(E eLast) {
        Node newNode = new Node(eLast);
        if (isEmpty()) {
            this.first = newNode;
            this.last = newNode;
            size++;
        } else {
            last.next = newNode;
            last = newNode;
            size++;
        }

    }

    public E pollLast() {
        Node node = first;
        while (node != null) {
            System.out.println(node + " - node");
            node = node.next;
            if (node.next == null) {
                node.next = null;
                node = null;
                size--;
            }
        }
        return null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E pollFirst() {
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

    public E peekFirst() {
        Node nodeFirst;
        if (isEmpty()) {
            return null;
        } else {
            nodeFirst = this.first;
            System.out.print("First node - ");
        }
        return (E) nodeFirst;
    }

    public E peekLast() {
        Node nodeLast = null;
        if (isEmpty()) {
            return null;
        } else {
            if (nodeLast != null) {
                nodeLast = nodeLast.next;
            }
        }
        return (E) nodeLast;
    }

    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("LinkedList is empty.");
        } else {
            first.e = null;
            Node next = first.next;
            first.next = null;
            first = next;
            size--;
        }
    }

    public void removeLast() {
        Node node = this.first;
        if (isEmpty()) {
            System.out.println("LinkedeList is empty.");
        } else {
            for (int i = 0; i < size - 1; i++) {
                if (node.next.next == null){
                    node.next.e = null;
                    node.next = null;
                    last = node;
                    size--;
                }
                node = node.next;
            }
        }
    }

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "first=" + first +
                ", last=" + last +
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
            return "Node{" +
                    "e=" + e +
                    ", next=" + next +
                    '}';
        }
    }
}
