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

    // 1D linked list reversing
    private static Node rev(Node r) {
        Node p = null;
        Node c = r;

        while (c != null) {
            Node n = c.right;
            c.right = p;
            p = c;
            c = n;
        }

        return p;
    }

    private static void print(Node r) {
        while (r != null) {
            System.out.println(r.val);
            r = r.right;
        }
    }

    public static void main(String[] args) {
        Node A = new Node("A", new Node ("B", new Node("C", null, null), null), null);
        print(A);
        print(rev(A));
    }
}
