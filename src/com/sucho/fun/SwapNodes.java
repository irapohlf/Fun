package com.sucho.fun;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author sucho
 * @since 6/15/17.
 */
public class SwapNodes {
    private static class Node {
        int data;
        Node left;
        Node right;
        int depth;

        Node(int data, int depth) {
            this.data = data;
            this.depth = depth;
            this.left = null;
            this.right = null;
        }
    }

    private static void swap(Node root, int depth) {
        LinkedList<Node> nodes = new LinkedList<Node>();
        nodes.add(root);

        while (nodes.get(0).depth != depth) {
            Node n = nodes.removeFirst();
            if (n.left != null) {
                nodes.add(n.left);
            }
            if (n.right != null) {
                nodes.add(n.right);
            }
        }

        for (Node n : nodes) {
            Node tmp = n.left;
            n.left = n.right;
            n.right = tmp;
        }
    }

    private static void inOrder(Node root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.printf("%d ", root.data);
        inOrder(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Node root = new Node(1, 1);
        LinkedList<Node> nodes = new LinkedList<Node>();
        nodes.add(root);
        int maxDepth = 0;
        for (int i = 0; i < N; i++) {
            int left = sc.nextInt();
            int right = sc.nextInt();

            Node n = nodes.removeFirst();
            if (n.depth > maxDepth) {
                maxDepth = n.depth;
            }

            if (left != -1) {
                n.left = new Node(left, n.depth+1);
                nodes.add(n.left);
            }
            if (right != -1) {
                n.right = new Node(right, n.depth+1);
                nodes.add(n.right);
            }
        }

        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int t = sc.nextInt();
            for (int j = 1; j * t < maxDepth; j++) {
                swap(root, j * t);
            }
            inOrder(root);
            System.out.println();
        }

        sc.close();
    }
}
