package com.company.queue;

//Методы интерфейса Deque:
//void addFirst(Е obj)  - добавляет obj в голову двунаправленной очереди. Возбуждает исключение IllegalStateException, если в очереди ограниченной емкости нет места.
//void addLast(Е obj) - добавляет obj в хвост двунаправленной очереди. Возбуждает исключение IllegalStateException, если в очереди ограниченной емкости нет места.
//Е getFirst() - возвращает первый элемент двунаправленной очереди. Объект из очереди не удаляется. В случае пустой двунаправленной очереди возбуждает исключение NoSuchElementException.
//Е getLast() - возвращает последний элемент двунаправленной очереди. Объект из очереди не удаляется. В случае пустой двунаправленной очереди возбуждает исключения NoSuchElementException.
//Е pollFirst() - возвращает элемент, находящийся в голове двунаправленной очереди, одновременно удаляя его из очереди. Возвращает null, если очередь пуста.
//Е pollLast() - возвращает элемент, находящийся в хвосте двунаправленной очереди, одновременно удаляя его из очереди. Возвращает null, если очередь пуста.
//Е removeLast() - возвращает элемент, находящийся в конце двунаправленной очереди, удаляя его в процессе. Возбуждает исключение NoSuchElementException, если очередь пуста.
//Е removeFirst() - возвращает элемент, находящийся в голове двунаправленной очереди, одновременно удаляя его из очереди. Возбуждает исключение NoSuchElementException, если очередь пуста.

import com.company.queue.DeQueue;

public class MyDeQueue<E> implements DeQueue<E> {
    private final int MIN_CAPACITY = 5;
    private Object[] objects;
    private int size;
    private int head;
    private int tail;

    public MyDeQueue() {
        this.objects = new Object[MIN_CAPACITY];
        this.size = 0;
        this.head = 0;
        this.tail = 5;
    }

    public MyDeQueue(int initialCapacity) {
        this.objects = new Object[initialCapacity];
        this.size = 0;
        this.head = 0;
        this.tail = 5;
    }

    @Override
    public void addFirst(E element) {
        int i = head;
        if (++i != tail) {
            objects[head++] = element;
            size++;
        }
    }

    @Override
    public void addLast(E element) {
        int o = tail;
        if (head != ++o) {
            objects[tail++] = element;
            size++;
        }
    }

    @Override
    public E getFirst() {
        return (E) objects[head];
    }

    @Override
    public E getLast() {
        return (E) objects[tail];
    }

    @Override
    public E pollFirst() {
        if (!dequeueIsEmpty()) {
            objects[head] = null;
            size--;
            return (E) objects[head];
        }
        return null;
    }

    @Override
    public E pollLast() {
        if (!dequeueIsEmpty()) {
            objects[tail] = null;
            size--;
            return (E) objects[tail];
        }
        return null;
    }

    @Override
    public void removeLast() {
        if (!dequeueIsEmpty()) {
            objects[tail] = null;
            size--;
        }
    }

    @Override
    public void removeFirst() {
        if (!dequeueIsEmpty()) {
            objects[head] = null;
            size--;
        }
    }

    private boolean dequeueIsEmpty() {
        for (Object o : objects) {
            if (o.equals(null)) {
                return true;
            }

        }
        return false;
    }
}
