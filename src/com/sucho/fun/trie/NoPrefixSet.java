package com.sucho.fun.trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author sucho
 * @since 8/1/17.
 */
public class NoPrefixSet {

    // This solution is good enough to find the good or bad, but this doesn't satisfy to print
    // the first word, which made this set bad.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        List<String> words = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            words.add(sc.next());
        }

        Collections.sort(words);
        words.forEach(System.out::println);

        for (int i = 1; i < words.size(); i++) {
            if (words.get(i).startsWith(words.get(i-1))) {
                System.out.printf("BAD SET\n%s\n", words.get(i));
                return;
            }
        }
        System.out.println("GOOD SET");
        sc.close();
    }
}
