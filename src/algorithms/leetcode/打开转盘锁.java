package algorithms.leetcode;

import java.util.*;

public class 打开转盘锁 {
    public int openLock(String[] deadends, String target) {
        int step = 0;//旋转次数
        //将deadends转为list，方便判断字符串是否是禁忌字符串
        List<String> list = Arrays.asList(deadends);
        Queue<String> queue = new LinkedList<>();//生成队列
        Set<String> used = new HashSet<>();//存放已经尝试过的密码值
        queue.add("0000");//初始密码，也就是根节点
        used.add("0000");//“0000”已经尝试，不再允许使用
        while (!queue.isEmpty()) {
            int size = queue.size();//队列长度
            for (int i = 0; i < size; i++) {
                String cur = queue.peek();//当前尝试的密码
                if (cur.equals(target)) {
                    return step;//如果当前密码与target相同，则成功，直接返回旋转次数
                }
                String[] neib = neighbour(cur);//生成邻居，也就是旋转一次之后可能的字符串
                for (String str1 : neib) {
                    //对邻居检查，如果没有使用过并且不是禁忌字符串，则放入队列
                    if (used.contains(str1) == false && list.contains(cur) == false) {
                        queue.add(str1);
                        used.add(str1);

                    }
                }
                queue.poll();//已经尝试过的上层节点释放
            }
            step = step + 1;
            //尝试结束之后部署+1;因为进入队列的数需要下一次循环才能判断是否是正确密码
        }
        return -1;//如果没有返回值说明打开失败
    }

    public String[] neighbour(String a) {
        //生成邻居，一个字符串有4位数字，每位数字可以增加1，或减少1，所以总共有4*2=8个邻居
        String ans[] = new String[8];
        for (int i = 0; i < 4; i++) {
            char[] aa = a.toCharArray();
            int a1 = aa[i] - '0';
            if (a1 != 0) {
                aa[i] = Character.forDigit(a1 - 1, 10);
            } else {
                aa[i] = '9';
            }
            ans[i * 2] = String.valueOf(aa);
            if (a1 != 9) {
                aa[i] = Character.forDigit(a1 + 1, 10);
            } else {
                aa[i] = '0';
            }
            ans[i * 2 + 1] = String.valueOf(aa);
        }
        return ans;
    }
}
