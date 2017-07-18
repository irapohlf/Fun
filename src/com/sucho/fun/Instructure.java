package com.sucho.fun;

import java.util.Scanner;

/**
 * @author sucho
 * @since 6/26/17.
 */
public class Instructure {
    static Scanner sc;

    private static double calUnit(double first) {
        double second = Double.parseDouble(sc.next());

        char operand = sc.next().charAt(0);
        switch (operand) {
            case '+':
                return first + second;
            case '-':
                return first - second;
            case '*':
                return first * second;
            case '/':
                return first/second;
            default:
                return 0.0;
        }
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        double first = Double.parseDouble(sc.next());
        while (sc.hasNext()) {
            first = calUnit(first);
        }
        System.out.println((int) first);
        sc.close();
    }
}
