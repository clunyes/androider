# 如果列表元素可以按照某种算法推算出来，那我们是否可以在循环的过程中不断推算出后续的元素呢？
# 这样就不必创建完整的list，从而节省大量的空间。在Python中，这种一边循环一边计算的机制，称为生成器：generator。
# L = [x*x for x in list(range(1,10))]
# print(L)
# g = (x*x for x in list(range(1,20)))
# for n in g:
# 	print(n)
# def fib(max):
# 	n,a,b = 0,0,1
# 	while n<max:
# 		print(b)
# 		a, b = b,a+b
# 		n+=1
# 	return 'done'

def fib(max):
	n,a,b = 0,0,1
	while n<max:
		yield b
		a, b = b,a+b
		n+=1
	return 'done'
# 这就是定义generator的另一种方法。如果一个函数定义中包含yield关键字，那么这个函数就不再是一个普通函数，而是一个generator：
f = fib(199)
print(f);

# 这里，最难理解的就是generator和函数的执行流程不一样。
# 函数是顺序执行，遇到return语句或者最后一行函数语句就返回。
# 而变成generator的函数，在每次调用next()的时候执行，遇到yield语句返回，再次执行时从上次返回的yield语句处继续执行。