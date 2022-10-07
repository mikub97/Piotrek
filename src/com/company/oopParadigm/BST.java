package com.company.oopParadigm;

public class BST {
    Node root=null;

    public void insert(int value){
        this.nsertRec(root,value);
    }
    private void insertRec(Node node,int value){
        if (node==null) {
            node = new Node(value);
        } else if (value<node.data) {
            insertRec(node.left,value);
        }else if (value>node.data){
            insertRec(node.right,value);
        }


    }
}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left= null;
        this.right=null;
    }


}
