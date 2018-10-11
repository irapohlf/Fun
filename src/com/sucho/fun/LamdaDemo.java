package com.sucho.fun;

/**
 * @author sucho
 * @since 4/4/18.
 */
public class LamdaDemo {
    @FunctionalInterface
    static interface FunctionalInterfaceExample {
        void run(String a, String b, String c);
    }

    public static void main(String[] args) {
        test((a, b, c) -> System.out.println(a+b+c), "I ", "doubt ", "if this works.");
    }

    public static void test(FunctionalInterfaceExample example, String a, String b, String c) {
        example.run(a, b, c);
    }
}
