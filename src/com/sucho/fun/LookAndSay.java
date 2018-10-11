package com.sucho.fun;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sucho
 * @since 10/10/18.
 */
public class LookAndSay {
    private static List<Integer> lookAndSay(List<Integer> in) {
        List<Integer> ret = new ArrayList<>();

        int prev = 0;
        int count = 0;
        for (Integer val : in) {
            if (val == prev) {
                count++;
            } else {
                if (prev != 0) {
                    ret.add(count);
                    ret.add(prev);
                }

                prev = val;
                count = 1;
            }
        }
        ret.add(count);
        ret.add(prev);

        return ret;
    }

    public static void main(String[] args) {
        List<Integer> ret = new ArrayList<>();
        ret.add(1);

        for (int i = 0; i < 9; i++) {
            ret = lookAndSay(ret);
            for (Integer val : ret) {
                System.out.printf("%d", val);
            }
            System.out.println();
        }
    }
}
