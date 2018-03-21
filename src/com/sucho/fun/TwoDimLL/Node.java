package com.sucho.fun.TwoDimLL;


/**
 * @author sucho
 * @since 2/6/18.
 */
public class Node {
    public String val;
    public Node right;
    public Node down;

    public Node(final String val) {
        this(val, null, null);
    }

    public Node(final String val, final Node right, final Node down) {
        this.val = val;
        this.right = right;
        this.down = down;
    }
}
