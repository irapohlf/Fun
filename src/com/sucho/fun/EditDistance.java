package com.sucho.fun;

/**
 * @author sucho
 * @since 10/11/18.
 */
public class EditDistance {
    private char[] chs1;
    private char[] chs2;
    private int[][] distances;

    private EditDistance(String str1, String str2) {
        this.chs1 = str1.toCharArray();
        this.chs2 = str2.toCharArray();

        distances = new int[str1.length()][str2.length()];
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                distances[i][j] = -1;
            }
        }
    }

    private int editDistance(int id1, int id2) {
        if (id1 == this.chs1.length || id2 == this.chs2.length) {
            if (id1 == this.chs1.length && id2 == this.chs2.length) {
                return 0;
            }

            return (id1 == this.chs1.length)? (this.chs2.length - id2) : (this.chs1.length - id1);
        }

        if (this.distances[id1][id2] != -1) {
            return this.distances[id1][id2];
        }

        int dist = Math.min(editDistance(id1+1, id2+1) + ((this.chs1[id1] == this.chs2[id2])? 0 : 1),
                Math.min(editDistance(id1, id2+1), editDistance(id1+1, id2)) + 1);
        this.distances[id1][id2] = dist;
        return dist;
    }

    public static void main(String[] args) {
        System.out.println(new EditDistance("cat", "dog").editDistance(0, 0));
        System.out.println(new EditDistance("cat", "cats").editDistance(0, 0));
        System.out.println(new EditDistance("cat", "cut").editDistance(0, 0));
        System.out.println(new EditDistance("cat", "cast").editDistance(0, 0));
        System.out.println(new EditDistance("cat", "at").editDistance(0, 0));
        System.out.println(new EditDistance("cat", "act").editDistance(0, 0));
        System.out.println(new EditDistance("I am Sungje", "You are Jieun").editDistance(0, 0));
    }
}
