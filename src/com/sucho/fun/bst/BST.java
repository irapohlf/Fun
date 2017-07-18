package com.sucho.fun.bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sucho
 * @since 7/11/17.
 */
public class BST {
    final Node root;

    public BST(Node root) {
        this.root = root;
    }

    List<Node> inOrder(List<Node> list, Node root) {
        if (root.left != null) {
            inOrder(list, root.left);
        }
        list.add(root);
        if (root.right != null) {
            inOrder(list, root.right);
        }
        return list;
    }

    Node balanced(List<Node> ordered, int s, int e) {
        Node root = null;
        if (e <= s) {
            return root;
        }
        int middle = (e + s)/2;
        root = ordered.get(middle);
        root.left = root.right = null;

        if (middle <= 0 || middle >= ordered.size()) {
            return root;
        } else {
            root.left = balanced(ordered, s, middle);
            root.right = balanced(ordered, middle + 1, e);
            return root;
        }
    }

    private void print() {
        if (this.root == null) {
            return;
        }

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(this.root);

        while (queue.size() > 0) {
            LinkedList<Node> newQueue = new LinkedList<>();
            for (Node n : queue) {
                System.out.printf("%d ", n.value);
                if (n.left != null) {
                    newQueue.add(n.left);
                }
                if (n.right != null) {
                    newQueue.add(n.right);
                }
            }
            System.out.println();
            queue = newQueue;
        }
    }

    private static void run(Node root) {
        BST bst = new BST(root);
        bst.print();

        List<Node> ordered = new ArrayList<>();
        bst.inOrder(ordered, bst.root);
        for (Node n : ordered) {
            System.out.printf("%d,", n.value);
        }
        System.out.println();

        BST balBST = new BST(bst.balanced(ordered, 0, ordered.size()));
        balBST.print();
    }

    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(2, new Node(1), null);
        root.right = new Node(7, new Node(5), new Node(8));

        run(root);

        root = new Node(1, null,
                new Node(2, null,
                        new Node(3, null,
                                new Node(4, null,
                                        new Node(5)))));
        run(root);

        root = new Node(3,
                new Node(2,
                        new Node(1),
                        null),
                new Node(4,
                        null,
                        new Node(5,
                                null,
                                new Node(6,
                                        null,
                                        new Node(7,
                                                null,
                                                new Node(8))))));
        run(root);
    }
}
