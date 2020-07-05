package com.company.list;

public abstract class AbstractArray<E> {

   public abstract boolean add(E element);

    public abstract boolean contain(E element);

    public abstract boolean set(int index, E element);

    public abstract boolean delete(E element);

    public abstract  boolean delete(int index);

    public abstract E get(int index);

    public abstract int indexOfElement(E element);

    public abstract int getSize();

    public abstract void subListCreation(int sPos, int lPos);
}
