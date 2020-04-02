package everyday;

public class test1 {
    public static void main(String[] args) {
        System.out.println(reverseLeftWords("abcdefghijklm", 9));
    }

    public static String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder();
        String start = s.substring(n, s.length());
        String end = s.substring(0, n);
        sb.append(start).append(end);
        return sb.toString();
    }
}
