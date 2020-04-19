package algorithms.leetcode;

public class 统计重复个数 {
    public static void main(String[] args) {
        getMaxRepetitions("aaa", 3, "aa", 1);
    }

    public static int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int l1 = c1.length;
        int l2 = c2.length;
        int in = 0;
        int n = 0;
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < l1; j++) {
                if (c1[j] == c2[in]) {
                    if (++in == l2) {
                        in = 0;
                        n++;
                    }
                }
            }
        }
        return n / n2;
    }
}
