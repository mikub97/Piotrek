package com.company.oopParadigm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BSTTest {
    @Test
    public void test(){
        BST bst = new BST();
        bst.insert(5);
        bst.insert(7);
        bst.insert(10);
        bst.insert(8);
        bst.insert(4);
        System.out.println("STOP");
    }

}