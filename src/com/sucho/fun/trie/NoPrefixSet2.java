package com.sucho.fun.trie;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author sucho
 * @since 8/1/17.
 */
public class NoPrefixSet2 {

    private static Node root = new Node();

    private static class Node {
        String key;
        Node[] children;

        Node() {
            this.children = new Node[index('z')];
            this.key = null;
        }
    }

    private static int index(char ch) {
        return Character.getNumericValue(ch) - Character.getNumericValue('a');
    }

    private static boolean isOK(String word) {
        char[] chs = word.toCharArray();

        Node n = root;
        boolean isNew = false;
        for (char ch : chs) {
            int id = index(ch);
            if (n.children[id] == null) {
                n.children[id] = new Node();
                isNew = true;
            }
            n = n.children[id];
            if (n.key != null) {
                return false;
            }
        }
        n.key = word;

        return isNew;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        List<String> words = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            words.add(sc.next());
        }

        for (String word : words) {
            if (!isOK(word)) {
                System.out.printf("BAD SET\n%s\n", word);
                return;
            }
        }

        System.out.println("GOOD SET");

        sc.close();
    }
}
