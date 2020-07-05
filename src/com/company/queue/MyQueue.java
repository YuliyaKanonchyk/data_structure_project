package com.company.queue;

//Методы интерфейса Queue:
//Е element() - возвращает элемент из головы очереди. Элемент нe удаляется. Если очередь пуста, инициируется исключение NoSuchElementException.
//Е remove() - удаляет элемент из головы очереди, возвращая его. Инициирует исключение NoSuchElementException, если очередь пуста.
//Е peek() - возвращает элемент из головы очереди. Возвращает null, если очередь пуста. Элемент не удаляется.
//Е роll() - возвращает элемент из головы очереди и удаляет его. Возвращает null, если очередь пуста.
//boolean offer(Е оbj) - пытается добавить оbj в очередь. Возвращает true, если оbj добавлен, и false в противном случае.

import java.util.Arrays;

public class MyQueue<E> implements Queue<E> {

    private final int MIN_CAPACITY = 5;
    private Object[] objects;
    private int size;
    private int head;

    public MyQueue() {
        this.size = 0;
        this.head = 0;
        this.objects = new Object[MIN_CAPACITY];
    }

    public MyQueue(int size) {
        this.objects = new Object[size];
        this.size = 0;
        this.head = 0;
    }

    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.add(5);
        myQueue.add(6);
        myQueue.add(7);
        System.out.println(myQueue);
        myQueue.remove(Integer.valueOf(6));
        System.out.println(myQueue);
    }

    @Override
    public void add(E element) {
        if (!queueIsFull()) {
            objects[size++] = element;
        }
    }

    @Override
    public void remove(E element) {
        if (!queueIsEmpty()) {
        objects[head] = null;
        size--;
        trimToSize();
        }
    }

    @Override
    public E poll() {
        if (!queueIsEmpty()) {
            objects[head + 1] = null;
            size--;
            return (E) objects[head + 1];
        }
        return null;
    }


    private boolean queueIsEmpty() {
            if (size == 0) {
                return true;
            }
        return false;
    }

    private boolean queueIsFull() {
            if (size == objects.length-1) {
                return true;
            }
        return false;
    }

    private void trimToSize() {
        this.objects = Arrays.copyOfRange(this.objects, head + 1, MIN_CAPACITY);
    }

    @Override
    public String toString() {
        return "MyQueue{" +
                "MIN_CAPACITY=" + MIN_CAPACITY +
                ", objects=" + Arrays.toString(objects) +
                ", size=" + size +
                ", head=" + head +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyQueue<?> myQueue = (MyQueue<?>) o;
        return Arrays.equals(objects, myQueue.objects);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(objects);
    }
}
