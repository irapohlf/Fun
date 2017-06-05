package com.sucho.fun;

/**
 * @author sucho
 * @since 6/4/17.
 *
 * Let's make this algorithm simple. All the vertices has name as 0, 1, 2, 3..., and there is no leaping.
 */
public class Dijkstra {
    private int numVertices;
    private int[][] distance;

    public Dijkstra(final int numVertices, final int[][] distance) {
        this.numVertices = numVertices;
        this.distance = distance;
    }

    private int minIndex(final boolean[] visited, final int[] shortestDistance, final int numVisited) {
        int[] vIndex = new int[numVisited];
        int[] nVIndex = new int[this.numVertices - numVisited];

        for (int i = 0, v = 0, nv = 0; i < this.numVertices; i++) {
            if (visited[i]) {
                vIndex[v++] = i;
            } else {
                nVIndex[nv++] = i;
            }
        }

        int minIndex = -1;
        int minDist = Integer.MAX_VALUE;
        for (int v = 0; v < numVisited; v++) {
            int from = vIndex[v];
            for (int nv = 0; nv < this.numVertices - numVisited; nv++) {
                int to = nVIndex[nv];

                if (this.distance[from][to] == Integer.MAX_VALUE) {
                    continue;
                }

                if ((this.distance[from][to] + shortestDistance[from]) < minDist) {
                    minDist = this.distance[from][to] + shortestDistance[from];
                    minIndex = to;
                }
            }
        }

        if (minIndex != -1) {
            shortestDistance[minIndex] = minDist;
        }
        return minIndex;
    }

    public int shortestPath(final int from, final int to) throws Exception {
        boolean[] visited = new boolean[this.numVertices];
        int[] shortestDistance = new int[this.numVertices];
        int numVisited = 0;

        // initializing
        for (int i = 0; i < this.numVertices; i++) {
            visited[i] = false;
            shortestDistance[i] = Integer.MAX_VALUE;
        }

        visited[from] = true;
        shortestDistance[from] = 0;
        numVisited = 1;

        while (numVisited != this.numVertices) {
            int minIndex = minIndex(visited, shortestDistance, numVisited);

            if (minIndex == -1) { // the graph is disconnected
                System.out.println("the graph has to be connected");
                break;
            }

            visited[minIndex] = true;
            numVisited++;

            if (minIndex == to) {
                return shortestDistance[to];
            }
        }

        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) throws Exception {
        int numVertices = 6;
        int[][] distance = {
                {0, 1, 3, Integer.MAX_VALUE, 4, 100},
                {1, 0, 5, 15, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {3, 5, 0, Integer.MAX_VALUE, Integer.MAX_VALUE, 7},
                {Integer.MAX_VALUE, 15, Integer.MAX_VALUE, 0, 1, 1},
                {4, Integer.MAX_VALUE, Integer.MAX_VALUE, 1, 0, Integer.MAX_VALUE},
                {100, Integer.MAX_VALUE, 7, 1, Integer.MAX_VALUE, 0}
        };

        System.out.println(new Dijkstra(numVertices, distance).shortestPath(0, 1));
        System.out.println(new Dijkstra(numVertices, distance).shortestPath(0, 2));
        System.out.println(new Dijkstra(numVertices, distance).shortestPath(0, 3));
        System.out.println(new Dijkstra(numVertices, distance).shortestPath(0, 4));
        System.out.println(new Dijkstra(numVertices, distance).shortestPath(0, 5));
        System.out.println(new Dijkstra(numVertices, distance).shortestPath(1, 5));
        System.out.println(new Dijkstra(numVertices, distance).shortestPath(4, 5));

        int[][] distance2 = {
                {0, 1, 3, Integer.MAX_VALUE, 4, Integer.MAX_VALUE},
                {1, 0, 5, 15, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {3, 5, 0, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, 15, Integer.MAX_VALUE, 0, 1, Integer.MAX_VALUE},
                {4, Integer.MAX_VALUE, Integer.MAX_VALUE, 1, 0, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0}
        };

        System.out.println(new Dijkstra(numVertices, distance2).shortestPath(0, 4));
        System.out.println(new Dijkstra(numVertices, distance2).shortestPath(0, 5));
    }
}
