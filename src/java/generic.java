package java;

public class generic {
    /**
     *      ArrayList<Integer> list = new ArrayList<Integer>();
     *     		 list.add(111);
     *     		 list.add(222);
     *     		 Class clazz3 = Class.forName("java.util.ArrayList");//获取ArrayList的字节码文件
     *     		 Method m = clazz3.getMethod("add", Object.class);//获取add() 方法，Object.class 代表任意对象类型的数据
     *     		 m.invoke(list,"Hello");//通过反射添加字符串类型元素数据
     *     		 System.out.println(list);//运行结果：[111, 222, Hello]
     *
     * 上面代码通过反射给Integer类型的数组集合添加了一个“Hello”字符串类型的数据并且正常的将数组打印了出来；
     *
     * 这是没有报错的；说明泛型只是在java的编译期会产生错误但是在java的运行期（已经生成字节码文件后）是会被擦除的，这个期间并没泛型的存在；
     *
     *
     * 由此可见：泛型值存在于java的编译期，编译后生成字节码文件泛型是被擦除的；
     */
}
