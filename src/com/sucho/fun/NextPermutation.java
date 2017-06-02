package com.sucho.fun;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author sucho
 * @since 6/1/17.
 */
public class NextPermutation {
    private static final String NO_ANSWER = "no answer";
    private List<String> words = new ArrayList<>();

    private void readLines() {
        Scanner sc = new Scanner(System.in);
        int numLines = Integer.parseInt(sc.next());

        if (numLines <= 0) {
            return;
        }

        for (int i = 0; i < numLines; i++) {
            words.add(sc.next());
        }
    }

    private void swap(final char[] chs, int from, int to) {
        char temp = chs[from];
        chs[from] = chs[to];
        chs[to] = temp;
    }

    private String nextWord(final String word) {
        char[] chs = word.toCharArray();

        int k = -1;
        for (int i = chs.length - 2; i >= 0; i--) {
            if (Character.getNumericValue(chs[i+1]) - Character.getNumericValue(chs[i]) > 0) {
                k = i;
                break;
            }
        }

        if (k == -1) {
            return NO_ANSWER;
        }

        int l = k + 1;
        for (int i = chs.length - 1; i > k; i--) {
            if (Character.getNumericValue(chs[i]) - Character.getNumericValue(chs[k]) > 0) {
                l = i;
                break;
            }
        }

        swap(chs, k, l);

        int start = k + 1;
        int end = chs.length - 1;
        while (start < end) {
            swap(chs, start++, end--);
        }

        return new String(chs);
    }

    private void printResult() {
        for (String word : this.words) {
            System.out.println(nextWord(word));
        }
    }

    public static void main(String[] args) {
        NextPermutation sol = new NextPermutation();

        try {
            sol.readLines();
        } catch (Exception ex) {
            System.out.println("Something went wrong!");
            return;
        }

        sol.printResult();
    }
}
