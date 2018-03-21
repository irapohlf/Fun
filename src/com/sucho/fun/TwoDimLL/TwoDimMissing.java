package com.sucho.fun.TwoDimLL;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sucho
 * @since 2/7/18.
 */
public class TwoDimMissing extends TwoDimLL {
    private List<Node> hMissing = new ArrayList<>();
    private List<Node> vMissing = new ArrayList<>();

    private int connectsH() {
       int howMany = 0;

       Node cRow = this.root;
       while (cRow != null) {
           Node c = cRow;
           Node n = cRow.right;
           while (n != null) {
               if (c.down != null && n.down != null) {
                   if (c.down.right == null) {
                       howMany++;
                       hMissing.add(n);
                   }
                   c.down.right = n.down;
               }
               c = n;
               n = c.right;
           }
           cRow = cRow.down;
       }
       return howMany;
    }

    private int connectsV() {
        int howMany = 0;

        Node cCol = this.root;
        while (cCol != null) {
            Node c = cCol;
            Node n = cCol.down;
            while (n != null) {
                if (c.right != null && n.right != null) {
                    if (c.right.down == null) {
                        howMany++;
                        vMissing.add(n);
                    }
                    c.right.down = n.right;
                }
                c = n;
                n = c.down;
            }

            cCol = cCol.right;
        }
        return howMany;
    }

    private void connects() {
        int howMany;
        do {
            howMany = connectsH() + connectsV();
            System.out.println(">");
        } while (howMany > 0);
    }

    public static void main(String[] args) {
        TwoDimMissing twoDimMissing = new TwoDimMissing();
        twoDimMissing.generate(3, 4, true);
        twoDimMissing.print();
        twoDimMissing.connects();
        twoDimMissing.print();
        Node root = twoDimMissing.reverse();
        twoDimMissing.print(root);
        for (Node n : twoDimMissing.hMissing) {
            n.right = null;
        }
        for (Node n : twoDimMissing.vMissing) {
            n.down = null;
        }
        twoDimMissing.print(root);
    }
}
