package com.company.list;

import java.util.Arrays;

public class MyArrayList<E> {

    private final static int DEFAULT_CAPACITY = 10;
    private Object[] values;
    private int size;

    public MyArrayList() {
        this.values = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int initialCapacity) {
        this.values = new Object[initialCapacity];
    }

    public static void main(String[] args) {
//        MyArrayList<Integer> myArrayList = new MyArrayList<>();
//        long before = System.currentTimeMillis();
//        for (int i = 0; i < 9000; i++) {
//            myArrayList.add(i);
//        }
//        long after = System.currentTimeMillis();
//        long l = after - before;


//        System.out.println(l);
//        MyArrayList<Integer> integerMyArrayList = new MyArrayList<>();
//
//        integerMyArrayList.add(1);
//        integerMyArrayList.add(2);
//        integerMyArrayList.add(3);
//        integerMyArrayList.add(4);
//        integerMyArrayList.add(5);
//        integerMyArrayList.add(6);
//        integerMyArrayList.add(7);
//        integerMyArrayList.add(8);
////        System.out.println(integerMyArrayList);
////        System.out.println(integerMyArrayList.delete(4));
//        System.out.println(integerMyArrayList);
//
//        MyArrayList.Sublist sublist = integerMyArrayList.new Sublist();
//        sublist.subListCreation(2,5);
        MyArrayList<String> myArrayList = new MyArrayList<>();
        for (int i = 0;i<85;i++){
            myArrayList.add(String.format("Hello %d", i));
        }
        System.out.println(myArrayList);
        for (int i = 12;i<56;i++){
            myArrayList.delete(i);
        }
        System.out.println();
        System.out.println(myArrayList);
        myArrayList.trimToSize();
        System.out.println();
        System.out.println(myArrayList);
//        MyArrayList myArrayList1 = myArrayList.subList(10, 20);
//        System.out.println(myArrayList1);
    }

    public boolean add(Object element) {
        if (element == null) return false;
        checkArraySize();
        this.values[size++] = element;
        return true;
    }

    public boolean contain(Object element) {
        return ifArrayContainsElement(element);
    }

    public boolean set(int index, Object element) {
        if (index < values.length && element != null) {
            values[index] = element;
            return true;
        }
        return false;
    }

    public boolean delete(Object element) {
        int ind = 0;
        if (deleteToElement(element, ind)) {
            moveElement(ind);
            return true;
        }
        return false;
    }

    public boolean delete(int index) {
        if (deleteToIndex(index)) {
            size--;
            moveElement(index);
        }
        return false;
    }

    public E get(int index) {
        return getValue(index);
    }

    public int indexOfElement(Object element) {
        return indexSearching(element);
    }

    public int getSize() {
        int counter = 0;
        for (Object o : values) {
            if (o == null) {
                counter++;
            }
        }
        return counter;
    }

    public void subListCreation(int fIndex, int lIndex) {
        new SubList(lIndex - fIndex + 1, Arrays.copyOfRange(values, fIndex, lIndex));
    }

    private int indexSearching(Object element) {
        int i;
        for (i = 0; i < size; i++) {
            if (values[i].equals(element)) {
                return i;
            }
        }
        return i;
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "values=" + Arrays.toString(values) +
                ", size=" + size +
                ", length=" + values.length +
                '}';
    }

    private E getValue(int index) {
        return (E) values[index];
    }

    private boolean deleteToIndex(int index) {
        if (values.length > index) {
            values[index] = null;
            return true;
        }
        return false;
    }

    private void moveElement(int index) {
        if (size - index >= 0) System.arraycopy(values, index + 1, values, index, size - index);
    }

    private boolean deleteToElement(Object element, int ind) {
        if (element == null) return false;
        for (Object o : values) {
            if (o.equals(element)) {
                values[ind] = null;
                size--;
            }
            ind++;
        }
        return false;
    }

    private boolean ifArrayContainsElement(Object element) {
        for (Object o : values) {
            if (o.equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void trimToSize(){
        this.values = Arrays.copyOf(this.values, size);
    }

    //grow()
    private void checkArraySize() {
        if (values.length == size) {
            values = Arrays.copyOf(values, size + 6);
        }
    }

    private class SubList extends MyArrayList{
        private int size;
        private Object[] array;

        public SubList(int size, Object[] array) {
            this.size = size;
            this.array = array;
        }

        public void add(E element, int index) {
            array[index] = element;
        }

        public E set(E element, int index) {
            E oldElement = (E) array[index];
            array[index] = element;
            return oldElement;
        }

        public E get(int index) {
            return (E) array[index];
        }

        @Override
        public String toString() {
            return "SubList{" +
                    ", array=" + Arrays.toString(array) +
                    '}';
        }
    }
}