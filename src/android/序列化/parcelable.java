package android.序列化;

public class parcelable {
    /**
     * Parcelable与Serializable的性能比较
     *
     * 首先Parcelable的性能要强于Serializable的原因我需要简单的阐述一下
     *
     *   1）. 在内存的使用中,前者在性能方面要强于后者
     *
     *   2）. 后者在序列化操作的时候会产生大量的临时变量,(原因是使用了反射机制)从而导致GC的频繁调用,因此在性能上会稍微逊色
     *
     *   3）. Parcelable是以Ibinder作为信息载体的.在内存上的开销比较小,因此在内存之间进行数据传递的时候,
     *   Android推荐使用Parcelable,既然是内存方面比价有优势,那么自然就要优先选择.
     *
     *   4）. 在读写数据的时候,Parcelable是在内存中直接进行读写,而Serializable是通过使用IO流的形式将数据读写入在硬盘上.
     *
     *   但是：虽然Parcelable的性能要强于Serializable,但是仍然有特殊的情况需要使用Serializable,而不去使用Parcelable,
     *   因为Parcelable无法将数据进行持久化,因此在将数据保存在磁盘的时候,仍然需要使用后者,因为前者无法很好的将数据进行持久化.
     *   (原因是在不同的Android版本当中,Parcelable可能会不同,因此数据的持久化方面仍然是使用Serializable)
     */
}
