package algorithms.查找;

/**
 * 二分查找
 *
 * 有序的序列，每次都是以序列的中间位置的数来与待查找的关键字进行比较，每次缩小一半的查找范围，直到匹配成功。
 */
public class binarySearch {

    /**
     * 二分法查找  ---循环的方式实现
     *
     * @param array 要查找的数组
     * @param aim 要查找的值
     * @return 返回值，成功返回索引，失败返回-1
     */
    private static int binarySearch(int[] array, int aim) {
        // 数组最小索引值
        int left = 0;
        // 数组最大索引值
        int right = array.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (aim < array[mid]) {
                // 若查找数值比中间值小，则以整个查找范围的前半部分作为新的查找范围
                right = mid - 1;
            } else if (aim > array[mid]) {
                // 若查找数值比中间值大，则以整个查找范围的后半部分作为新的查找范围
                left = mid + 1;
            } else {
                // 若查找数据与中间元素值正好相等，则放回中间元素值的索引
                return mid;
            }
        }
        return -1;
    }

    /**
     * 二分法查找 ---递归的方式
     *
     * @param array 要查找的数组
     * @param aim   要查找的值
     * @param left  左边最小值
     * @param right 右边最大值
     * @return 返回值，成功返回索引，失败返回-1
     */
    private static int binarySearch(int[] array, int aim, int left, int right) {
        if (aim < array[left] || aim > array[right]) {
            return -1;
        }
        // 找中间值
        int mid = (left + right) / 2;
        if (array[mid] == aim) {
            return mid;
        } else if (array[mid] > aim) {
            //如果中间值大于要找的值则从左边一半继续递归
            return binarySearch(array, aim, left, mid - 1);
        } else {
            //如果中间值小于要找的值则从右边一半继续递归
            return binarySearch(array, aim, mid + 1, array.length-1);
        }
    }
}
