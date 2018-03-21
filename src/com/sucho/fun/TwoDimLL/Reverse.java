package com.sucho.fun.TwoDimLL;

/**
 * @author sucho
 * @since 2/27/18.
 */
public abstract class Reverse {
    abstract Node next(final Node n);
    abstract void next(final Node n1, final Node n2);

    Node reverse(final Node r) {
        Node p = null;
        Node c = r;
        Node t = null;
        while (c != null) {
            t = next(c);
            next(c, p);
            p = c;
            c = t;
        }

        return p;
    }
}
