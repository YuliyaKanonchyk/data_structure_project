package com.company.list;

import java.util.*;

public class MyDoubleLinkedList<E> implements Deque<E>, List<E> {

    private Node first;
    private Node last;
    private int size;

    public MyDoubleLinkedList() {
        this.size = 0;
        this.first = null;
        this.last = null;

//        ArrayList<User> users = new ArrayList<>();
//        Iterator<User> iterator = users.iterator();
//        Iterator<User> iterator2 = users.iterator();

//        Collections.sort(users, new UserComparator());
//        Collections.sort(users);
    }

    public static void main(String[] args) {
        MyDoubleLinkedList<String> myDoubleLinkedList = new MyDoubleLinkedList<>();
        myDoubleLinkedList.addFirst("4");
        myDoubleLinkedList.addFirst("3");
        myDoubleLinkedList.addFirst("2");
        myDoubleLinkedList.addFirst("1");
        myDoubleLinkedList.addLast("5");
        myDoubleLinkedList.addLast("6");
        myDoubleLinkedList.addLast("7");
        myDoubleLinkedList.add("8");
        System.out.println(myDoubleLinkedList);
//        myDoubleLinkedList.addd("9");

//        for (String s : myDoubleLinkedList) {
//            System.out.println(s);
//        }

        Iterator<String> iterator1 = myDoubleLinkedList.iterator();
        Iterator<String> iterator2 = myDoubleLinkedList.iterator();

        while (iterator1.hasNext()) {
            if (iterator1.next().equals("5")) iterator1.remove();
        }

        System.out.println(myDoubleLinkedList);


//        System.out.println(myDoubleLinkedList);
//        myDoubleLinkedList.removeLast();
//        myDoubleLinkedList.removeFirst();
//        System.out.println(myDoubleLinkedList);
//        myDoubleLinkedList.removeLast();
//        System.out.println(myDoubleLinkedList);
//        System.out.println(myDoubleLinkedList.contains("3"));
//        myDoubleLinkedList.clear();
//        System.out.println(myDoubleLinkedList.getFirst());
//        System.out.println(myDoubleLinkedList.getLast());
//        System.out.println(myDoubleLinkedList.size);
//        myDoubleLinkedList.removeStartFromHead(3);
//        System.out.println(myDoubleLinkedList);
//        System.out.println();
//        System.out.println(myDoubleLinkedList);
//        myDoubleLinkedList.set("222", 8);
//        System.out.println(myDoubleLinkedList);
//        System.out.println(myDoubleLinkedList.indexOf("1"));
//        myDoubleLinkedList.addd("444", 2);
//        System.out.println(myDoubleLinkedList);
//        System.out.println(myDoubleLinkedList.get(7));
//        System.out.println(myDoubleLinkedList.indexOf("1"));
    }

    private void rangeCheck(int index) {
        if (index > size) throw new IndexOutOfBoundsException();

    }

    public E remove(int index) {
        if (isIndexValid(index)) {
            if (isEmpty()) {
                System.out.println("LinkedeList is empty.");
            }
            if (index > size / 2) {
                removeStartFromTail(index);
            }
            removeStartFromHead(index);
        }
        return null;
    }

//    @Override
//    public int indexOf(Object o) {
//        return 0;
//    }

//    @Override
//    public int indexOf(E o) {
//        return 0;
//    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return new ListItr();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    /**
     * счетчик int i идет с size-1, так как если int i=size, то это метод removeLast()
     */
    private void removeStartFromTail(int index) {
        Node node = this.last;
        if (index == size - 1) {
            removeLast();
        }
        for (int i = size - 1; i >= index; i--) {
            if (i == index) {//e=3
                node.e = null;
                Node beforeDelete = node.prev;//2
                Node afterDelete = node.next;//4
                beforeDelete.next = afterDelete;
                afterDelete.prev = beforeDelete;
                size--;
            }
        }
    }

