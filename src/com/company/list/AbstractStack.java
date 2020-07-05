package com.company.list;

public abstract class AbstractStack<E> {

    public abstract boolean push(E element);

    public abstract E peek();

    public abstract E pop();
}
