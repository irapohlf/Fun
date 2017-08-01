package com.sucho.fun;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author sucho
 * @since 7/31/17.
 */
public class FindTheRunningMedian {
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    });

    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    private static void balance() {
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        } else if (maxHeap.size() - minHeap.size() == 2) {
            minHeap.add(maxHeap.poll());
        }

        if (maxHeap.size() == minHeap.size()) {
            System.out.printf("%.1f\n", (double) (maxHeap.peek() + minHeap.peek())/2.0);
        } else {
            System.out.printf("%.1f\n", (double) maxHeap.peek());
        }
    }

    private static void add(int d) {
        if (maxHeap.size() == 0) {
            maxHeap.add(d);
            System.out.printf("%.1f\n", (double) d);
            return;
        }

        if (d < maxHeap.peek()) {
            maxHeap.add(d);
        } else {
            minHeap.add(d);
        }

        balance();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            add(sc.nextInt());
        }
        sc.close();
    }
}
