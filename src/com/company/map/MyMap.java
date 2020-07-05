package com.company.map;

public class MyMap<K, V> {
    private Object[] arrayKey;
    private Object[] arrayValue;
    private int size;
    private int defaultSize = 16;

    public static void main(String[] args) {
        MyMap<String, String> stringStringMyMap = new MyMap<>();
        stringStringMyMap.put("1", "Simon");
        stringStringMyMap.put("2", "Andrew");
        stringStringMyMap.put("3", "Victor");
        System.out.println(stringStringMyMap.get("2"));
    }

    public MyMap() {
        this.arrayKey = new Object[defaultSize];
        this.arrayValue = new Object[defaultSize];
        this.size = 0;
    }

    public MyMap(int size) {
        this.arrayKey = new Object[size];
        this.arrayValue = new Object[size];
        this.size = 0;
    }


    //O(1)
    public boolean put(K key, V value) {
        arrayKey[size] = key;
        arrayValue[size] = value;
        size++;
        return true;
    }

    //O(N)
    public V get(K key) {
        int i = 0;
        for (Object k : arrayKey) {
            if (k.equals(key)) {
                return (V) arrayValue[i];
            }
            i++;
        }
        return null;
    }
}
