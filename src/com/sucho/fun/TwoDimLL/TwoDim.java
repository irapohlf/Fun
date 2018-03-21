package com.sucho.fun.TwoDimLL;

/**
 * @author sucho
 * @since 2/7/18.
 */
public class TwoDim {
    Node root = null;

    void print() {
        print(this.root);
    }

    void print(final Node root) {
        Node n = root;
        System.out.println("=================>");
        while (n != null) {
            Node nn = n.down;
            do {
                System.out.printf("%s ", n.val);
                n = n.right;
            } while (n != null);
            System.out.println();

            n = nn;
        }
        System.out.println("<=================\n");
    }

    void generate(final int n, final int m) {
        generate(n, m, false);
    }

    void generate(final int n, final int m, final boolean isDeleted) {
        Node[][] nodes = new Node[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nodes[i][j] = new Node(String.format("(%d,%d)", i, j));
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nodes[i][j].right = (j+1 >= m)? null : nodes[i][j+1];
                nodes[i][j].down = (i+1 >= n)? null : nodes[i+1][j];
            }
        }

        this.root = nodes[0][0];

        if (isDeleted) {
            deleteLink(nodes, n, m);
        }
    }

    void deleteLink(final Node[][] nodes, final int n, final int m) {
        if (n <= 1 || m <= 1) {
            return;
        }

        int howMany = (int) (Math.random() * ((n-1) * m + n * (m-1) - n - m + 2));

        for (int i = 0; i < howMany; i++) {
            int h = (int) (Math.random() * 2);
            Node candi = nodes[(int) (Math.random() * (n-1) + 1)][(int) (Math.random() * (m-1) + 1)];
            if (h == 1) {
                candi.right = null;
            } else {
                candi.down = null;
            }
        }
    }
}
