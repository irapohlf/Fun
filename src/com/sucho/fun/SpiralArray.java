package com.sucho.fun;

/**
 * @author sucho
 * @since 10/10/18.
 */
public class SpiralArray {
    private int[][] array;

    public SpiralArray(int dim) {
        this.array = new int[dim][dim];
    }

    private int[][] spiral(int dim, int initial, int step) {
        if (dim <= 0) {
            return this.array;
        }

        for (int i = 0; i < dim; i++) {
            this.array[step][step + i] = initial + i;
        }

        for (int i = 1; i < dim; i++) {
            this.array[step + i][step + dim - 1] = initial + dim-1 + i;
        }

        for (int i = 1; i < dim; i++) {
            this.array[step + i][step] = (dim - 1) * 4 + 1 - i;
        }

        for (int i = 1; i < dim-1; i++) {
            this.array[step + dim - 1][step + i] = 3 * dim - 2 - i;
        }

        return spiral(dim-2, 1 + (dim-1) * 4, step+1);
    }

    /*
    input = 8
1 2 3 4 5 6 7 8
28 29 30 31 32 33 34 9
27 48 49 50 51 52 35 10
26 47 60 61 62 53 36 11
25 46 59 64 63 54 37 12
24 45 58 57 56 55 38 13
23 44 43 42 41 40 39 14
22 21 20 19 18 17 16 15
     */
    public static void main(String[] args) {
        int[][] ret = new SpiralArray(5).spiral(5, 1, 0);

        for (int[] aRet : ret) {
            for (int anARet : aRet) {
                System.out.printf("%02d ", anARet);
            }
            System.out.println();
        }
    }
}
