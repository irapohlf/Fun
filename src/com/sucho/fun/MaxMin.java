package com.sucho.fun;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author sucho
 * @since 6/27/17.
 */
public class MaxMin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        Map<Integer, Integer> kVal = new TreeMap<>();
        int min = Integer.MAX_VALUE;
        int max = 0;

//        for (int i = 0; i < K; i++) {
//            Integer count = kVal.computeIfAbsent(arr[i], k -> new Integer(0));
//            count++;
//        }

        int unfairness = arr[K-1] - arr[0];

        for (int i = K; i < N; i++) {
            if ((arr[i] - arr[i-K+1]) < unfairness) {
                unfairness = arr[i] - arr[i-K+1];
            }
        }

        System.out.println(unfairness);
        sc.close();
    }
}
