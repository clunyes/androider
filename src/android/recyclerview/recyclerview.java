package android.recyclerview;

public class recyclerview {
    /**
     * 与listview的区别
     *
     * 1. RecyclerView 默认支持 线性布局、网格布局、瀑布流布局，可以横向
     * 2. Listview ViewHolder是需要自定义的，在RecyclerView中ViewHolder是已经封装好的
     * 3. recycleView是有动画的ItemAnimator，效果更好，增删item，listview没有动画
     * 4. recyclerview的缓存粒度更精细
     * 5. recyclerview可以局部刷新
     */

    /**
     * RecyclerView的缓存分为四级
     *
     *     Scrap Scrap对应ListView 的Active View，就是屏幕内的缓存数据
     *     Cache Cache 刚刚移出屏幕的缓存数据
     *     ViewCacheExtension 开发人员实现，不常用
     *     RecycledViewPool 当Cache缓存满了以后会根据FIFO（先进先出）的规则把Cache先缓存进去的ViewHolder移出并缓存到RecycledViewPool中，
     *     RecycledViewPool默认的缓存数量是5个
     *
     *
     */
}
