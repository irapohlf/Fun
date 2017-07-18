package com.sucho.fun;

import java.util.Scanner;

/**
 * @author sucho
 * @since 7/17/17.
 */
public class RandomNumberGenerator {
    private static void print(int nominator, int denominator) {
//        BigInteger nom = BigInteger.valueOf(nominator);
//        BigInteger den = BigInteger.valueOf(denominator);
//        BigInteger gcd = nom.gcd(den);
//        System.out.println(nom.divide(gcd).intValue() + "/" + den.divide(gcd).intValue());
        int gcd = gcd(nominator, denominator);
        System.out.println(nominator/gcd + "/" + denominator/gcd);
    }

    private static int gcd(int a, int b) {
        if (a > b) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        int remainder = b % a;
        if (remainder == 0) {
            return a;
        }
        return gcd(a, remainder);
    }

    private static void prob(int A, int B, int C) {
        if (C >= A + B) {
            System.out.println("1/1");
            return;
        }

        if (A > B) {
            int tmp = A;
            A = B;
            B = tmp;
        }

        int nomi = 0;
        int deno = 0;

        if (C <= A) {
            nomi = C * C;
            deno = 2 * A * B;
        } else if (C <= B) {
            nomi = (C + C - A) * A;
            deno = 2 * A * B;
        } else if (C <= A + B) {
            nomi = 2*C*(A+B)-A*A-B*B-C*C;
            deno = 2 * A * B;
        }
        print(nomi, deno);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        for (int n = 0; n < N; n++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();

            prob(A, B, C);
        }
        sc.close();
    }
}
