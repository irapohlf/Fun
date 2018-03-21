package com.sucho.fun.TwoDimLL;

/**
 * @author sucho
 * @since 2/6/18.
 */
public class TwoDimLL extends TwoDim {
//    private Node reverseH(final Node r) {
//        Node p = null;
//        Node c = r;
//        Node t = null;
//        while (c != null) {
//            t = c.right;
//            c.right = p;
//            p = c;
//            c = t;
//        }
//
//        return p;
//    }
//
//    private Node reverseV(final Node r) {
//        Node p = null;
//        Node c = r;
//        Node t = null;
//        while (c != null) {
//            t = c.down;
//            c.down = p;
//            p = c;
//            c = t;
//        }
//
//        return p;
//    }

    Node reverse() {
        Reverse rh = new Reverse() {
            @Override
            Node next(Node n) {
                return n.right;
            }

            @Override
            void next(Node n1, Node n2) {
                n1.right = n2;
            }
        };
        Reverse rv = new Reverse() {
            Node next(Node n) {
                return n.down;
            }

            void next(Node n1, Node n2) {
                n1.down = n2;
            }
        };
        Node c = this.root.down;
        Node root = rh.reverse(this.root);
        while (c != null) {
            Node n = c.down;
            rh.reverse(c);
            //reverseH(c);
            c = n;
        }

        c = root.right;
        root = rv.reverse(root);
        while (c != null) {
            Node n = c.right;
            rv.reverse(c);
//            reverseV(c);
            c = n;
        }
        return root;
    }

    public static void main(String[] args) {
        TwoDimLL twoDimLL = new TwoDimLL();
        twoDimLL.generate(3, 4);
        twoDimLL.print();
        twoDimLL.print(twoDimLL.reverse());
    }
}
