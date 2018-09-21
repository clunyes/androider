class Animal(object):
	def run(self):
		print('animal 在run')

class Dog(Animal):
	def run(self):
		print('dog run')

	def eat(self):
		print('dog eat')

dog = Dog()
dog.run()
dog.eat()
# 对于静态语言（例如Java）来说，如果需要传入Animal类型，则传入的对象必须是Animal类型或者它的子类，否则，将无法调用run()方法。

# 对于Python这样的动态语言来说，则不一定需要传入Animal类型。我们只需要保证传入的对象有一个run()方法就可以了：

# 由于Python允许使用多重继承，因此，MixIn就是一种常见的设计。

# 只允许单一继承的语言（如Java）不能使用MixIn的设计。


class Animal(object):
    pass

# 大类:
class Mammal(Animal):
    pass

class Bird(Animal):
    pass

#类似java的接口
class Runnable(object):
    def run(self):
        print('Running...')

class Flyable(object):
    def fly(self):
        print('Flying...')

class Dog(Mammal, Runnable):
    pass
