package arithmetic.归并;

public class 归并和快排的区别 {
    /**
     *
     *  可以发现，归并排序的处理过程是由下到上的，先处理子问题，然后再合并。
     *  而快排的处理过程是由上到下的，先分区，再处理子问题。
     *  归并虽然是稳定的、时间复杂度也和快排相同，但是它不是原地排序算法，
     *  因为它的合并函数无法在原地执行。而快排可以实现原地排序，解决了归并排序占用太多内存的问题。
     *
     */
}
