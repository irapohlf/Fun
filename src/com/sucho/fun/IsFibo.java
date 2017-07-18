package com.sucho.fun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author sucho
 * @since 6/29/17.
 */
public class IsFibo {
    private static List<Long> cache = new ArrayList<>();

    private static long updateCache(long N) {
        int lastIndex = cache.size() - 1;
        long biggest = cache.get(lastIndex);

        while (biggest < N) {
            biggest = cache.get(lastIndex) + cache.get(lastIndex-1);
            lastIndex++;
            cache.add(biggest);
        }

        return biggest;
    }

    private static boolean isFibo(long N) {
        long biggest = cache.get(cache.size() - 1);

        if (N > biggest) {
            biggest = updateCache(N);
            return biggest == N;
        }

        return Collections.binarySearch(cache, N) >= 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        cache.add(0L); // fibo(0) = 0;
        cache.add(1L); // fibo(1) = 1;
        cache.add(1L); // fibo(2) = 2;

        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            long N = sc.nextLong();
            if (N < 0) {
                System.out.println("IsNotFibo");
            } else {
                System.out.println(isFibo(N) ? "IsFibo" : "IsNotFibo");
            }
        }
        sc.close();
    }
}