    /**
     * счетчик int i идет с 1, так как если int i=0, то это метод removeFirst()
     */
    private void removeStartFromHead(int index) {
        Node node = this.first;
        if (index == 0) {
            removeFirst();
        }
        for (int i = 1; i <= index; i++) {
            if (i == index) {
                node.e = null;
                Node beforeDelete = node.prev;
                Node afterDelete = node.next;
                beforeDelete.next = afterDelete;
                afterDelete.prev = beforeDelete;
                size--;
            }
        }
    }

    @Override
    public E removeFirst() {
        E removedElem = this.first.e;
        Node nextNode = first.next;
        first.e = null;
        first = nextNode;
        nextNode.prev = null;
        size--;
        return removedElem;
    }

    @Override
    public E removeLast() {
        E removeElem = this.last.e;
        Node prevNode = last.prev;

        last.e = null;
        last.prev = null;
        last = prevNode;
        prevNode.next = null;
        size--;
        return removeElem;
    }

    @Override
    public E pollFirst() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    @Override
    public E pollLast() {
        if (isEmpty()) {
            return null;
        }
        return removeLast();
    }

    @Override
    public E getFirst() {
        if (isEmpty()) {
            System.out.println("LinkedList is empty.");
            return null;
        }
        return first.e;
    }

    @Override
    public E getLast() {
        if (isEmpty()) {
            System.out.println("LinkedList is empty.");
            return null;
        }
        return last.e;
    }

    @Override
    public E element() {
        if (isEmpty()) {
            System.out.println("LinkedList is empty.");
            return null;
        }
        return first.e;
    }

    @Override
    public E peekFirst() {
        if (isEmpty()) {
            System.out.println("LinkedList is empty.");
            return null;
        }
        return first.e;
    }

    @Override
    public E peekLast() {
        if (isEmpty()) {
            System.out.println("LinkedList is empty.");
            return null;
        }
        return last.e;
    }

    @Override
    public boolean add(E e) {
        if (isEmpty()) {
            return false;
        }
        addLast(e);
        return true;
    }

    public void add(E element, int index) {
        if (isEmpty()) {
            addFirst(element);
            return;
        }
        if (isIndexValid(index)) {
            if (index > size / 2) {
                addStartFromTail(element, index);
            }
            addStartFromHead(element, index);
        }
    }

    public void addd(E element) {
        addStartFromTail(element);
    }

    @Override
    public void addFirst(E e) {
        if (isEmpty()) {
            Node node = new Node(e);
            this.last = node;
            this.first = node;
        }
        Node node = this.first;
        Node nodeAdd = new Node(e);
        this.first = nodeAdd;
        nodeAdd.next = node;
        size++;
    }

    @Override
    public void addLast(E e) {
        if (isEmpty()) {
            Node node = new Node(e);
            this.last = node;
            this.first = node;
        }
        Node node = this.last;
        Node nodeAdd = new Node(e);
        this.last = nodeAdd;
        this.last.prev = node;
        this.last.prev.next = nodeAdd;
        size++;
    }

    private void addStartFromHead(E element, int index) {
        Node node = this.first;
        Node nodeAdd = new Node(element);//2.5
        for (int i = 0; i <= index; i++) {
            if (i == index) {
                Node oldPrev = node.prev;//2
                Node oldNext = node;//3

                nodeAdd.prev = oldPrev;
                nodeAdd.next = oldNext;

                oldPrev.next = nodeAdd;
                oldNext.prev = nodeAdd;
                size++;
            }
            node = node.next;
        }
        size++;
    }

    public void addStartFromTail(E element, int index) {
        Node nodeL = last;
        Node nodeAdd = new Node(element);//8.5
        for (int i = size; i >= index; i--) {
            if (i == index) {
                Node old = nodeL; // 8
                Node oldNext = nodeL.next; // 9

                nodeAdd.next = oldNext;
                nodeAdd.prev = old;

                oldNext.prev = nodeAdd;
                old.next = nodeAdd;
                size++;
            }
            nodeL = nodeL.prev;
        }
    }

