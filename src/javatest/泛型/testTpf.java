package javatest.泛型;

import java.util.ArrayList;

public class testTpf {

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        test(list1);
        ArrayList<String> list2 = new ArrayList<String>();
        test(list2);
    }

    public static void test(ArrayList<?> coll) {
    }

}
