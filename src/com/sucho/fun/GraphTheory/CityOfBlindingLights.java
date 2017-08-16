package com.sucho.fun.GraphTheory;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author sucho
 * @since 8/3/17.
 */
public class CityOfBlindingLights {

    private static int[][] distances;

    private static void dijkstra(final int[][] edge, final int x, final int y) {
        int N = edge.length;

        class Node {
            int index;
            int distance;
            Node(int index, int distance) {
                this.index = index;
                this.distance = distance;
            }
        }

        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(n -> n.distance));
        int newNode = x;
        do {
            for (int j = 0; j < N; j++) {
                if (edge[newNode][j] == -1) {
                    continue;
                }

                if (distances[x][j] > -1) { // j is already visited, and this should be the min. Dist.
                    continue;
                }

                minHeap.add(new Node(j, distances[x][newNode] + edge[newNode][j]));
            }

            if (minHeap.size() == 0) {
                break;
            }

            newNode = -1;
            Node n;
            do {
                n = minHeap.poll();
            } while (n != null && distances[x][n.index] > -1);

            if (n == null) {
                break;
            }

            distances[x][n.index] = n.distance;
            newNode = n.index;
        } while(newNode != -1);

        System.out.println(distances[x][y]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] edges = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                edges[i][j] = -1;
            }
        }

        for (int m = 0; m < M; m++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            edges[x-1][y-1] = sc.nextInt();
        }

        distances = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                distances[i][j] = -1;
            }
            distances[i][i] = 0;
        }

        int Q = sc.nextInt();
        for (int q = 0; q < Q; q++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            if (distances[x-1][y-1] > -1) {
                System.out.println(distances[x-1][y-1]);
            } else {
                dijkstra(edges, x - 1, y - 1);
            }
        }
        sc.close();
    }
}
