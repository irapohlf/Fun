package com.sucho.fun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author sucho
 * @since 6/15/17.
 */
public class KittysCalculationsOnATree {

    static class Node {
        Node other;
        int data;
        Node(int data) {
            this.data = data;
        }
    }

    private static Node[] nodes;

    private static long getDist(List<Node> path1, List<Node> path2) {
        long size1 = path1.size();
        long size2 = path2.size();
        long i = 0;
        for (; i < size1 && i < size2; i++) {
            if (path1.get((int) (size1 - i - 1)).data != path2.get((int) (size2 - i - 1)).data) {
                break;
            }
        }

        return size1 + size2 - i * 2;
    }

    private static List<Node> getReversePath(Node n) {
        List<Node> path = new ArrayList<>();
        do {
            path.add(n);
            n = n.other;
        } while (n != null);
        return path;
    }

    private static Map<Integer, List<Node>> getPaths(int[] nodeSet) {
        Map<Integer, List<Node>> paths = new HashMap<>();
        if (nodes.length > 1) {
            for (int n = 0; n < nodeSet.length; n++) {
                if (!paths.containsKey(nodeSet[n])) {
                    paths.put(nodeSet[n], getReversePath(nodes[nodeSet[n]]));
                }
            }
        }
        return paths;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        boolean[][] edges = new boolean[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                edges[i][j] = false;
            }
        }

        nodes = new Node[n+1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < n-1; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            if (nodes[n2].other != null) { // n2 already has parent
                if (nodes[n1].other != null) {
                    throw new Exception("This is not a tree.");
                }
                nodes[n1].other = nodes[n2];
            } else {
                nodes[n2].other = nodes[n1];
            }
        }

        for (int i = 0; i < q; i++) {
            int k = sc.nextInt();
            int[] nodeSet = new int[k];
            for (int j = 0; j < k; j++) {
                nodeSet[j] = sc.nextInt();
            }

            long total = 0;
            Map<Integer, List<Node>> paths = getPaths(nodeSet);

            for (int n1 = 0; n1 < nodeSet.length - 1; n1++) {
                for (int n2 = n1 + 1; n2 < nodeSet.length; n2++) {
                    total += (((long) nodeSet[n1] * (long) nodeSet[n2] * getDist(paths.get(nodeSet[n1]), paths.get(nodeSet[n2]))) % (1000000007L));
                }
            }
            System.out.println(total);
        }

        sc.close();
    }
}
