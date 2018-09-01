class Student(object):
	def __init__(self,name,score):
		self.name = name
		self.score = score

	def print_score(self):
		print('%s,%s' % (self.name,self.score))


zhenghe = Student('张正鹤',50)
zhenghe.print_score()
zhenghe.age = 20
print('zhenghe  age =',zhenghe.age)
print(zhenghe)