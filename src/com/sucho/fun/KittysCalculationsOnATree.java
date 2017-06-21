package com.sucho.fun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author sucho
 * @since 6/15/17.
 */
public class KittysCalculationsOnATree {

    private static boolean[] visited;

    private static void getPath(List<Integer> path, boolean[][] edges, int from, int to) {
        visited[from] = true;
        path.add(from);

        if (visited[to]) {
            return;
        }

        for (int i = 1; i < edges.length; i++) {
            if (!edges[from][i] || visited[i]) {
                continue;
            }

            getPath(path, edges, i, to);
            if (visited[to]) {
                return;
            }
            path.remove(path.size() - 1);
        }
    }

    private static int getDist(List<Integer> path1, List<Integer> path2) {
        int i = 0;
        for (; i < path1.size() && i < path2.size(); i++) {
            if (!path1.get(i).equals(path2.get(i))) {
                break;
            }
        }

        return path1.size() + path2.size() - i * 2;
    }

    private static int dist(boolean[][] edges, int n1, int n2) {
        List<Integer> path1 = new ArrayList<>();
        visited = new boolean[edges.length+1];
        visited[1] = true;
        getPath(path1, edges, 1, n1);
        List<Integer> path2 = new ArrayList<>();
        visited = new boolean[edges.length+1];
        visited[1] = true;
        getPath(path2, edges, 1, n2);

        return getDist(path1, path2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        boolean[][] edges = new boolean[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                edges[i][j] = false;
            }
        }

        for (int i = 0; i < n-1; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            edges[n1][n2] = true;
        }

        for (int i = 0; i < q; i++) {
            int k = sc.nextInt();
            int[] nodeSet = new int[k];
            for (int j = 0; j < k; j++) {
                nodeSet[j] = sc.nextInt();
            }

            int total = 0;
            Arrays.sort(nodeSet);
            Map<Integer, List<Integer>> paths = new HashMap<>();
            for (int n1 = 0; n1 < nodeSet.length; n1++) {
                List<Integer> path = new ArrayList<>();
                visited = new boolean[edges.length+1];
                getPath(path, edges, 1, nodeSet[n1]);
                paths.put(nodeSet[n1], path);
            }

            for (int n1 = 0; n1 < nodeSet.length - 1; n1++) {
                for (int n2 = n1 + 1; n2 < nodeSet.length; n2++) {
                    //int distance = dist(edges, nodeSet[n1], nodeSet[n2]);
                    total += ((nodeSet[n1] * nodeSet[n2] * getDist(paths.get(nodeSet[n1]), paths.get(nodeSet[n2]))) % (1000000007));
                }
            }
            System.out.println(total);
        }

        sc.close();
    }
}
