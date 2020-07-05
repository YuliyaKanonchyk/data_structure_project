package com.company.queue;

//pop - возвращает эелемент из вершины стека и удаляет его
//peek - возвращает елемент из стека, но не удаляет его
//push - добавляет новый елемент на вершину стека

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * @param <E>
 */
public class MyStack<E>
//        extends MyStackAbstract
{

    private final int MIN_CAPACITY = 5;
    private Object[] objects;
    private int size;
    private int lastElem;

    public MyStack() {
        this.objects = new Object[MIN_CAPACITY];
        this.size = 0;
        this.lastElem = -1;
    }

    public MyStack(int initialCapacity) {
        this.objects = new Object[initialCapacity];
        this.size = 0;
        this.lastElem = -1;
    }

    public static void main(String[] args) {
//        MyStack<String> myStack = new MyStack<>();
//        myStack.push("1");
//        myStack.push("2");
//        myStack.push("3");
//        myStack.push("4");
//        myStack.push("5");
//        System.out.println(myStack);
//        System.out.println(myStack.pop());
//        System.out.println(myStack.pop());
//        System.out.println(myStack);
//        myStack.push("8");
//        System.out.println(myStack);
//        System.out.println(myStack.isFull());
//        myStack.push("9");
//        System.out.println(myStack);
//        System.out.println(myStack.isFull());
//        myStack.push("9");
        Stack stack = new Stack();
        stack.pop();

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return objects.length == size;
    }

    public boolean contain(E e) {
        return indexOf(e) >= 0;
    }

    public int indexOf(E element) {
        int ind;
        for (ind = 0; ind <= size; ind++) {
            if (element.equals(objects[ind])) {
                return ind;
            }
        }
        return -1;
    }

    public void push(E element) {
        this.objects[size++] = element;
        this.lastElem = size - 1;
    }

    public E peek() {
        return (E) objects[lastElem];
    }

    public E pop() {
        E oldElem = peek();
        objects[lastElem--] = null;
        size--;
        return oldElem;
    }

    @Override
    public String toString() {
        return "MyStack{" +
                "objects=" + Arrays.toString(objects) +
                ", size=" + size +
                '}';
    }
}
