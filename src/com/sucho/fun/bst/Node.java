package com.sucho.fun.bst;

/**
 * @author sucho
 * @since 7/11/17.
 */
public class Node {
    Node left, right;
    int value;
    public Node(int value) {
        this(value, null, null);
    }

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
