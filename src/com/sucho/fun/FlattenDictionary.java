package com.sucho.fun;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sucho
 * @since 10/10/18.
 */
public class FlattenDictionary {
    private Map<String, Object> map = new HashMap<>();

    private FlattenDictionary(Map map) {
        this.map = map;
    }

    private void process(String prefix) {
        for (String key : this.map.keySet()) {
            Object obj = map.get(key);
            String newKey = prefix == null? key : prefix + "." + key;
            if (obj instanceof Map) {
                new FlattenDictionary((Map) obj).process(newKey);
            } else {
                System.out.println(newKey + ": " + obj.toString());
            }
        }
    }

    /*
    {
            "Key1" : "1",
            "Key2" : {
                "a" : "2",
                "b" : "3",
                "c" : {
                    "d" : "3",
                    "e" : {
                        "" : "1"
                    }
                }
            }
     }
     */
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> map1 = new HashMap<>();
        Map<String, Object> map2 = new HashMap<>();
        Map<String, Object> map3 = new HashMap<>();
        map.put("Key1", "1");
        map.put("Key2", map1);
        map1.put("a", "2");
        map1.put("b", "3");
        map1.put("c", map2);
        map2.put("d", "3");
        map2.put("e", map3);
        map3.put("", "1");

        new FlattenDictionary(map).process(null);
        System.out.println();
        new FlattenDictionary(map1).process(null);
        System.out.println();
        new FlattenDictionary(map2).process(null);
        System.out.println();
        new FlattenDictionary(map3).process(null);
    }
}
