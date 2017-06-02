package com.sucho.fun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author sucho
 * @since 6/1/17.
 */
public class RoadsAndLibraries {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            long n = in.nextLong();
            long m = in.nextLong();
            long x = in.nextLong();
            long y = in.nextLong();

            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(i, list);
            }
            for (int a1 = 0; a1 < m; a1++) {
                int city_1 = in.nextInt();
                int city_2 = in.nextInt();

                List<Integer> list1 = map.get(city_1);
                List<Integer> list2 = map.get(city_2);
                if (list1 != list2) {
                    list1.addAll(list2);
                    list2.forEach(l -> map.put(l, list1));
                }
            }

            if (y >= x || m == 0) {
                System.out.println(n * x);
                continue;
            }

            long cost = 0;
            for (List<Integer> list : map.values()) {
                int size = list.size();
                if (size == 0) {
                    continue;
                }

                cost += x + ((long) size - 1L) * y;
                list.clear();
            }

            System.out.println(cost);
        }

        in.close();
    }
}
