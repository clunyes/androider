# filter()函数用于过滤序列。

def count():
	fs = []
	for i in list(range(1,4)):
		def  f():
			return i*i
		fs.append(f)
	return fs

f1,f2,f3 = count()

print(f1())
print(f2())
print(f3())

lambda x:x*x
def f(x):
	return x*x

print(list(map(lambda x: x * x, [1, 2, 3, 4, 5, 6, 7, 8, 9])))