package com.sucho.fun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author sucho
 * @since 6/2/17.
 */
public class Test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        HashMap<Integer, ArrayList<Integer>> cityMap = new HashMap<>();
        int n = scan.nextInt();
        int m = scan.nextInt();
        int libraryCost = scan.nextInt();
        int roadCost = scan.nextInt();
        for (int i = 1; i <= n; i++) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(i);
            cityMap.put(i, list);
        }

        for (int a1 = 0; a1 < m; a1++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            ArrayList<Integer> list1 = cityMap.get(x);
            ArrayList<Integer> list2 = cityMap.get(y);
            if (list1 != list2) {
                list1.addAll(list2);
                list2.forEach(i -> cityMap.put(i, list1));
            }
        }
        if (libraryCost < roadCost)
            System.out.println((long) n * libraryCost);
        else {
            long cost = 0;
            for (ArrayList<Integer> list : cityMap.values()) {
                int size = list.size();
                if (size > 0) {
                    cost += libraryCost;
                    cost += (size - 1) * roadCost;
                    //list.removeIf(i -> true);
                    list.clear();
                }
            }
            System.out.println(cost);
        }
    }
}
