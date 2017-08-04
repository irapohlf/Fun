package com.sucho.fun.trie;

import java.util.Scanner;

/**
 * @author sucho
 * @since 6/24/17.
 */
public class Contacts {
    class Node {
        String key;
        Node[] children;
        int numLeaves;

        Node() {
            this(null);
        }

        Node(String key) {
            this.key = key;
            children = new Node[26];
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            this.numLeaves = 0;
        }
    }

    Node root = new Node();

    int index(char ch) {
        return Character.getNumericValue(ch) - Character.getNumericValue('a');
    }

    void add(String str) {
        char[] chs = str.toCharArray();
        Node n = this.root;
        n.numLeaves++;
        for (char ch : chs) {
            int id = index(ch);
            if (n.children[id] == null) {
                n.children[id] = new Node();
            }
            n = n.children[id];
            n.numLeaves++;
        }
        n.key = str;
    }

    int countKey(Node n) {
//        int numKey = n.key == null? 0 : 1;
//        for (int i = 0; i < 26; i++) {
//            if (n.children[i] == null) {
//                continue;
//            }
//            numKey += countKey(n.children[i]);
//        }
//        return numKey;
        return n.numLeaves;
    }

    void find(String str) {
        char[] chs = str.toCharArray();
        Node n = this.root;
        for (char ch : chs) {
            int id = index(ch);
            if (n.children[id] == null) {
                System.out.println(0);
                return;
            }
            n = n.children[id];
        }

        System.out.println(countKey(n));
    }

    public static void main(String[] args) {
        Contacts contacts = new Contacts();

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            String command = sc.next();
            String str = sc.next();

            if (command.equals("add")) {
                contacts.add(str);
            } else {
                contacts.find(str);
            }
        }
        sc.close();
    }
}
