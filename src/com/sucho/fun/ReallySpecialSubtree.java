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
 * @since 6/8/17.
 */
public class ReallySpecialSubtree {

    static class Pair {
        Integer L;
        Integer R;

        Pair(final Integer L, final Integer R) {
            this.L = L;
            this.R = R;
        }
    }

    private static Pair formKey(final int s, final int t) {
        if (s > t) {
            return new Pair(t, s);
        }
        return new Pair(s, t);
    }
/*
4 6
1 2 5
1 3 3
4 1 6
2 4 7
3 2 4
3 4 5
 */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        Map<Pair, Integer> E = new HashMap<>();
        for (int i = 0; i < M; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            int w = sc.nextInt();

            if (s == t) {
                continue;
            }

            Pair key = formKey(s, t);
            Integer weight = E.get(key);
            if (weight == null || w < weight) {
                E.put(key, w);
            }
        }

        List<Map.Entry<Pair, Integer>> edgeList = new ArrayList<>(E.entrySet());
        edgeList.sort((o1, o2) -> {
            if (!o1.getValue().equals(o2.getValue())) {
                return o1.getValue() - o2.getValue();
            } else {
                return o1.getKey().L + o1.getKey().R + o1.getValue() -
                        (o2.getKey().L + o2.getKey().R + o2.getValue());
            }
        });

        Map<Integer, Set<Integer>> vMap = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            Set<Integer> V = new HashSet<>();
            V.add(i);
            vMap.put(i, V);
        }
        Integer totalWeight = 0;
        for (Map.Entry<Pair, Integer> edge : edgeList) {
            Set<Integer> lSet = vMap.get(edge.getKey().L);
            Set<Integer> rSet = vMap.get(edge.getKey().R);
            if (lSet == rSet) {
                continue;
            }

            totalWeight += edge.getValue();
            lSet.addAll(rSet);
            if (lSet.size() == N) {
                break;
            }
            for (int i : lSet) {
                vMap.put(i, lSet);
            }
        }

        System.out.println(totalWeight);
        sc.close();
    }
}
