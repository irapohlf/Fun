package com.sucho.fun.queue;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author sucho
 * @since 10/23/18.
 *
 * Implement a Queue using Two Stacks.
 */
public class QueueUsingTwoStacks {
    private Stack<Integer> adder = new Stack<>();
    private Stack<Integer> remover = new Stack<>();

    private void enqueue(int value) {
        adder.push(value);
    }

    private void adderToRemover() {
        if (remover.empty()) {
            while (!adder.empty()) {
                remover.push(adder.pop());
            }
        }
    }

    private void dequeue() {
        adderToRemover();
        remover.pop();
    }

    private void print() {
        adderToRemover();
        System.out.println(remover.peek());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        QueueUsingTwoStacks queue = new QueueUsingTwoStacks();
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();

            switch (type) {
                case 1:
                    queue.enqueue(sc.nextInt());
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    queue.print();
                    break;
            }
        }
    }
}
