classmates = ['张正鹤','张忠武']
# print(classmates)
classmates.append('王海飞')
# print(classmates)
print('第一个同学:'+classmates[0])
classmates.insert(0,"余近国")
print(classmates)
print('pop'+classmates.pop())
print(classmates)

# 另一种有序列表叫元组：tuple。tuple和list非常类似，但是tuple一旦初始化就不能修改，比如同样是列出同学的名字：
classmates2 = ('张正鹤','张忠武')
print(classmates2)