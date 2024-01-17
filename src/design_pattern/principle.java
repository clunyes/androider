package design_pattern;

public class principle {
    /**
     * 代码设计6大原则
     *
     * 1.单一职责原则（Single Responsibility Principle, SRP）
     *
     * 定义：一个类应只包含单一的职责。
     *
     *     一个类职责过大的话，首先引起的问题就是这个类比较大，显得过于臃肿，同时其复用性是比较差的。
     *     其次就是如果修改某个职责，有可能引起另一个职责发生错误。这是我们极力所避免的，因此设计一个类时我们应当去遵循单一职责原则。
     *
     * 2.开放封闭原则(Open - ClosedPrinciple ,OCP)
     *
     * 定义：一个模块、类、函数应当是对修改关闭，扩展开放。
     *
     *     修改原有的代码可能会导致原本正常的功能出现问题。
     *     因此，当需求有变化时，最好是通过扩展来实现，增加新的方法满足需求，而不是去修改原有代码。
     *
     * 3.里氏代换原则( Liskov Substitution Principle ,LSP )
     *
     * 定义：使用父类的地方能够使用子类来替换，反过来，则不行。
     *
     *     使用子类对象去替换父类对象，程序将不会产生错误
     *     因此在程序中尽量使用基类类型来对对象进行定义，而在运行时再确定其子类类型，用子类对象来替换父类对象。
     *     需要注意的是：
     *         子类的所有方法必须在父类中声明，或子类必须实现父类中声明的所有方法。如果一个方法只存在子类中，没有在父类中声明，则无法在以父类定义的对象中使用该方法。
     *         父类应当被尽量设计为抽象类或者接口，让子类继承父类或实现父接口，并实现在父类中声明的方法，运行时，子类实例替换父类实例，我们可以很方便地扩展系统的功能，同时无须修改原有子类的代码，增加新的功能可以通过增加一个新的子类来实现
     *
     * 4.依赖倒转原则( Dependence Inversion Principle ,DIP )
     *
     * 定义：抽象不应该依赖于细节，细节应当依赖于抽象。
     *
     *     即要面向接口编程，而不是面向具体实现去编程。
     *     高层模块不应该依赖低层模块，应该去依赖抽象。
     *
     * 5.接口隔离法则(Interface Segregation Principle，ISL）
     *
     * 定义：一个类对另一个类的依赖应该建立在最小的接口上。
     *
     *     一个类不应该依赖他不需要的接口。
     *     接口的粒度要尽可能小，如果一个接口的方法过多，可以拆成多个接口。
     *
     * 6.迪米特法则(Law of Demeter, LoD)
     *
     * 定义：一个类尽量不要与其他类发生关系
     *
     *     一个类对其他类知道的越少，耦合越小。
     *     当修改一个类时，其他类的影响就越小，发生错误的可能性就越小。
     *
     */
}
