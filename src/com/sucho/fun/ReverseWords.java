package com.sucho.fun;

import java.util.Scanner;

/**
 * @author sucho
 * @since 10/12/17.
 *
 * This is different from reverse string.
 * I am Sungje --> Sungje am I
 */
public class ReverseWords {
    private static String reverse(String str) {
        return new String(reverse(str.toCharArray(), 0, str.length()-1));
    }

    private static char[] reverse(char[] chs, int from, int to) {
        for (int i = from, j = to; i < j; i++, j--) {
            char temp = chs[i];
            chs[i] = chs[j];
            chs[j] = temp;
        }

        return chs;
    }

    private static String reverseWords(String str) {
        char[] chs = str.toCharArray();

        int start = 0;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == ' ') {
                reverse(chs, start, i-1);
                start = i+1;
            }
        }
        reverse(chs, start, chs.length-1);

        return new String(chs);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        System.out.println(line);

        String reversedLine = reverse(line.replaceAll("[^a-zA-Z ]", "").replaceAll("\\s+", "\\$").replaceAll("\\$", " "));
        System.out.println(reverseWords(reversedLine));

        sc.close();
    }
}
