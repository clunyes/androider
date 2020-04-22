package algorithms.leetcode.合并K个排序链表;


public class 合并K个排序链表 {
    public static void main(String[] args) {


    }

    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;//每次待处理的链表个数
        if (len == 0) return null;//处理null

        while (len > 1) {
            int i;
            //两两合并，注意到这里将位置2i与2i+1的两个链表合并到位置i上。
            //如有不清楚的可以自己画个数组看看
            for (i = 0; i < len / 2; i++) {
                lists[i] = mergeTwoLists(lists[2 * i], lists[2 * i + 1]);
            }
            //处理奇数的情况。把最后一个链表放到下次待求解数组的末端，顺便解决向上取整的问题
            if ((len % 2) != 0) {
                lists[i] = lists[len - 1];
                len++;
            }

            //规模减半
            len /= 2;

        }

        return lists[0];
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode merge = head;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                merge.next = l2;
                return head.next;
            }
            if (l2 == null) {
                merge.next = l1;
                return head.next;
            }
            if (l1.val < l2.val) {
                merge.next = l1;
                l1 = l1.next;
            } else {
                merge.next = l2;
                l2 = l2.next;
            }
            merge = merge.next;
        }

        return head.next;
    }
}
