# def enroll(name,gender,age=6,city='hangzhou'):
# 	print('name:',name)
# 	print('gender:',gender)
# 	print('age:',age)
# 	print('city:',city)

# enroll('康哥','男',20)
# enroll('鹤哥','男',city='温州')

# def add_end(L=None):
# 	if L is None:
# 		L = []
# 	L.append('END')
# 	return L

# print(add_end())
# print(add_end())
# print(add_end())
# def calc(*numbers):
# 	sum=0
# 	for n in numbers:
# 		sum += n*n
# 	return sum

# # print(calc([1,2,3]))
# print(calc(1,2,3))
# # print(calc((1,3,5)))
# print(calc(1, 2))
# nums = (1,2,3)
# print(calc(*nums))

def person(name,age,**kw):
	print('name:', name, 'age:', age, 'other:', kw)

person('kangge',20, city='hangzhou',techang='code')
# *args是可变参数，args接收的是一个tuple；

# **kw是关键字参数，kw接收的是一个dict。