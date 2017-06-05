package com.sucho.fun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author sucho
 * @since 6/3/17.
 */
public class JourneyToTheMoon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        long p = sc.nextLong();

        if (n == 1) {
            System.out.println(0);
            return;
        }

        Map<Integer, List<Integer>> pairMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(i);
            pairMap.put(i, list);
        }

        for (int i = 0; i < p; i++) {
            int a1 = sc.nextInt();
            int a2 = sc.nextInt();

            List<Integer> l1 = pairMap.get(a1);
            List<Integer> l2 = pairMap.get(a2);

            if (l1 != l2) {
                l1.addAll(l2);
                l1.forEach(l -> pairMap.put(l, l1));
            }
        }

        Set<List<Integer>> nationalities = new HashSet<>();
        pairMap.values().forEach(nationalities::add);

        long s = nationalities.size();
        if (s <= 1) {
            System.out.println(0);
            return;
        }

        long numPair = n * (n - 1) / 2;
        for (List<Integer> nationality : nationalities) {
            long setSize = nationality.size();
            if (setSize == 1) {
                continue;
            }
            numPair -= (setSize * (setSize-1) / 2);
        }

        System.out.println(numPair);

        sc.close();
    }
}
