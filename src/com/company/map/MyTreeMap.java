package com.company.map;

import java.util.Map;

public class MyTreeMap<K, V> {

    private Entry<K, V> root = null;
    private int size;


    public static void main(String[] args) {
        MyTreeMap<String, Integer> myTreeMap = new MyTreeMap<>();
        myTreeMap.put("1", 1);
        myTreeMap.put("2", 2);
        myTreeMap.put("3", 3);
        myTreeMap.put("4", 4);
        myTreeMap.put("5", 5);
        myTreeMap.put("6", 6);
    }

    public void put(K key, V value) {
//        Entry<K, V> current = root;
//        if (isKeyNotNull(key)) {
            if (root == null) {
                this.root = new Entry<>(key, value);
                size++;
//                return root.value;
//            }
//            while (true) {
//                if (key.compareTo(current.key)<0){
//                   if ( current.left == null){
//                       current.left = new Entry<>(key, value);
//                       size++;
//                       return current.left.value;
//                   } else {
//                       current = current.left;
//                   }
//                } else if (key.compareTo(current.key)>0){
//                    if ( current.right == null){
//                        current.right = new Entry<>(key, value);
//                        size++;
//                        return current.right.value;
//                    } else {
//                        current = current.right;
//                    }
//                }
            }
//        }
//        return null;
    }

    private boolean isKeyNotNull(K key) {
        return key != null;
    }

    static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }


    }
}
