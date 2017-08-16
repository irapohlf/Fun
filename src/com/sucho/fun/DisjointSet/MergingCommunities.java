package com.sucho.fun.DisjointSet;

import java.util.Scanner;

/**
 * @author sucho
 * @since 8/15/17.
 */
public class MergingCommunities {

    /*
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int Q = sc.nextInt();

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int n = 1; n <= N; n++) {
            Set<Integer> set = new HashSet<>();
            set.add(n);
            map.put(n, set);
        }

        for (int q = 0; q < Q; q++) {
            String com = sc.next();
            switch (com) {
                case "M":
                    Integer p1 = sc.nextInt();
                    Integer p2 = sc.nextInt();
                    Set<Integer> merged = map.get(p1);
                    Set<Integer> target = map.get(p2);
                    if (merged != target) {
                        if (merged.size() < target.size()) {
                            Set<Integer> tmp = merged;
                            merged = target;
                            target = tmp;
                        }
                        merged.addAll(target);
                        Set<Integer> finalMerged = merged;
                        target.forEach(p -> map.put(p, finalMerged));
                    }
                    break;
                case "Q":
                    Integer p = sc.nextInt();
                    System.out.println(map.get(p).size());
                    break;
            }
        }
        sc.close();
    } */

    // path compressed version
    static class Node {
        int size;
        int parent;
        Node() {
            this.size = 1;
            this.parent = -1;
        }
    }

    static int find(Node[] nodes, int from) {
        // O(logN) version
        /*
        if (nodes[from].parent == -1) {
            return from;
        }
        return find(nodes, nodes[from].parent);
        */

        // Path Compressed version - flatten the graph.
        if (nodes[from].parent != -1) {
            nodes[from].parent = find(nodes, nodes[from].parent);
        } else {
            return from;
        }
        return nodes[from].parent;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int Q = sc.nextInt();

        Node[] nodes = new Node[N];
        for (int n = 0; n < N; n++) {
            nodes[n] = new Node();
        }

        for (int q = 0; q < Q; q++) {
            String com = sc.next();
            switch (com) {
                case "M":
                    int p1 = sc.nextInt() - 1;
                    int p2 = sc.nextInt() - 1;
                    int parent1 = find(nodes, p1);
                    int parent2 = find(nodes, p2);
                    if (nodes[parent1].size > nodes[parent2].size) {
                        int tmp = parent1;
                        parent1 = parent2;
                        parent2 = tmp;
                    }

                    if (parent1 != parent2) {
                        nodes[parent1].parent = parent2;
                        nodes[parent2].size += nodes[parent1].size;
                    }
                    break;
                case "Q":
                    int p = find(nodes, sc.nextInt() - 1);
                    System.out.println(nodes[p].size);
                    break;
            }
        }
        sc.close();
    }
}
