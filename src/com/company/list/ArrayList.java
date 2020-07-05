package com.company.list;

public interface ArrayList<E> {
    boolean add(E element);

    boolean contain(E element);

    boolean set(int index, E element);

    boolean delete(E element);

    boolean delete(int index);

    E get(int index);

    int indexOfElement(E element);

    int getSize();

    void subListCreation(int sPos, int lPos);

}
