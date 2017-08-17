package com.sucho.fun.GraphTheory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author sucho
 * @since 8/16/17.
 */
public class EvenTree {
    static class Node {
        int id;
        int nNode;
        List<Node> children;
        Node(int id) {
            this.id = id;
            this.nNode = 0;
            children = new ArrayList<>();
        }
    }

    private static Node buildRootedTree(boolean[][] edges) {
        Node[] nodes = new Node[edges.length];
        boolean[] isVistied = new boolean[edges.length];
        for (int i = 0; i < edges.length; i++) {
            nodes[i] = new Node(i+1);
            isVistied[i] = false;
        }

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(nodes[0]);
        isVistied[0] = true;

        while (queue.size() > 0) {
            Node n = queue.pollFirst();
            int from = n.id - 1;
            List<Node> children = n.children;
            for (int i = 0; i < edges.length; i++) {
                if (!edges[from][i] || isVistied[i]) {
                    continue;
                }
                children.add(nodes[i]);
                queue.add(nodes[i]);
                isVistied[i] = true;
            }
        }

        return nodes[0];
    }

    private static int countNode(Node root) {
        if (root.nNode == 0) {
            if (root.children.size() == 0) {
                root.nNode = 1;
            } else {
                root.nNode = 1;
                for (Node n : root.children) {
                    root.nNode += countNode(n);
                }
            }
        }

        return root.nNode;
    }

    private static int countEdgesBeDeleted(Node root) {
        int count = 0;

        for (Node n : root.children) {
            if (n.nNode % 2 == 0) {
                count++;
            }
            count += countEdgesBeDeleted(n);
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // N should be even, which I don't test but believe.
        int M = sc.nextInt();

        boolean[][] edges = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                edges[i][j] = false;
            }
        }

        for (int m = 0; m < M; m++) {
            int from = sc.nextInt() - 1;
            int to = sc.nextInt() - 1;
            edges[from][to] = edges[to][from] = true;
        }

        Node root = buildRootedTree(edges);
        countNode(root);
        System.out.println(countEdgesBeDeleted(root));

        sc.close();
    }
}
