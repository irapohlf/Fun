package com.sucho.fun;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author sucho
 * @since 6/12/17.
 */
public class CoinChangeProblem {

    private static Map<long[], long[]> ways = new HashMap<>();
    private static long[][] coins = null;

    private static long getWays(long n, long[] c){
        if (ways.get(c)[(int) n] != -1) {
            return ways.get(c)[(int) n];
        }

        long total = 0;
        for (int i = 0; i < c.length; i++) {
            long coin = c[i];

            if (coin > n) {
                continue;
            }


            long w = getWays(n - coin, coins[coins.length - c.length + i]);
            total += w;
        }


        ways.get(c)[(int) n] = total;
        return total;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long[] c = new long[m];
        for(int c_i=0; c_i < m; c_i++){
            c[c_i] = in.nextLong();
        }

        long[] w = new long[n+1];
        w[0] = 1L;
        for (int i = 1; i <= n; i++) {
            w[i] = -1L;
        }

        coins = new long[m][];
        for (int i = 0; i < m; i++) {
            long[] cc = new long[m-i];
            for (int j = i; j < m; j++) {
                cc[j-i] = c[j];
            }
            coins[i] = cc;
            ways.put(cc, w.clone());
        }

        long ww = getWays(n, coins[0]);
        System.out.println(ww);
    }
}
