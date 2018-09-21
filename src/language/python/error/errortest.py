try:
	print('try')
	r = 10/0
	print('result:',r)
except ZeroDivisionError as e:
	print('exception:',e)
else:
	print('no error')
finally:
	print('finally')


# def foo(s):
#     return 10 / int(s)

# def bar(s):
#     return foo(s) * 2

# def main():
#     bar('0')

# main()
# show error
# 使用print和log日志来调试