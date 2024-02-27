package algorithms.排序算法.堆排序;

public class HeapSort {
    /**
     * 堆概念及操作：堆结构更加重要！！！
     * 时间复杂度O(N*logN)
     * 空间复杂度O(1)
     * 不稳定
     */
    public int[] heapSort(int[] nums){
        if (nums == null || nums.length<=1) {
            return nums;
        }
        // O(NlogN)
        // for (int i=0; i<nums.length;i++) { //O(N)
        //     heapInsert(nums, i); //O(logN)
        // }
        //优化：Floyd建堆法 O(N)
        for (int i=nums.length-1; i>=0; i--) {
            heapify(nums, i, nums.length);
        }
        int heapsize = nums.length;
        swap1(nums, 0, --heapsize); //将第一位和最后一位进行交换，heapsize-1
        while (heapsize >0) { // O(N)
            heapify(nums, 0, heapsize); // O(logN)
            swap1(nums, 0, --heapsize);  // O(1)
        }
        return nums;
    }


    public void heapInsert(int[] nums, int index) { //在index位置插入新数
        while (nums[index] > nums[(index-1)/2]) {
            swap1(nums, index, (index-1)/2);
            index = (index-1)/2;
        }
    }

    public void heapify(int[] nums, int index, int heapsize) {
        //从index位置开始heapify，即index处的数变小后重新整理数组恢复为大根堆结构的过程
        int left = 2*index+1;
        while (left< heapsize) { //下方还有孩子的时候
            //储存子结点中更大的数的下标 (有右比大，没右左大)
            int larger = ((left+1<heapsize) && (nums[left+1]>nums[left])) ? (left+1) : left;
            //父节点和较大孩子之间进行比较
            int largest = nums[index]>nums[larger] ? index : larger;
            if (largest == index) { //若父节点已经比子节点都大，则大根堆结构已完成
                break;
            }
            swap1(nums, index, largest);
            index = largest;
            left = 2*index+1;
        }
    }

    /**
     * Description: 交换元素位置
     */
    private void swap1(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
