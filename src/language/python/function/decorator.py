def log(func):
	def wrapper(*args,**kw):
		print("all %s()" % func.__name__)
		return func(*args,**kw)
	return wrapper

@log
def now():
	print('2018-9-1')


now()