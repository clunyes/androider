package design_pattern.behavioral_design_pattern.templateMethod;
/**
 * 模板方法模式和Strategy模式都可以分离通用的算法和具体的上下文，所解决的问题是类似的，但是实现的方法不同，一个是用的继承，一个是用的委托。
 *
 * android中自定义view，实现ondraw。
 *
 * 1. View的draw()方法中定义了一整套的绘制流程，这个流程是固定的，所有的Android中的View都是按照这个流程来绘制的。
 * 其中drawBackground()这个方法在View类中是实现了具体过程的，而onDraw()方法和dispatchDraw()方法在View中都是空实现，即都是钩子方法。
 * 不同的子类通过重写这些空实现来实现自身不同的绘制效果。
 * 2. 具体的View，像TextView这些单一的View，就会重写onDraw()方法，由于TextView没有子View，所以dispatchDraw()还是空实现；
 * 而ViewGroup类含有子View，需要遍历子View并绘制，因此需要重写onDraw()和dispatchDraw()。
 * 3. 所以，我们自定义View时必须且只需重写onDraw（)；自定义ViewGroup时则需要重写onDraw()和dispatchDraw()。
 *
 *
 * Activity的生命周期也是模板方法
 */
