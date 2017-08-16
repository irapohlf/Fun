package com.sucho.fun.stack;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author sucho
 * @since 8/10/17.
 */
public class MaximumElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((q1, q2)->q2.compareTo(q1));
//        PriorityQueue<Integer> queue = new PriorityQueue<>(Integer::compareTo);
//        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.naturalOrder());
//        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
//        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2.compareTo(o1);
//            }
//        });
        for (int i = 0; i < N; i++) {
            int com = sc.nextInt();
            switch (com) {
                case 1:
                    Integer val = new Integer(sc.nextInt());
                    stack.push(val);
                    queue.add(val);
                    break;
                case 2:
                    if (stack.size() > 0) {
                        val = stack.pop();
                        queue.remove(val);
                    }
                    break;
                case 3:
                    if (queue.size() > 0) {
                        System.out.println(queue.peek());
                    }
                    break;
            }
        }
        sc.close();
    }
}
