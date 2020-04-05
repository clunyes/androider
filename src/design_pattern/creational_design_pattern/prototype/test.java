package design_pattern.creational_design_pattern.prototype;

import java.util.HashMap;
import java.util.Map;

public class test {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        String a = "abc";
        String b = new String("abc");
        map.put(a, 1);
        map.put(b, 2);
        System.out.println(map.get(a));
        System.out.println(a == b);
    }
}
