package com.sucho.fun;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author sucho
 * @since 10/22/18.
 *
 * You will be given two arrays of integers and asked to determine all integers that satisfy the following two conditions:
 *
 * The elements of the first array are all factors of the integer being considered
 * The integer being considered is a factor of all elements of the second array
 * These numbers are referred to as being between the two arrays. You must determine how many such numbers exist.
 *
 * For example, given the arrays  and , there are two numbers between them:  and . , ,  and  for the first value. Similarly, ,  and , .
 *
 * Function Description
 *
 * Complete the getTotalX function in the editor below. It should return the number of integers that are between the sets.
 *
 * getTotalX has the following parameter(s):
 *
 * a: an array of integers
 * b: an array of integers
 * Input Format
 *
 * The first line contains two space-separated integers,  and , the number of elements in array  and the number of elements in array .
 * The second line contains  distinct space-separated integers describing  where .
 * The third line contains  distinct space-separated integers describing  where .
 *
 * Constraints
 *
 * Output Format
 *
 * Print the number of integers that are considered to be between  and .
 *
 * Sample Input
 *
 * 2 3
 * 2 4
 * 16 32 96
 * Sample Output
 *
 * 3
 * Explanation
 *
 * 2 and 4 divide evenly into 4, 8, 12 and 16.
 * 4, 8 and 16 divide evenly into 16, 32, 96.
 *
 * 4, 8 and 16 are the only three numbers for which each element of a is a factor and each is a factor of all elements of b.
 */
public class BetweenTwoSets {
    private static int gcd(int a, int b) {
        if (a == b) {
            return a;
        }

        return (a > b)? gcd(b, a-b) : gcd(a, b-a);
    }

    private static int gcd(int[] array) {
        if (array.length == 1) {
            return array[0];
        }

        int[] newArray = new int[array.length/2 + ((array.length % 2) == 0? 0 : 1)];

        for (int i = 0; i+1 < array.length; i += 2) {
            newArray[i/2] = gcd(array[i], array[i+1]);
        }

        if (array.length % 2 == 1) {
            newArray[newArray.length-1] = array[array.length-1];
        }

        return gcd(newArray);
    }

    private static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    private static int lcm(int[] array) {
        if (array.length == 1) {
            return array[0];
        }

        int[] newArray = new int[array.length/2 + ((array.length % 2) == 0? 0 : 1)];

        for (int i = 0; i+1 < array.length; i += 2) {
            newArray[i/2] = lcm(array[i], array[i+1]);
        }

        if (array.length % 2 == 1) {
            newArray[newArray.length-1] = array[array.length-1];
        }

        return lcm(newArray);
    }

    private static int getTotalX(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);

        int start = lcm(a);
        int max = gcd(b);

        if (max % start != 0) {
            return 0;
        }

        int ret = 1;
        Map<Integer, Integer> factors = getFactors(max/start);
        for (Integer value : factors.values()) {
            ret *= (value + 1);
        }
        return ret;
    }

    private static Map<Integer, Integer> getFactors(int n) {
        Map<Integer, Integer> factors = new HashMap<>();

        if (n == 1) {
            return factors;
        }

        int factor = 2;
        while (n > 1) {
            if (n % factor == 0) {
                if (factors.containsKey(factor)) {
                    Integer value = factors.get(factor);
                    factors.put(factor, ++value);
                } else {
                    factors.put(factor, 1);
                }
                n /= factor;
                continue;
            }
            factor++;
        }
        return factors;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] a = new int[n];
        int[] b = new int[m];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }

        int total = getTotalX(a, b);
        System.out.println("total = " + total);

//        System.out.println(gcd(new int[]{2, 4}));
//        System.out.println(gcd(new int[]{4,6,8}));
//        System.out.println(gcd(new int[]{123,78,18}));
//
//        System.out.println(lcm(new int[]{2, 4}));
//        System.out.println(lcm(new int[]{4,6,8}));
//        System.out.println(lcm(new int[]{123,78,18}));
    }
}
