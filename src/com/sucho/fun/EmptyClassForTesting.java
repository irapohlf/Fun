package com.sucho.fun;

/**
 * @author sucho
 * @since 6/28/17.
 */
public class EmptyClassForTesting {
    public static void main(String[] args) {
        String test = "abcdedfhijklmnopqrstuvwxyz";
        System.out.println(test.hashCode());

        int big = 0x10000000;
        System.out.println((int) (big * big));
    }
}
