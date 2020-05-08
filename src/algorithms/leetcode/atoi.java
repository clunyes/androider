package algorithms.leetcode;

public class atoi {
    /**
     * 字符串转换整数 (atoi)
     */
    public static int myAtoi(String str) {
        str = str.trim();
        char[] chars = str.toCharArray();
        int n = chars.length;
        int idx = 0;
        if (str.length() == 0) {
            //去掉前导空格以后到了末尾了
            return 0;
        }
        boolean negative = false;
        if (chars[idx] == '-') {
            //遇到负号
            negative = true;
            idx++;
        } else if (chars[idx] == '+') {
            // 遇到正号
            idx++;
        } else if (!Character.isDigit(chars[idx])) {
            // 其他符号
            return 0;
        }
        int ans = 0;
        while (idx < n && Character.isDigit(chars[idx])) {
            int digit = chars[idx] - '0';
            // 本来应该是 ans * 10 + digit > Integer.MAX_VALUE
            // 但是 *10 和 + digit 都有可能越界，所有都移动到右边去就可以了。
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 + digit;
            idx++;
        }
        return negative ? -ans : ans;
    }

    public static void main(String[] args) {
        myAtoi("2132131");
    }

}
