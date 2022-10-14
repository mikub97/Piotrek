package com.company.bst;

public class BinarySearchTree <T extends Comparable<T>> {
    class Node<T> {
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
    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(T data){
        Node n = new Node(data);
        if (root==null) root = n;
        else{
            Node tmp = root;
            Node parent;
            while (true) { // will break after insertion
                parent = tmp;
                if (data.compareTo((T) tmp.data)<0) { // left
                    tmp = tmp.left;
                    if (tmp == null) { // if its the leaf
                        parent.left = n;
                        break;
                    }
                } else {    //right
                    tmp = tmp.right;
                    if (tmp==null){
                        parent.right= n;
                        break;
                    }
                }
            }
        }
    }

    public T startFindMin(){
        return findMin(root);
    }
    private T findMin(Node node){
        if(node.left == null){
            return (T) node.data;
        }else{
            return (T)findMin(node.left);
        }
    }
    public T startFindMax(){
        return findMin(root);
    }
    private T findMax(Node node){
        if(node.right == null){
            return (T) node.data;
        }else{
            return (T)findMin(node.right);
        }
    }


}