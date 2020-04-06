class Student(object):
	 __slots__ = ('name', 'age') # 用tuple定义允许绑定的属性名称

	 # 使用__slots__要注意，__slots__定义的属性仅对当前类实例起作用，对继承的子类是不起作用的：
	 # 除非在子类中也定义__slots__，这样，子类实例允许定义的属性就是自身的__slots__加上父类的__slots__。

s = Student()
s.name = 'hege'
print(s.name)

def set_age(self,age):
	self.age = age


from types import MethodType
# s.set_age = MethodType(set_age,s)
# s.set_age(22)
# print(s.age)
Student.set_age = set_age

s2 = Student()
s2.set_age(555)
print(s2.age)