package com.sucho.fun;

/**
 * @author sucho
 * @since 4/6/18.
 */
public class FloatReader {

    private static float readFloat(String str) {
        if (str.contains("/")) {
            String[] strs = str.split("/");
            int val1 = Integer.valueOf(strs[0]);
            int val2 = Integer.valueOf(strs[1]);
            return (float) val1/val2;
        }
        return Float.valueOf(str);
    }

    private static float toFloat(String str) {
        String[] strs = str.split("[ ]+");
        if (strs.length == 1) {
            return readFloat(strs[0]);
        }
        float val1 = readFloat(strs[0]);
        float val2 = readFloat(strs[1]);
        return val1 < 0.0? val1 - val2 : val1 + val2;
    }

    public static void main(String[] args) {
        String str = "-3.4";
        System.out.println(toFloat(str));

        str = "1               3/4";
        System.out.println(toFloat(str));
        str = "-1               3/4";
        System.out.println(toFloat(str));

        str = "-3/4 1";
        System.out.println(toFloat(str));

        System.gc();
    }
}
