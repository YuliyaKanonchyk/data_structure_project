package com.company.map;

import java.util.*;

public class MyHashMap<K, V> {

    private final int INITIALCAPACITY = 16;
    private Node<K, V>[] table;
    private int size;

    public MyHashMap() {
        this.table = new Node[INITIALCAPACITY];
        this.size = 0;
    }

    public MyHashMap(int size) {
        this.table = new Node[size];
        this.size = 0;
    }

    public static void main(String[] args) {

        MyHashMap<String, Integer> keyIntegerMap = new MyHashMap<>();
        keyIntegerMap.put("1", 1);
        keyIntegerMap.put("2", 2);
        keyIntegerMap.put("3", 3);
        keyIntegerMap.put("4", 4);
        Set<Node> nodes = keyIntegerMap.entrySet();
        for (Node node : nodes) {
            if (node.key.equals("2")){
                node.value = 22;
            }
        }
        System.out.println(nodes);
        System.out.println(keyIntegerMap);
    }

    public Set<Node> entrySet() {
        Set<Node> entryArrayList = new HashSet<>();
        for (int i = 0; i <= size; i++) {
            Node<K, V> currentNode = table[i];
            if (table[i] != null){
                entryArrayList.add(currentNode);
            }
        }
        return entryArrayList;
    }

    public boolean put(K key, V value) {
        if (!isKeyNull(key)) {
            int hash = key.hashCode() % table.length;
            //Если hash - не занят, то происходит вставка эелемнта
            if (table[hash] == null) {
                table[hash] = new Node<>(hash, key, value, null);
                size++;
                return true;
                //Если hash - занят, то проверяем, если равны key по ссылке и по значению, то заменяем value
            } else {
                Node<K, V> kvNode = table[hash];
                if (kvNode.hash == hash && kvNode.key == key || key.equals(key)) {
                    kvNode.value = value;
                    size++;
                    return true;
                    //Если hash - занят, то проверяем есть ли след.элемент с тем же hash в цепочке, если отсуствует - вставляем след.элемент в цепочку
                } else {
                    if (kvNode.nextNode == null) {
                        kvNode.nextNode = new Node<>(hash, key, value, null);
                        size++;
                        return true;
                    else {
                        if (kvNode.nextNode != null) {
                            Node<K, V> kvNode1 = kvNode.nextNode;
                            while (kvNode1 != null) {
                                if (kvNode1.key == key && kvNode1.hash == hash || key.equals(key)) {
                                    kvNode1 = new Node<>(hash, key, value, null);
                                    size++;
                                    return true;
                                }
                                kvNode1 = kvNode1.nextNode;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public V get(K key) {
        int hash = key.hashCode() % table.length;
        Node<K, V> kvNode = table[hash];
        if (kvNode.key == key && kvNode.hash == hash || key.equals(key)) {
            return kvNode.value;
        } else {
            if (kvNode.nextNode != null) {
                Node<K, V> kvNode1 = kvNode.nextNode;
                while (kvNode1 != null) {
                    if (kvNode1.key == key && kvNode1.hash == hash || key.equals(key)) {
                        return kvNode1.value;
                    }
                    kvNode1 = kvNode1.nextNode;
                }
            }
        }
        return null;
    }

    public boolean remove(K key) {
        if (!isKeyNull(key) && !isTableEmpty()) {
            int hash = key.hashCode() % table.length;
            Node<K, V> kvNode = table[hash];
            Node<K, V> parent;
            if (kvNode.hash == table[hash].hash) {

                if (kvNode.nextNode == null) {
                    if (kvNode.hash == hash && kvNode.key == key || key.equals(key)) {

                        kvNode.nextNode = kvNode.nextNode.nextNode;

                        kvNode.value = null;
                        table[hash] = null;

                        size--;
                        return true;
                    }
                } else {
                    if (kvNode.nextNode != null) {
                        if (kvNode.hash == hash && kvNode.key == key || key.equals(key)) {
                            parent = kvNode;
                            kvNode.nextNode = kvNode.nextNode.nextNode;

                            kvNode.value = null;
                            kvNode.key = null;
                            size--;
                            return true;
                        }
                        Node<K, V> kvNode1 = kvNode.nextNode;
                        while (kvNode1 != null) {
                            if (kvNode1.hash == hash && kvNode1.key == key || key.equals(key)) {

                                kvNode.nextNode = kvNode1.nextNode;

                                kvNode1.value = null;
                                size--;
                                return true;
                            }
                        }

                        size--;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean isKeyNull(K key) {
        if (key == null) return true;
        return false;
    }

    private boolean isTableEmpty() {
        if (size == 0) return true;
        return false;
    }

    @Override
    public String toString() {
        return "MyHashMap{" +
                "table=" + Arrays.toString(table) +
                ", size=" + size +
                '}';
    }

    private static class Node<K, V> implements Map.Entry<K, V> {
        private int hash;
        private K key;
        private V value;
        private Node<K, V> nextNode;

        public Node(int hash, K key, V value, Node<K, V> nextNode) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.nextNode = nextNode;
        }

        public Node() {
            this.hash = 0;
            this.key = null;
            this.value = null;
            this.nextNode = null;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V old = this.value;
            this.value = value;
            return old;
        }

        @Override
        public String toString() {
            return "Bucket{" +
                    "hash=" + hash +
                    ", key=" + key +
                    ", value=" + value +
                    ", nextBucket=" + nextNode +
                    '}';
        }
    }

    private class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
