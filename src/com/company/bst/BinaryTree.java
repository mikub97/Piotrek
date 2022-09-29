package com.company.bst;

public class BinaryTree <T extends Comparable<T>> {
    static class Node<T> {
        //instance variable of Node class
        public T data;
        public Node left;
        public Node right;

        //constructor
        public Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // instance variable of binary tree class
    public Node root;

    // constructor for initialise the root to null BY DEFAULT
    public BinaryTree() {
        this.root = null;
    }


}