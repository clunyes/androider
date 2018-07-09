package arithmetic;

public class insertSort {
    public static void getInsertSort(int[] a) {
        if (a == null || a.length == 0) {//判断数组是否为空
            System.out.println("该数组为空！");
            return;
        }
        int n = a.length;//将数组的长度赋给n是为了防止每次for循环中判断时都调用length方法影响性能
        int temp;//放于for循环外面是为了防止重复创建变量
        int j;
        for (int i = 1; i < n; i++) {//排序的趟数
            temp = a[i];//赋给temp是为了防止索引i之前的元素向后移动覆盖了索引i的元素
            j = i - 1;
            for (; j >= 0 && a[j] > temp; --j) {//将大于i位置元素的元素向后移
                a[j + 1] = a[j];
            }
            a[j + 1] = temp;//找到i应该在的位置，将值放置此处
        }
    }

    public static void main(String[] args) {
        int[] a = {21, 32, 43, 98, 54, 45, 23, 4, 66, 86,66,45};
        getInsertSort(a);
        System.out.print("直接插入排序：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
