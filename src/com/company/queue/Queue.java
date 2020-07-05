package com.company.queue;

public interface Queue<E> {
    void add(E element);
    void remove(E element);
    E poll();
}
