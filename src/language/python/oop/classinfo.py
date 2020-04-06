# print(type(123))
# print(type('name'))
# print(type(None))
# #如果要获得一个对象的所有属性和方法，可以使用dir()函数
# print(dir('name'))

class MyObject(object):
	def __init__(self):
		self.x = 9
	def  power(self):
		return self.x *self.x


obj = MyObject()
print(hasattr(obj,'x'))
print(obj.x)
print(hasattr(obj,'y'))
setattr(obj,'y',22)
print(hasattr(obj,'y'))
print(getattr(obj,'y'))
print(obj.y)