    public void addStartFromTail(E element) {
        Node nodeAdd = new Node(element);
        Node oldNode = last;
        last = nodeAdd;
        oldNode.next = last;
        last.prev = oldNode;
        size++;
    }

    @Override
    public void clear() {
        boolean flag = true;
        while (flag) {
            if (isEmpty()) {
                flag = false;
            }
            if (first.next == null) {
                flag = false;
            }
            first.e = null;
            Node next = first.next;
            first.next = null;
            first = next;
            size--;
        }
    }

    @Override
    public boolean contains(Object o) {
        Node node = this.first;
        if (isEmpty()) {
            return false;
        } else {
            for (int i = 0; i < size - 1; i++) {
                if (node.e.toString().equals(o.toString())) {
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }

    private void addStartFromHead(E element) {
        Node nodeAdd = new Node(element);
        Node oldNode = first;
        first = nodeAdd;
        first.next = oldNode;
        oldNode.prev = nodeAdd;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E peek() {
        return element();
    }

    @Override
    public boolean offerFirst(E e) {
        Node node = this.first;
        Node nodeAdd = new Node(e);
        this.first = nodeAdd;
        nodeAdd.next = node;
        size++;
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        Node node = this.last;
        Node nodeAdd = new Node(e);
        this.last = nodeAdd;
        nodeAdd.prev = node;
        last.next = nodeAdd;
        size++;
        return true;
    }

    @Override
    public boolean offer(E e) {
        Node node = this.last;
        Node nodeAdd = new Node(e);
        this.last = nodeAdd;
        nodeAdd.prev = node;
        last.next = nodeAdd;
        size++;
        return true;
    }

    @Override
    public E remove() {
        return removeFirst();
    }

    @Override
    public E poll() {
        return removeFirst();
    }

    @Override
    public void push(E e) {
        addFirst(e);
    }

    @Override
    public E pop() {
        return removeFirst();
    }

    @Override
    public boolean remove(Object o) {
        E element = (E) o;
        Node node = this.first;
        for (int i = 0; i < size; i++) {
            if (node.e == element) {
                if (i == 0) {
                    removeFirst();
                    return true;
                }
                if (i == size - 1) {
                    removeLast();
                    return true;
                }
                remove(i);
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public Object[] toArray() {
        if (!isEmpty()) {
            Node node = first;
            Object[] array = new Object[size];
            for (int i = 0; i < size; i++) {
                array[i] = node.e;
                node = node.next;
            }
            return array;
        }
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyItr();
    }

    @Override
    public Iterator<E> descendingIterator() {
        return null;
    }

    public E get(int index) {
        if (isIndexValid(index)) {
            if (index >= size / 2) {
                return getTail(index);
            }
        }
        return getHead(index);
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    private E getTail(int index) {
        Node node = last;
        if (isEmpty()) {
            return null;
        } else {
            for (int i = size; i >= index; i--) {
                if (i == index) {
                    return node.e;
                }
                node = node.prev;
            }
        }
        return (E) node.prev;
    }

    private E getHead(int index) {
        Node node = first;
        if (isEmpty()) {
            return null;
        } else {
            for (int i = 0; i <= index; i++) {
                if (i == index) {
                    return node.e;
                }
                node = node.next;
            }
        }
        return (E) node.next;
    }

    public E set(E element, int index) {
        if (isIndexValid(index)) {
            if (isEmpty()) {
                addStartFromTail(element);
                if (index > size / 2) {
                    return setTail(element, index);
                }
            }
        }
        return setHead(element, index);
    }

    private E setTail(E element, int index) {
        Node nodeSet = this.last;
        E oldElem;
        for (int i = size; i >= index; i--) {
            if (i == index) {
                oldElem = nodeSet.e;
                nodeSet.e = element;
                return oldElem;
            }
            nodeSet = nodeSet.prev;
        }
        return null;
    }

    private E setHead(E element, int index) {
        Node nodeSet = this.first;
        E oldElem;
        for (int i = 0; i <= index; i++) {
            if (i == index) {
                oldElem = nodeSet.e;
                nodeSet.e = element;
                return oldElem;
            }
            nodeSet = nodeSet.next;
        }
        return null;
    }

    public boolean ifContain(E element) {
        Node node = this.first;
        if (isEmpty()) {
            return false;
        } else {
            for (int i = 0; i < size - 1; i++) {
                if (node.e == element) {
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }

    public int indexOf(Object element) {
        Node node = this.first;
        if (isEmpty()) {
            return -1;
        } else {
            for (int i = 0; i < size - 1; i++) {
                if (node.e == element) {
                    return i;
                }
                node = node.next;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private boolean isIndexValid(int index) {
        return index <= size;
    }

    @Override
    public String toString() {
        return "MyDoubleLinkedList{" +
                "first=" + first +
                ", size=" + size +
                '}';
    }

    class ListItr extends MyItr implements ListIterator<E> {
        int curretnIndex = 0;
        Node currentNode = first;

        /*boolean hasPreviuos()
Этот метод проверяет, есть ли в коллекции предыдущий элемент.
Если есть, то метод возвращает true, если нет – false.*/
        @Override
        public boolean hasPrevious() {
            if (currentNode.prev != null) {
                return true;
            }
            return false;
        }

        /*Object previous()
       Этот метод возвращает предыдущий элемент коллекции.
       Если элемент не обнаружен, то метод “бросает” NoSuchElementException.*/
        @Override
        public E previous() throws NoSuchElementException {
            if (currentNode.prev != null) {
                return currentNode.prev.e;
            }
            return null;
        }


        /*Object next()
        Этот метод возвращает следующий элемент коллекции.
        Если элемент не обнаружен, то метод “бросает
        ”NoSuchElementException.*/
        @Override
        public E next() throws NoSuchElementException {
            curretnIndex++;
            return super.next();
        }


        /*int nextIndex()
       Этот метод возвращает индекс следующего элемента.
       Если в коллекции остутствует следующий элемент –
       возвращается размер коллекции.*/
        @Override
        public int nextIndex() {
            if (currentNode.next != null) return curretnIndex++;
            return size;
        }

        /*int previousIndex()
      Этот метод возвращает индекс предыдущего элемента.
      Если в коллекции остутствует предыдущий элемент –
      возвращает значение -1.*/
        @Override
        public int previousIndex() {
            if (currentNode.prev != null) curretnIndex--;
            return -1;
        }

        /*void set(Object obj)
      Этот метод присваивает текущему элементу значение,
      которое передано в качестве параметра метода.
      */
        @Override
        public void set(E element) {
            currentNode.e = element;
        }

        /*void add(Object obj)
Этот метод добавляет элемент в коллекцию на следующую
позицию после элемента, полученного с помощью метода next().*/
        @Override
        public void add(E element) {
            MyDoubleLinkedList.this.add(element, curretnIndex++);
        }
    }

    private class Node {
        E e;
        Node next;
        Node prev;

        public Node(E e) {
            this.e = e;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "e=" + e +
                    " next=" + next +
                    '}';
        }
    }

    private class MyItr implements Iterator<E> {
        Node currentNode = first;

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public E next() {
            if (currentNode != null) {
                E e = currentNode.e;
                currentNode = currentNode.next;
                return e;
            }
            return null;
        }

        @Override
        public void remove() {
            if (isEmpty()) throw new NullPointerException();
            if (currentNode.prev == null) {
                removeFirst();
            } else if (currentNode.next == null) {
                removeLast();
            } else {
                Node prev = currentNode.prev;
                Node next = currentNode.next;

                currentNode.e = null;
                currentNode.next = null;
                currentNode.prev = null;

                prev.next = next;
                next.prev = prev;
                currentNode = currentNode.next;
                size--;
            }
        }
    }
}
