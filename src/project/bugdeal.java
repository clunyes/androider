package project;

public class bugdeal {
    /**
     * 难点处理
     * 1. TransactionTooLargeException
     *
     * 针对putExtra，putParcelable，putSerializable，onSaveInstanceState看看使用intent都传递了什么数据，
     * 重点看看有没有图片，视频或者比较复杂的对象，然后在用断点排查，
     * 找到了一些可能会出现此问题的地方，换成eventbus，或者采用新的viewmodel来保存数据
     *
     *
     *
     */
}
