package com.sucho.fun.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author sucho
 * @since 8/14/17.
 */
public class MinimumAverageWaitingTime {
    private static class Pizza {
        long t;
        long l;

        Pizza(long t, long l) {
            this.t = t;
            this.l = l;
        }
    }

    private static void waiting(Pizza[] orders) {
        long ct = orders[0].t;
        long total = 0L;
        int index = 0;
        int N = orders.length;

        PriorityQueue<Pizza> queue = new PriorityQueue<>((p1, p2) -> (int) (p1.l-p2.l));
        for (index = 0; index < N && orders[index].t <= ct; index++) { // init the queue
            queue.add(orders[index]);
        }

        while (queue.size() > 0) {
            Pizza p = queue.poll();
            ct += p.l;
            total += (ct - p.t);

            if (index < N && orders[index].t <= ct) { // if orders exist before now
                for (; index < N && orders[index].t <= ct; index++) {
                    queue.add(orders[index]);
                }
            }

            if (index < N && queue.size() == 0) {
                ct = orders[index].t;
                for (; index < N && orders[index].t <= ct; index++) {
                    queue.add(orders[index]);
                }
            }
        }

        System.out.println(total/N);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Pizza[] orders = new Pizza[N];

        for (int n = 0; n < N; n++) {
            long t = sc.nextLong();
            long l = sc.nextLong();
            orders[n] = new Pizza(t, l);
        }

        Arrays.sort(orders, (p1, p2) -> p1.t == p2.t ? (int) (p1.l - p2.l) : (int) (p1.t - p2.t));
        waiting(orders);
        sc.close();
    }
}
