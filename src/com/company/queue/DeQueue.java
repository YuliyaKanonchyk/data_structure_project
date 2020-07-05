package com.company.queue;

public interface DeQueue<E> {
    void addFirst(E element);
    void addLast(E element);
    E getFirst();
    E getLast();
    E pollFirst();
    E pollLast();
    void removeLast();
    void removeFirst();
}
