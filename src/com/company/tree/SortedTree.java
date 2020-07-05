package com.company.tree;

import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SortedTree<E extends Comparable<E>> {

    private Node root;
    private int size;

    public SortedTree() {
        this.size = 0;
    }

    public static void main(String[] args) {


        SortedTree<Integer> stringSortedTree = new SortedTree<>();
        Iterator<Integer> iterator = stringSortedTree.iterator();

        stringSortedTree.add(20);
        stringSortedTree.add(7);
        stringSortedTree.add(35);
        stringSortedTree.add(4);
        stringSortedTree.add(9);
        stringSortedTree.add(6);
        stringSortedTree.add(31);
        stringSortedTree.add(40);
        stringSortedTree.add(28);
        stringSortedTree.add(38);
        stringSortedTree.add(39);
        stringSortedTree.add(52);
        System.out.println(stringSortedTree);
        stringSortedTree.remove(40);
        System.out.println(stringSortedTree);

    }

    public Iterator<E> iterator() {
        return new MyTreeIter();
    }

    public void add(E v) {
        Node currentNode = root;
        Node newNode = new Node(v);
        if (root == null && root != v) {
            root = new Node(v);
            size++;
            return;
        }
        while (true) {
            if (v.compareTo(currentNode.value) < 0) {
                if (currentNode.left == null) {
                    newNode.parent = currentNode;
                    currentNode.left = newNode;
                    this.size++;
                    break;
                } else {
                    currentNode = currentNode.left;
                }
            } else if (v.compareTo(currentNode.value) > 0) {
                if (currentNode.right == null) {
                    newNode.parent = currentNode;
                    currentNode.right = newNode;
                    this.size++;
                    break;
                } else {
                    currentNode = currentNode.right;
                }
            } else {
                break;
            }
        }
    }

    public boolean contains(Object element) {
        Node currentNode = root;
        E elem = (E) element;
        while (true) {
            if (currentNode.value.equals(elem)) return true;
            if (elem.compareTo(currentNode.value) < 0) {
                if (currentNode.left == null) {
                    break;
                } else {
                    currentNode = currentNode.left;
                }
            } else if (elem.compareTo(currentNode.value) > 0) {
                if (currentNode.right == null) {
                    break;
                } else {
                    currentNode = currentNode.right;
                }
            } else {
                break;
            }
        }
        return false;
    }

    public boolean remove(E element) {
        Node currentNode = root;
        while (true) {
            if (currentNode.value.equals(element)) {
                return generalRemove(currentNode);
            }
            if (element.compareTo(currentNode.value) < 0) {
                if (currentNode.left == null) {
                    break;
                } else {
                    currentNode = currentNode.left;// здесь currentNode меняет свое знаечени на след. Ноду
                }
            } else if (element.compareTo(currentNode.value) > 0) {
                if (currentNode.right == null) {
                    break;
                } else {
                    currentNode = currentNode.right;// здесь currentNode меняет свое знаечени на след. Ноду
                }
            } else {
                break;
            }
        }
        return false;
    }

    private boolean generalRemove(Node currentNode) {
        if (currentNode.right == null && currentNode.left == null) {
            removeHasNoChild(currentNode);
            return true;
        } else if (currentNode.right == null) {
            removeHasChild(currentNode, false);
        } else if (currentNode.left == null) {
            removeHasChild(currentNode, true);
        } else {
            removeHasChilds(currentNode);
        }
        return false;
    }

    private void removeHasChilds(Node nodeToRemove) {//40
            Node parent = nodeToRemove.parent;
            Node rightChildNodeToReplace = nodeToRemove.right;
            Node childToReplace = nodeToRemove.left;
            if (childToReplace.left == null) {

                nodeToRemove.value = null;
                nodeToRemove.right = null;
                nodeToRemove.left = null;/

                parent.right = childToReplace;
                childToReplace.parent = parent;
                childToReplace.right = rightChildNodeToReplace;
                rightChildNodeToReplace.parent = childToReplace;

                size--;
            } else {
                return;
            }
        }


    private void removeHasChild(Node currentNode, boolean isRight) {
        Node child;
        Node parent = currentNode.parent;
        currentNode.value = null;
        if (isRight) {
            child = currentNode.right;
            parent.right = child;
            child.parent = parent;
            size--;
        } else {
            child = currentNode.left;
            parent.left = child;
            child.parent = parent;
            size--;
        }

    }


    private void removeHasNoChild(Node currentNode) {
        if (currentNode.parent.left.value.equals(currentNode.value)) {
            currentNode.value = null;
            currentNode.parent.left = null;
            size--;
        } else {
            currentNode.value = null;
            currentNode.parent.right = null;
            size--;
        }
    }

    private boolean isEmpty() {
        return root == null;
    }

    @Override
    public String toString() {
        return "SortedTree{" +
                "root=" + root +
                ", size=" + size +
                '}';
    }

    private class Node {
        Node parent;
        E value;
        Node right;
        Node left;

        Node(E value) {
            this.value = value;
            this.right = null;
            this.left = null;
        }

        @Override
        public String toString() {
            return "\t" + value +
                    "[" + "right=" + right +
                    " left=" + left + "]" + "\t";
        }

    }

    private class MyTreeIter implements Iterator<E> {
        Node treeNode = root;

        @Override
        public boolean hasNext() {

            HashMap<String, String> stringStringHashMap  = new HashMap<>();
            stringStringHashMap.put("Simon", "Hello");
//            return treeNode != null;
            return treeNode.left != null || treeNode.right != null;
        }

        //Возвращает значение следующей Ноды? Да
        @Override
        public E next() {
            if (treeNode == null) throw new NoSuchElementException();
            if (treeNode.left != null) {

            }
            if (treeNode.right != null) {

            }
            treeNode = treeNode.left;
            return treeNode.value;
        }

        @Override
        public void remove() {
            generalRemove(treeNode);
        }
    }
}

